/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.controllers;

import fr.imie.kitmeal.beans.RecipeIngredientBean;
import fr.imie.kitmeal.interfacesServices.IRecipeIngredientService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thomasberthe
 */
@RestController
@RequestMapping(value = "/recipeIngredients")
public class RecipeIngredientController {

    @Autowired
    IRecipeIngredientService recipeIngredientService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<RecipeIngredientBean>> findAllRecipeIngredients(HttpSession session,
            HttpServletRequest request) {
        List<RecipeIngredientBean> beans = recipeIngredientService.findAllRecipeIngredients();

        return new ResponseEntity<List<RecipeIngredientBean>>(beans, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<RecipeIngredientBean> createRecipeIngredient(HttpSession session, @RequestBody RecipeIngredientBean bean,
            HttpServletRequest request) {
        recipeIngredientService.createRecipeIngredient(bean);

        return new ResponseEntity<RecipeIngredientBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{idRecipeIngredient}", method = RequestMethod.POST)
    public ResponseEntity<RecipeIngredientBean> updateRecipeIngredient(HttpSession session, @RequestBody RecipeIngredientBean bean,
            @PathVariable Integer idRecipeIngredient, HttpServletRequest request) {
        recipeIngredientService.updateRecipeIngredient(idRecipeIngredient, bean);

        return new ResponseEntity<RecipeIngredientBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/find/{idRecipeIngredient}", method = RequestMethod.GET)
    public ResponseEntity<RecipeIngredientBean> findRecipe(HttpSession session, @PathVariable Integer idRecipeIngredient,
            HttpServletRequest request) {
        RecipeIngredientBean bean = recipeIngredientService.findRecipeIngredient(idRecipeIngredient);

        return new ResponseEntity<RecipeIngredientBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/remove/{idRecipeIngredient}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeRecipe(HttpSession session, @PathVariable Integer idRecipeIngredient,
            HttpServletRequest request) {
        recipeIngredientService.removeRecipeIngredient(idRecipeIngredient);
    }
}
