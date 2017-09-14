/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.controllers;

import fr.imie.kitmeal.beans.UniteBean;
import fr.imie.kitmeal.beans.UserBean;
import fr.imie.kitmeal.interfacesServices.IUniteService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thomasberthe
 */
@RestController
@RequestMapping(value = "/unites")
public class UniteController {

    @Autowired
    IUniteService uniteService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView findAllUnites(HttpSession session,
            HttpServletRequest request) {

        if (session.getAttribute("user") != null) {
            UserBean user = (UserBean) session.getAttribute("user");
            if (("admin".equals(user.getRole()))) {
                List<UniteBean> beans = uniteService.findAllUnites();

                return new ModelAndView("/admin/unite/unite.jsp", "bean", beans);
            } else {
                return new ModelAndView("redirect:/app/home");
            }
        } else {
            return new ModelAndView("redirect:/app/log");
        }

    }

    @RequestMapping(value = "/create/{bean}", method = RequestMethod.POST)
    public ModelAndView createUnite(HttpSession session, UniteBean bean,
            HttpServletRequest request) {
        if (session.getAttribute("user") != null) {
            UserBean user = (UserBean) session.getAttribute("user");
            if (("admin".equals(user.getRole()))) {
                uniteService.createUnite(bean);

                return new ModelAndView("redirect:/app/unites");
            } else {
                return new ModelAndView("redirect:/app/home");
            }
        } else {
            return new ModelAndView("redirect:/app/log");
        }

    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView showCreateUnite(HttpSession session,
            HttpServletRequest request) {

        if (session.getAttribute("user") != null) {
            UserBean user = (UserBean) session.getAttribute("user");
            if (("admin".equals(user.getRole()))) {
                UniteBean bean = new UniteBean();

                return new ModelAndView("/admin/unite/create.jsp", "bean", bean);
            } else {
                return new ModelAndView("redirect:/app/home");
            }
        } else {
            return new ModelAndView("redirect:/app/log");
        }
    }

    @RequestMapping(value = "/update/{idUnite}/{bean}", method = RequestMethod.POST)
    public ModelAndView updateUnite(HttpSession session, UniteBean bean,
            @PathVariable Integer idUnite, HttpServletRequest request) {
        if (session.getAttribute("user") != null) {
            UserBean user = (UserBean) session.getAttribute("user");
            if (("admin".equals(user.getRole()))) {
                uniteService.updateUnite(idUnite, bean);

                return new ModelAndView("redirect:/app/unites");
            } else {
                return new ModelAndView("redirect:/app/home");
            }
        } else {
            return new ModelAndView("redirect:/app/log");
        }

    }

    @RequestMapping(value = "/update/{idUnite}", method = RequestMethod.GET)
    public ModelAndView showUpdateUnite(HttpSession session,
            @PathVariable Integer idUnite, HttpServletRequest request) {
        if (session.getAttribute("user") != null) {
            UserBean user = (UserBean) session.getAttribute("user");
            if (("admin".equals(user.getRole()))) {
                UniteBean bean = uniteService.findUnite(idUnite);

                return new ModelAndView("/admin/unite/update.jsp", "bean", bean);
            } else {
                return new ModelAndView("redirect:/app/home");
            }
        } else {
            return new ModelAndView("redirect:/app/log");
        }

    }

    @RequestMapping(value = "/find/{idUnite}", method = RequestMethod.GET)
    public ResponseEntity<UniteBean> findUnite(HttpSession session, @PathVariable Integer idUnite,
            HttpServletRequest request) {
        UniteBean bean = uniteService.findUnite(idUnite);

        return new ResponseEntity<UniteBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/remove/{idUnite}", method = RequestMethod.GET)
    public ModelAndView removeUnite(HttpSession session, @PathVariable Integer idUnite,
            HttpServletRequest request) {
        if (session.getAttribute("user") != null) {
            UserBean user = (UserBean) session.getAttribute("user");
            if (("admin".equals(user.getRole()))) {
                uniteService.removeUnite(idUnite);

                return new ModelAndView("redirect:/app/unites");
            } else {
                return new ModelAndView("redirect:/app/home");
            }
        } else {
            return new ModelAndView("redirect:/app/log");
        }

    }
}
