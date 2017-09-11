/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.controllers;

import fr.imie.kitmeal.beans.UserEventBean;
import fr.imie.kitmeal.interfacesServices.IUserEventService;
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

/**
 *
 * @author Laura
 */
@RestController
@RequestMapping(value = "/userEvents")
public class UserEventController {

    @Autowired
    IUserEventService userEventService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<UserEventBean>> findAllUserEvents(HttpSession session,
            HttpServletRequest request) {
        List<UserEventBean> beans = userEventService.findAllUserEvents();

        return new ResponseEntity<List<UserEventBean>>(beans, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<UserEventBean> createUserEvent(HttpSession session, @RequestBody UserEventBean bean,
            HttpServletRequest request) {
        userEventService.createUserEvent(bean);

        return new ResponseEntity<UserEventBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{idUserEvent}", method = RequestMethod.POST)
    public ResponseEntity<UserEventBean> updateUserEvent(HttpSession session, @RequestBody UserEventBean bean,
            @PathVariable Integer idUserEvent, HttpServletRequest request) {
        userEventService.updateUserEvent(idUserEvent, bean);

        return new ResponseEntity<UserEventBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/find/{idUserEvent}", method = RequestMethod.GET)
    public ResponseEntity<UserEventBean> findUserEvent(HttpSession session, @PathVariable Integer idUserEvent,
            HttpServletRequest request) {
        UserEventBean bean = userEventService.findUserEvent(idUserEvent);

        return new ResponseEntity<UserEventBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/remove/{idUserEvent}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeUserEvent(HttpSession session, @PathVariable Integer idUserEvent,
            HttpServletRequest request) {
        userEventService.removeUserEvent(idUserEvent);
    }

}
