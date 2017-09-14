/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.controllers;

import fr.imie.kitmeal.beans.EventBean;
import fr.imie.kitmeal.beans.RecipeBean;
import fr.imie.kitmeal.beans.UserBean;
import fr.imie.kitmeal.beans.UserEventBean;
import fr.imie.kitmeal.interfacesServices.IEventService;
import fr.imie.kitmeal.interfacesServices.IRecipeService;
import fr.imie.kitmeal.interfacesServices.IUserEventService;
import fr.imie.kitmeal.interfacesServices.IUserService;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thomasberthe
 */
@RestController
@RequestMapping(value = "/events")
public class EventController {

    @Autowired
    IEventService eventService;

    @Autowired
    IUserEventService userEventService;

    @Autowired
    IUserService userService;

    @Autowired
    IRecipeService recipeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView findAllEvents(HttpSession session,
            HttpServletRequest request) {
        if (session.getAttribute("user") != null) {
            List<EventBean> beans = eventService.findAllEvents();

            return new ModelAndView("/event/events.jsp", "bean", beans);
        } else {
            return new ModelAndView("redirect:/app/log");
        }

    }

    @RequestMapping(value = "/create/{bean}", method = RequestMethod.POST)
    public ModelAndView createEvent(HttpSession session, EventBean bean,
            HttpServletRequest request) {
        if (session.getAttribute("user") != null) {
            bean.setOrganisateur((UserBean) session.getAttribute("user"));
            eventService.createEvent(bean);

            return new ModelAndView("redirect:/app/events/create/users/" + bean.getIdEvent());
        } else {
            return new ModelAndView("redirect:/app/log");
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView showCreateEvent(HttpSession session,
            HttpServletRequest request) {
        if (session.getAttribute("user") != null) {
            EventBean bean = new EventBean();
            List<RecipeBean> list = recipeService.findAllRecipes();

            ModelAndView mav = new ModelAndView("/event/create.jsp");
            mav.addObject("bean", bean);
            mav.addObject("listRecipes", list);

            return mav;
        } else {
            return new ModelAndView("redirect:/app/log");
        }

    }

    @RequestMapping(value = "/create/users/{idEvent}", method = RequestMethod.GET)
    public ModelAndView showCreateUserEvent(HttpSession session,
            @PathVariable Integer idEvent, HttpServletRequest request) {
        if (session.getAttribute("user") != null) {
            List<UserBean> bean = userService.findAllUsers();

            ModelAndView mav = new ModelAndView("/event/createUser.jsp");
            mav.addObject("bean", bean);
            mav.addObject("idEvent", idEvent);

            return mav;
        } else {
            return new ModelAndView("redirect:/app/log");
        }

    }

    @RequestMapping(value = "/create/users/{idEvent}", method = RequestMethod.POST)
    public void createUserEvent(HttpSession session, @PathVariable Integer idEvent,
            @RequestParam("idUser") Integer idUser, @RequestParam("response") Boolean response,
            HttpServletRequest request) {

        if (session.getAttribute("user") != null) {
            EventBean event = eventService.findEvent(idEvent);
            UserBean user = userService.findUser(idUser);

            UserEventBean bean = new UserEventBean();
            bean.setEvent(event);
            bean.setUser(user);
            bean.setResponse(response);
            userEventService.createUserEvent(bean);
        }

    }

    @RequestMapping(value = "/update/{idEvent}/{bean}", method = RequestMethod.POST)
    public ModelAndView updateEvent(HttpSession session, EventBean bean, @PathVariable Integer idEvent,
            HttpServletRequest request) {
        if (session.getAttribute("user") != null) {
            UserBean user = (UserBean) session.getAttribute("user");
            if (user.getIdUser() == bean.getOrganisateur().getIdUser()) {
                eventService.updateEvent(idEvent, bean);
            }

            return new ModelAndView("redirect:/app/events/find/" + idEvent);
        } else {
            return new ModelAndView("redirect:/app/log");
        }

    }

    @RequestMapping(value = "/update/{idEvent}", method = RequestMethod.GET)
    public ModelAndView showUpdateEvent(HttpSession session,
            @PathVariable Integer idEvent, HttpServletRequest request) {
        if (session.getAttribute("user") != null) {
            UserBean user = (UserBean) session.getAttribute("user");
            EventBean bean = eventService.findEvent(idEvent);
            List<RecipeBean> list = recipeService.findAllRecipes();
            if (Objects.equals(user.getIdUser(), bean.getOrganisateur().getIdUser())) {
                ModelAndView mav = new ModelAndView("/event/update.jsp");
                mav.addObject("bean", bean);
                mav.addObject("listRecipes", list);

                return mav;
            } else {
                return new ModelAndView("redirect:/app/events/find/" + bean.getIdEvent());
            }
        } else {
            return new ModelAndView("redirect:/app/log");
        }

    }

    @RequestMapping(value = "/update/user/{idEvent}", method = RequestMethod.GET)
    public ModelAndView showUpdateUserEvent(HttpSession session,
            @PathVariable Integer idEvent, HttpServletRequest request) {
        if (session.getAttribute("user") != null) {
            List<UserEventBean> beans = userEventService.findByEvent(idEvent);

            return new ModelAndView("/event/updateUser.jsp", "bean", beans);
        } else {
            return new ModelAndView("redirect:/app/log");
        }

    }

    @RequestMapping(value = "/find/{idEvent}", method = RequestMethod.GET)
    public ModelAndView findEvent(HttpSession session, @PathVariable Integer idEvent,
            HttpServletRequest request) {
        if (session.getAttribute("user") != null) {
            EventBean event = eventService.findEvent(idEvent);
            List<UserEventBean> beans = userEventService.findByEvent(idEvent);

            ModelAndView mav = new ModelAndView("/event/show.jsp");
            mav.addObject("bean", event);
            mav.addObject("listUsers", beans);

            return mav;
        } else {
            return new ModelAndView("redirect:/app/log");
        }

    }

    @RequestMapping(value = "/remove/{idEvent}", method = RequestMethod.GET)
    public ModelAndView removeEvent(HttpSession session, @PathVariable Integer idEvent,
            HttpServletRequest request) {
        if (session.getAttribute("user") != null) {
            eventService.removeEvent(idEvent);

            return new ModelAndView("redirect:/app/events");
        } else {
            return new ModelAndView("redirect:/app/log");
        }

    }
}
