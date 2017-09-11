/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.dao;

import fr.imie.kitmeal.entities.UserIngredient;
import fr.imie.kitmeal.interfacesDao.IUserIngredientDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Laura
 */
@Repository
public class UserIngredientDao extends AbstractGenericDaoKitmeal<UserIngredient> implements IUserIngredientDao {

    @Override
    public List<UserIngredient> findAll() {
        String hql = "FROM UserIngredient";

        Query query = getSession().createQuery(hql);

        List<UserIngredient> userIngredients = (List<UserIngredient>) query.list();

        return userIngredients;
    }

}
