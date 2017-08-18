/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.dao;

import fr.imie.kitmeal.entities.User;
import fr.imie.kitmeal.interfacesDao.IUserDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Laura
 */
@Repository
public class UserDao extends AbstractGenericDaoKitmeal<User> implements IUserDao {

    @Override
    public List<User> findAll() {
        String hql = "FROM User";

        Query query = getSession().createQuery(hql);

        List<User> users = (List<User>) query.list();

        return users;
    }

}
