/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.services;

import fr.imie.kitmeal.beans.EventBean;
import fr.imie.kitmeal.entities.Event;
import fr.imie.kitmeal.interfacesDao.IEventDao;
import fr.imie.kitmeal.interfacesDao.IRecipeDao;
import fr.imie.kitmeal.interfacesDao.IUserDao;
import fr.imie.kitmeal.interfacesServices.IEventService;
import fr.imie.kitmeal.interfacesServices.IRecipeService;
import fr.imie.kitmeal.interfacesServices.IUserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author thomasberthe
 */
@Service
@Transactional(transactionManager = "txManagerKitmeal")
public class EventService implements IEventService {

    @Autowired
    private IEventDao eventDao;

    @Autowired
    IRecipeService recipeService;
    @Autowired
    IRecipeDao recipeDao;

    @Autowired
    IUserService userService;
    @Autowired
    IUserDao userDao;

    @Override
    public List<EventBean> findAllEvents() {
        List<Event> events = eventDao.findAll();
        List<EventBean> beans = new ArrayList<>();

        for (Event event : events) {
            EventBean bean = new EventBean();

            bean.setNom(event.getNom());
            bean.setDescription(event.getDescription());
            bean.setDateDebut(event.getDateDebut());
            bean.setDateFin(event.getDateFin());
            bean.setRecipe(recipeService.findRecipe(event.getRecipe().getIdRecipe()));
            bean.setOrganisateur(userService.findUser(event.getOrganisateur().getIdUser()));

            beans.add(bean);
        }

        return beans;
    }

    @Override
    public EventBean createEvent(EventBean bean) {
        Event event = new Event();
        event.setNom(bean.getNom());
        event.setDescription(bean.getDescription());
        event.setDateDebut(bean.getDateDebut());
        event.setDateFin(bean.getDateFin());
        event.setRecipe(recipeDao.find(bean.getRecipe().getIdRecipe()));
        event.setOrganisateur(userDao.find(bean.getOrganisateur().getIdUser()));

        eventDao.create(event);

        return bean;
    }

    @Override
    public EventBean updateEvent(Integer idEvent, EventBean bean) {
        Event event = eventDao.find(idEvent);

        event.setNom(bean.getNom());
        event.setDescription(bean.getDescription());
        event.setDateDebut(bean.getDateDebut());
        event.setDateFin(bean.getDateFin());
        event.setRecipe(recipeDao.find(bean.getRecipe().getIdRecipe()));
        event.setOrganisateur(userDao.find(bean.getOrganisateur().getIdUser()));

        eventDao.update(event);

        return bean;
    }

    @Override
    public EventBean findEvent(Integer idEvent) {
        Event event = eventDao.find(idEvent);

        EventBean bean = new EventBean();
        bean.setNom(event.getNom());
        bean.setDescription(event.getDescription());
        bean.setDateDebut(event.getDateDebut());
        bean.setDateFin(event.getDateFin());
        bean.setRecipe(recipeService.findRecipe(event.getRecipe().getIdRecipe()));
        bean.setOrganisateur(userService.findUser(event.getOrganisateur().getIdUser()));

        return bean;
    }

    @Override
    public void removeEvent(Integer idEvent) {
        eventDao.delete(eventDao.find(idEvent));
    }

}
