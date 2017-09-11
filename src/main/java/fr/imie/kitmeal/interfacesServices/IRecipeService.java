/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.interfacesServices;

import fr.imie.kitmeal.beans.RecipeBean;
import java.util.List;

/**
 *
 * @author thomasberthe
 */
public interface IRecipeService {

    public List<RecipeBean> findAllRecipes();

    public RecipeBean createRecipe(RecipeBean bean);

    public RecipeBean updateRecipe(Integer idRecipe, RecipeBean bean);

    public RecipeBean findRecipe(Integer idRecipe);

    public void removeRecipe(Integer idRecipe);
}
