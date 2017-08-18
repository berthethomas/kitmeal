/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author thomasberthe
 */
@Component
public abstract class AbstractGenericDaoKitmeal<T> extends AbstractGenericDao<T> {

    @Autowired
    @Qualifier("sessionFactoryKitmeal")

    private SessionFactory sessionFactory;

    @Override
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
