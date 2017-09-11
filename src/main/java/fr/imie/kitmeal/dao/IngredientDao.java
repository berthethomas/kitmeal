/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.dao;

import fr.imie.kitmeal.entities.Ingredient;
import fr.imie.kitmeal.interfacesDao.IIngredientDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author thomasberthe
 */
@Repository
public class IngredientDao extends AbstractGenericDaoKitmeal<Ingredient> implements IIngredientDao {

    @Override
    public List<Ingredient> findAll() {
        String hql = "FROM Ingredient";

        Query query = getSession().createQuery(hql);

        List<Ingredient> ingredients = (List<Ingredient>) query.list();

        return ingredients;
    }

}
