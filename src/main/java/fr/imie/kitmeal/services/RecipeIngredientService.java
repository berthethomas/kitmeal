/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.services;

import fr.imie.kitmeal.beans.RecipeIngredientBean;
import fr.imie.kitmeal.entities.Recipe;
import fr.imie.kitmeal.entities.RecipeIngredient;
import fr.imie.kitmeal.interfacesDao.IIngredientDao;
import fr.imie.kitmeal.interfacesDao.IRecipeDao;
import fr.imie.kitmeal.interfacesDao.IRecipeIngredientDao;
import fr.imie.kitmeal.interfacesServices.IIngredientService;
import fr.imie.kitmeal.interfacesServices.IRecipeIngredientService;
import fr.imie.kitmeal.interfacesServices.IRecipeService;
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
public class RecipeIngredientService implements IRecipeIngredientService {

    @Autowired
    private IRecipeIngredientDao recipeIngredientDao;

    @Autowired
    IRecipeService recipeService;
    @Autowired
    IRecipeDao recipeDao;

    @Autowired
    IIngredientService ingredientService;
    @Autowired
    IIngredientDao ingredientDao;

    @Override
    public List<RecipeIngredientBean> findAllRecipeIngredients() {
        List<RecipeIngredient> recipeIngredients = recipeIngredientDao.findAll();
        List<RecipeIngredientBean> beans = new ArrayList<>();

        for (RecipeIngredient recipeIngredient : recipeIngredients) {
            RecipeIngredientBean bean = new RecipeIngredientBean();

            bean.setIdRecipeIngredient(recipeIngredient.getIdRecipeIngredient());
            bean.setRecipe(recipeService.findRecipe(recipeIngredient.getRecipe().getIdRecipe()));
            bean.setIngredient(ingredientService.findIngredient(recipeIngredient.getIngredient().getIdIngredient()));
            bean.setQuantite(recipeIngredient.getQuantite());

            beans.add(bean);
        }

        return beans;
    }

    @Override
    public RecipeIngredientBean createRecipeIngredient(RecipeIngredientBean bean) {
        RecipeIngredient recipeIngredient = new RecipeIngredient();

        recipeIngredient.setIdRecipeIngredient(bean.getIdRecipeIngredient());
        recipeIngredient.setRecipe(recipeDao.find(bean.getRecipe().getIdRecipe()));
        recipeIngredient.setIngredient(ingredientDao.find(bean.getIngredient().getIdIngredient()));
        recipeIngredient.setQuantite(bean.getQuantite());

        recipeIngredientDao.create(recipeIngredient);

        return bean;
    }

    @Override
    public RecipeIngredientBean updateRecipeIngredient(Integer idRecipeIngredient, RecipeIngredientBean bean) {
        RecipeIngredient recipeIngredient = recipeIngredientDao.find(idRecipeIngredient);

        recipeIngredient.setIdRecipeIngredient(bean.getIdRecipeIngredient());
        recipeIngredient.setRecipe(recipeDao.find(bean.getRecipe().getIdRecipe()));
        recipeIngredient.setIngredient(ingredientDao.find(bean.getIngredient().getIdIngredient()));
        recipeIngredient.setQuantite(bean.getQuantite());

        recipeIngredientDao.update(recipeIngredient);

        return bean;
    }

    @Override
    public RecipeIngredientBean findRecipeIngredient(Integer idRecipeIngredient) {
        RecipeIngredient recipeIngredient = recipeIngredientDao.find(idRecipeIngredient);

        RecipeIngredientBean bean = new RecipeIngredientBean();

        bean.setIdRecipeIngredient(recipeIngredient.getIdRecipeIngredient());
        bean.setRecipe(recipeService.findRecipe(recipeIngredient.getRecipe().getIdRecipe()));
        bean.setIngredient(ingredientService.findIngredient(recipeIngredient.getIngredient().getIdIngredient()));
        bean.setQuantite(recipeIngredient.getQuantite());

        return bean;
    }

    @Override
    public void removeRecipeIngredient(Integer idRecipeIngredient) {
        recipeIngredientDao.delete(recipeIngredientDao.find(idRecipeIngredient));
    }

    @Override
    public List<RecipeIngredientBean> findByRecipe(Integer idRecipe) {

        List<RecipeIngredient> data = recipeIngredientDao.findByRecipe(idRecipe);

        List<RecipeIngredientBean> beans = new ArrayList<>();

        if (data != null) {
            for (RecipeIngredient val : data) {
                RecipeIngredientBean bean = new RecipeIngredientBean();
                bean.setIdRecipeIngredient(val.getIdRecipeIngredient());
                bean.setRecipe(recipeService.findRecipe(val.getRecipe().getIdRecipe()));
                bean.setIngredient(ingredientService.findIngredient(val.getIngredient().getIdIngredient()));
                bean.setQuantite(val.getQuantite());

                beans.add(bean);
            }
            return beans;
        } else {
            return null;
        }

    }

}
