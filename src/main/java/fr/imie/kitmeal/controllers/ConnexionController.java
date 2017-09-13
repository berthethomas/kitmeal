/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.controllers;

import fr.imie.kitmeal.beans.EventBean;
import fr.imie.kitmeal.beans.UserBean;
import fr.imie.kitmeal.interfacesServices.IEventService;
import fr.imie.kitmeal.interfacesServices.IUserService;
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
@RequestMapping(value = "")
public class ConnexionController {

    @Autowired
    IUserService userService;
    
// verificaton si connexion
    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public ModelAndView ifConnect(HttpSession session) {
        //if(session.getAttribute("user") != null){
              //log.setTrigramme((String) session.getAttribute("user"));
              //return new ModelAndView("/home/home.jsp");
          //}else {
              return new ModelAndView("/home/login.jsp");
         // }

        
    }

    // connexion
    @RequestMapping(value = "/login/{bean}", method = RequestMethod.POST)
    public ModelAndView log(HttpSession session, UserBean bean,
            HttpServletRequest request) {
        System.err.println("cest iciiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        UserBean user = userService.connect(bean);
        System.err.println(user);
        if(user != null){
            session.setAttribute("user", user);
            
        }else{
            return new ModelAndView("/home/login.jsp");
        }

        return new ModelAndView("redirect:/app/home");
    }
    
    // deconnexion
    /*@RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity<EventBean> createEvent(HttpSession session, @RequestBody EventBean bean,
            HttpServletRequest request) {
        eventService.createEvent(bean);

        return new ResponseEntity<EventBean>(bean, HttpStatus.OK);
    }*/
    
    //home
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public ModelAndView showHome(HttpSession session, @RequestBody EventBean bean,
            HttpServletRequest request) {
        

        return new ModelAndView("/contacts/contacts.jsp");
    }

    
}
