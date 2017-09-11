/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.services;

import fr.imie.kitmeal.beans.IngredientBean;
import fr.imie.kitmeal.entities.Ingredient;
import fr.imie.kitmeal.interfacesDao.IIngredientDao;
import fr.imie.kitmeal.interfacesServices.IIngredientService;
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
public class IngredientService implements IIngredientService {

    @Autowired
    private IIngredientDao ingredientDao;

    @Override
    public List<IngredientBean> findAllIngredients() {
        List<Ingredient> ingredients = ingredientDao.findAll();
        List<IngredientBean> beans = new ArrayList<>();

        for (Ingredient ingredient : ingredients) {
            IngredientBean bean = new IngredientBean();

            bean.setNom(ingredient.getNom());

            beans.add(bean);
        }

        return beans;
    }

    @Override
    public IngredientBean createIngredient(IngredientBean bean) {
        Ingredient ingredient = new Ingredient();
        ingredient.setNom(bean.getNom());

        ingredientDao.create(ingredient);

        return bean;
    }

    @Override
    public IngredientBean updateIngredient(Integer idIngredient, IngredientBean bean) {
        Ingredient ingredient = ingredientDao.find(idIngredient);

        ingredient.setNom(bean.getNom());

        ingredientDao.update(ingredient);

        return bean;
    }

    @Override
    public IngredientBean findIngredient(Integer idIngredient) {
        Ingredient ingredient = ingredientDao.find(idIngredient);

        IngredientBean bean = new IngredientBean();
        bean.setNom(ingredient.getNom());

        return bean;
    }

    @Override
    public void removeIngredient(Integer idIngredient) {
        ingredientDao.delete(ingredientDao.find(idIngredient));
    }

}
