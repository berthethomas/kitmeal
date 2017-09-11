/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.controllers;

import fr.imie.kitmeal.beans.EventBean;
import fr.imie.kitmeal.interfacesServices.IEventService;
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
 * @author thomasberthe
 */
@RestController
@RequestMapping(value = "/events")
public class EventController {

    @Autowired
    IEventService eventService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<EventBean>> findAllEvents(HttpSession session,
            HttpServletRequest request) {
        List<EventBean> beans = eventService.findAllEvents();

        return new ResponseEntity<List<EventBean>>(beans, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<EventBean> createEvent(HttpSession session, @RequestBody EventBean bean,
            HttpServletRequest request) {
        eventService.createEvent(bean);

        return new ResponseEntity<EventBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{idEvent}", method = RequestMethod.POST)
    public ResponseEntity<EventBean> updateEvent(HttpSession session, @RequestBody EventBean bean,
            @PathVariable Integer idEvent, HttpServletRequest request) {
        eventService.updateEvent(idEvent, bean);

        return new ResponseEntity<EventBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/find/{idEvent}", method = RequestMethod.GET)
    public ResponseEntity<EventBean> findEvent(HttpSession session, @PathVariable Integer idEvent,
            HttpServletRequest request) {
        EventBean bean = eventService.findEvent(idEvent);

        return new ResponseEntity<EventBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/remove/{idEvent}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeEvent(HttpSession session, @PathVariable Integer idEvent,
            HttpServletRequest request) {
        eventService.removeEvent(idEvent);
    }
}
