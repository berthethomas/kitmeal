/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.controllers;

import fr.imie.kitmeal.beans.IngredientBean;
import fr.imie.kitmeal.beans.RecipeBean;
import fr.imie.kitmeal.beans.RecipeIngredientBean;
import fr.imie.kitmeal.interfacesServices.IIngredientService;
import fr.imie.kitmeal.interfacesServices.IRecipeIngredientService;
import fr.imie.kitmeal.interfacesServices.IRecipeService;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
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

    @Autowired
    IRecipeIngredientService recipeIngredientService;

    @Autowired
    IIngredientService ingredientService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView findAllRecipes(HttpSession session,
            HttpServletRequest request) {
        List<RecipeBean> beans = recipeService.findAllRecipes();

        return new ModelAndView("/recipe/showAll.jsp", "bean", beans);
    }

    @RequestMapping(value = "/create/{bean}", method = RequestMethod.POST)
    public ModelAndView createRecipe(HttpSession session, RecipeIngredientBean bean,
            HttpServletRequest request) {
         System.err.println("TOTOTOTOTOTOTOTOOTOTOTOTOTOTOTOTOTOOTOTOTOTOTOTO");

         
        System.err.println(request.getAttributeNames());
        recipeIngredientService.createRecipeIngredient(bean);

        return new ModelAndView("redirect:/app/recipes");
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView showCreateRecipe(HttpSession session,
            HttpServletRequest request) {
        RecipeIngredientBean bean = new RecipeIngredientBean();

        List<IngredientBean> ingredients = ingredientService.findAllIngredients();

        ModelAndView mav = new ModelAndView("/recipe/create.jsp");
        mav.addObject("bean", bean);
        mav.addObject("ingredients", ingredients);

        return mav;
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
    public ModelAndView findRecipe(HttpSession session, @PathVariable Integer idRecipe,
            HttpServletRequest request) {
        RecipeBean bean = recipeService.findRecipe(idRecipe);

        return new ModelAndView("/recipe/show.jsp", "bean", bean);
    }

    @RequestMapping(value = "/remove/{idRecipe}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeRecipe(HttpSession session, @PathVariable Integer idRecipe,
            HttpServletRequest request) {
        recipeService.removeRecipe(idRecipe);
    }
}
