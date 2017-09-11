/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.services;

import fr.imie.kitmeal.beans.UserEventBean;
import fr.imie.kitmeal.entities.UserEvent;
import fr.imie.kitmeal.interfacesDao.IEventDao;
import fr.imie.kitmeal.interfacesDao.IUserDao;
import fr.imie.kitmeal.interfacesDao.IUserEventDao;
import fr.imie.kitmeal.interfacesServices.IEventService;
import fr.imie.kitmeal.interfacesServices.IUserEventService;
import fr.imie.kitmeal.interfacesServices.IUserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Laura
 */
@Service
@Transactional(transactionManager = "txManagerKitmeal")
public class UserEventService implements IUserEventService {

    @Autowired
    private IUserEventDao userEventDao;

    @Autowired
    IUserService userService;
    @Autowired
    IUserDao userDao;

    @Autowired
    IEventService eventService;
    @Autowired
    IEventDao eventDao;

    @Override
    public List<UserEventBean> findAllUserEvents() {
        List<UserEvent> userEvents = userEventDao.findAll();
        List<UserEventBean> beans = new ArrayList<>();

        for (UserEvent userEvent : userEvents) {
            UserEventBean bean = new UserEventBean();

            bean.setIdUserEvent(userEvent.getIdUserEvent());
            bean.setResponse(userEvent.isResponse());
            bean.setEvent(eventService.findEvent(userEvent.getEvent().getIdEvent()));
            bean.setUser(userService.findUser(userEvent.getUser().getIdUser()));

            beans.add(bean);
        }

        return beans;
    }

    @Override
    public UserEventBean createUserEvent(UserEventBean bean) {
        UserEvent userEvent = new UserEvent();

        userEvent.setResponse(bean.isResponse());
        userEvent.setEvent(eventDao.find(bean.getEvent().getIdEvent()));
        userEvent.setUser(userDao.find(bean.getUser().getIdUser()));

        userEventDao.create(userEvent);

        return bean;
    }

    @Override
    public UserEventBean updateUserEvent(Integer idUserEvent, UserEventBean bean) {
        UserEvent userEvent = userEventDao.find(idUserEvent);

        userEvent.setResponse(bean.isResponse());
        userEvent.setEvent(eventDao.find(bean.getEvent().getIdEvent()));
        userEvent.setUser(userDao.find(bean.getUser().getIdUser()));

        userEventDao.update(userEvent);

        return bean;
    }

    @Override
    public UserEventBean findUserEvent(Integer idUserEvent) {
        UserEvent userEvent = userEventDao.find(idUserEvent);

        UserEventBean bean = new UserEventBean();

        bean.setIdUserEvent(userEvent.getIdUserEvent());
        bean.setResponse(userEvent.isResponse());
        bean.setEvent(eventService.findEvent(userEvent.getEvent().getIdEvent()));
        bean.setUser(userService.findUser(userEvent.getUser().getIdUser()));

        return bean;
    }

    @Override
    public void removeUserEvent(Integer idUserEvent) {
        userEventDao.delete(userEventDao.find(idUserEvent));
    }

}
