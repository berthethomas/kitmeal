/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.dao;

import fr.imie.kitmeal.entities.RecipeIngredient;
import fr.imie.kitmeal.interfacesDao.IRecipeIngredientDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author thomasberthe
 */
@Repository
public class RecipeIngredientDao extends AbstractGenericDaoKitmeal<RecipeIngredient> implements IRecipeIngredientDao {

    @Override
    public List<RecipeIngredient> findAll() {
        String hql = "FROM RecipeIngredient";

        Query query = getSession().createQuery(hql);

        List<RecipeIngredient> recipeIngredients = (List<RecipeIngredient>) query.list();

        return recipeIngredients;
    }

    @Override
    public List<RecipeIngredient> findByRecipe(Integer idRecipe) {
        String hql = "from RecipeIngredient r "
                + "where r.recipe = :idRecipe ";

        Query query = getSession().createQuery(hql);
        query.setInteger("idRecipe", idRecipe);
        List<RecipeIngredient> results = (List<RecipeIngredient>) query.list();
        System.err.println(results);
        return results;
    }

}
