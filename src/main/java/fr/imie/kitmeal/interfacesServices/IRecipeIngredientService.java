/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.interfacesServices;

import fr.imie.kitmeal.beans.RecipeIngredientBean;
import java.util.List;

/**
 *
 * @author thomasberthe
 */
public interface IRecipeIngredientService {

    public List<RecipeIngredientBean> findAllRecipeIngredients();

    public RecipeIngredientBean createRecipeIngredient(RecipeIngredientBean bean);

    public RecipeIngredientBean updateRecipeIngredient(Integer idRecipeIngredient, RecipeIngredientBean bean);

    public RecipeIngredientBean findRecipeIngredient(Integer idRecipeIngredient);

    public List<RecipeIngredientBean> findByRecipe(Integer idRecipe);

    public void removeRecipeIngredient(Integer idRecipeIngredient);
}
