/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.controllers;

import fr.imie.kitmeal.beans.RecipeBean;
import fr.imie.kitmeal.interfacesServices.IRecipeService;
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
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thomasberthe
 */
@RestController
@RequestMapping(value = "/recipes")
public class RecipeController {

    @Autowired
    IRecipeService recipeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<RecipeBean>> findAllRecipes(HttpSession session,
            HttpServletRequest request) {
        List<RecipeBean> beans = recipeService.findAllRecipes();

        return new ResponseEntity<List<RecipeBean>>(beans, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<RecipeBean> createRecipe(HttpSession session, @RequestBody RecipeBean bean,
            HttpServletRequest request) {
        recipeService.createRecipe(bean);

        return new ResponseEntity<RecipeBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView showCreateRecipe(HttpSession session,
            HttpServletRequest request) {
        RecipeBean bean = new RecipeBean();

        return new ModelAndView("/", "bean", bean);
    }

    @RequestMapping(value = "/update/{idRecipe}", method = RequestMethod.POST)
    public ResponseEntity<RecipeBean> updateRecipe(HttpSession session, @RequestBody RecipeBean bean,
            @PathVariable Integer idRecipe, HttpServletRequest request) {
        recipeService.updateRecipe(idRecipe, bean);

        return new ResponseEntity<RecipeBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{idRecipe}", method = RequestMethod.GET)
    public ModelAndView showUpdateRecipe(HttpSession session,
            @PathVariable Integer idRecipe, HttpServletRequest request) {
        RecipeBean bean = recipeService.findRecipe(idRecipe);

        return new ModelAndView("/", "bean", bean);
    }

    @RequestMapping(value = "/find/{idRecipe}", method = RequestMethod.GET)
    public ResponseEntity<RecipeBean> findRecipe(HttpSession session, @PathVariable Integer idRecipe,
            HttpServletRequest request) {
        RecipeBean bean = recipeService.findRecipe(idRecipe);

        return new ResponseEntity<RecipeBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/remove/{idRecipe}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeRecipe(HttpSession session, @PathVariable Integer idRecipe,
            HttpServletRequest request) {
        recipeService.removeRecipe(idRecipe);
    }
}
