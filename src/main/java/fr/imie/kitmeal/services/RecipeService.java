/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.services;

import fr.imie.kitmeal.beans.RecipeBean;
import fr.imie.kitmeal.entities.Recipe;
import fr.imie.kitmeal.interfacesDao.IRecipeDao;
import fr.imie.kitmeal.interfacesDao.IUserDao;
import fr.imie.kitmeal.interfacesServices.IRecipeService;
import fr.imie.kitmeal.interfacesServices.IUserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author thomasberthe
 */
@Service
@Transactional(transactionManager = "txManagerKitmeal")
public class RecipeService implements IRecipeService {

    @Autowired
    private IRecipeDao recipeDao;

    @Autowired
    IUserService userService;
    @Autowired
    IUserDao userDao;

    @Override
    public List<RecipeBean> findAllRecipes() {
        List<Recipe> recipes = recipeDao.findAll();
        List<RecipeBean> beans = new ArrayList<>();

        for (Recipe recipe : recipes) {
            RecipeBean bean = new RecipeBean();

            bean.setIdRecipe(recipe.getIdRecipe());
            bean.setNom(recipe.getNom());
            bean.setDescription(recipe.getDescription());
            bean.setUser(userService.findUser(recipe.getUser().getIdUser()));

            beans.add(bean);
        }

        return beans;
    }

    @Override
    public RecipeBean createRecipe(RecipeBean bean) {
        Recipe recipe = new Recipe();

        recipe.setIdRecipe(bean.getIdRecipe());
        recipe.setNom(bean.getNom());
        recipe.setDescription(bean.getDescription());
        recipe.setUser(userDao.find(bean.getUser().getIdUser()));

        recipeDao.create(recipe);

        return bean;
    }

    @Override
    public RecipeBean updateRecipe(Integer idRecipe, RecipeBean bean) {
        Recipe recipe = recipeDao.find(idRecipe);

        recipe.setIdRecipe(bean.getIdRecipe());
        recipe.setNom(bean.getNom());
        recipe.setDescription(bean.getDescription());
        recipe.setUser(userDao.find(bean.getUser().getIdUser()));

        recipeDao.update(recipe);

        return bean;
    }

    @Override
    public RecipeBean findRecipe(Integer idRecipe) {
        Recipe recipe = recipeDao.find(idRecipe);

        RecipeBean bean = new RecipeBean();

        bean.setIdRecipe(recipe.getIdRecipe());
        bean.setNom(recipe.getNom());
        bean.setDescription(recipe.getDescription());
        bean.setUser(userService.findUser(recipe.getUser().getIdUser()));

        return bean;
    }

    @Override
    public void removeRecipe(Integer idRecipe) {
        recipeDao.delete(recipeDao.find(idRecipe));
    }

}
