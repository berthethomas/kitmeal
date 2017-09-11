/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.dao;

import fr.imie.kitmeal.entities.Recipe;
import fr.imie.kitmeal.interfacesDao.IRecipeDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author thomasberthe
 */
@Repository
public class RecipeDao extends AbstractGenericDaoKitmeal<Recipe> implements IRecipeDao {

    @Override
    public List<Recipe> findAll() {
        String hql = "FROM Recipe";

        Query query = getSession().createQuery(hql);

        List<Recipe> recipes = (List<Recipe>) query.list();

        return recipes;
    }

}
