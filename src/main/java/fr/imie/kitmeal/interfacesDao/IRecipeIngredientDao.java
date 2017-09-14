/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.interfacesDao;

import fr.imie.kitmeal.entities.RecipeIngredient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author thomasberthe
 */
public interface IRecipeIngredientDao extends IGenericDao<Serializable, RecipeIngredient> {

    public List<RecipeIngredient> findByRecipe(Integer idRecipe);
}
