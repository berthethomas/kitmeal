/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.dao;

import fr.imie.kitmeal.entities.UserEvent;
import fr.imie.kitmeal.interfacesDao.IUserEventDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Laura
 */
@Repository
public class UserEventDao extends AbstractGenericDaoKitmeal<UserEvent> implements IUserEventDao {

    @Override
    public List<UserEvent> findAll() {
        String hql = "FROM UserEvent";

        Query query = getSession().createQuery(hql);

        List<UserEvent> userEvents = (List<UserEvent>) query.list();

        return userEvents;
    }

}
