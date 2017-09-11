/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.dao;

import fr.imie.kitmeal.entities.Event;
import fr.imie.kitmeal.interfacesDao.IEventDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author thomasberthe
 */
@Repository
public class EventDao extends AbstractGenericDaoKitmeal<Event> implements IEventDao {

    @Override
    public List<Event> findAll() {
        String hql = "FROM Event";

        Query query = getSession().createQuery(hql);

        List<Event> events = (List<Event>) query.list();

        return events;
    }

}
