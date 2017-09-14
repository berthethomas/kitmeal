/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.controllers;

import fr.imie.kitmeal.beans.CategoryBean;
import fr.imie.kitmeal.beans.IngredientBean;
import fr.imie.kitmeal.beans.UniteBean;
import fr.imie.kitmeal.beans.UserIngredientBean;
import fr.imie.kitmeal.interfacesServices.ICategoryService;
import fr.imie.kitmeal.interfacesServices.IIngredientService;
import fr.imie.kitmeal.interfacesServices.IUniteService;
import fr.imie.kitmeal.interfacesServices.IUserIngredientService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Laura
 */
@RestController
@RequestMapping(value = "/userIngredients")
public class UserIngredientController {

    @Autowired
    IUserIngredientService userIngredientService;
    
    @Autowired
    IIngredientService ingredientService;
    
    @Autowired
    ICategoryService categoryService;
    
    @Autowired
    IUniteService uniteService;
    
    

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView findAllUserIngredients(HttpSession session,
            HttpServletRequest request) {
        List<UserIngredientBean> beans = userIngredientService.findAllUserIngredients();

        return new ModelAndView("/frigo/showAll.jsp", "bean", beans);
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView showCreateIngredient(HttpSession session,
            HttpServletRequest request) {
        IngredientBean bean = new IngredientBean();
        List<CategoryBean> beanCategory = categoryService.findAllCategories();
        List<UniteBean> beanUnity = uniteService.findAllUnites();
        
        ModelAndView mav = new ModelAndView("/frigo/create.jsp");
        mav.addObject("bean", bean);
        mav.addObject("unite", beanUnity);
        mav.addObject("category", beanCategory);

        return mav;
        //return new ModelAndView("/frigo/create.jsp", "bean", bean);
    }
    
    @RequestMapping(value = "/create/{bean}", method = RequestMethod.POST)
    public ModelAndView createIngredient(HttpSession session, IngredientBean bean,
            HttpServletRequest request) {
        IngredientBean ingredient = ingredientService.createIngredient(bean);

        return new ModelAndView("redirect:/app/userIngredients");
    }

    @RequestMapping(value = "/create/ingredients", method = RequestMethod.GET)
    public ModelAndView showaddIngredientFrigo(HttpSession session,
             HttpServletRequest request) {
        List<IngredientBean> bean = ingredientService.findAllIngredients();

        ModelAndView mav = new ModelAndView("/frigo/form.jsp");
        mav.addObject("bean", bean);
        System.err.println("testttttt");
        System.err.println(bean);
        //mav.addObject("idRecipe", idRecipe);

        return mav;
    }

    @RequestMapping(value = "/create/ingredient", method = RequestMethod.POST)
    public void createIngredientRecipe(HttpSession session,
            @RequestParam("idIngredient") Integer idIngredient, @RequestParam("quantite") Long quantite,
            HttpServletRequest request) {
        
        System.err.println("ID INGREDIENT : " + idIngredient);
        System.err.println("QUANTITE : " + quantite);
        
        /*RecipeBean recipe = recipeService.findRecipe(idRecipe);
        IngredientBean ingredient = ingredientService.findIngredient(idIngredient);
        
        RecipeIngredientBean bean = new RecipeIngredientBean();
        bean.setRecipe(recipe);
        bean.setIngredient(ingredient);
        bean.setQuantite(quantite);
        recipeIngredientService.createRecipeIngredient(bean);*/

    }


    @RequestMapping(value = "/update/{idUserIngredient}", method = RequestMethod.POST)
    public ResponseEntity<UserIngredientBean> updateUserEvent(HttpSession session, @RequestBody UserIngredientBean bean,
            @PathVariable Integer idUserIngredient, HttpServletRequest request) {
        userIngredientService.updateUserIngredient(idUserIngredient, bean);

        return new ResponseEntity<UserIngredientBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{idUserIngredient}", method = RequestMethod.GET)
    public ModelAndView showUpdateUserIngredient(HttpSession session,
            @PathVariable Integer idUserIngredient, HttpServletRequest request) {
        UserIngredientBean bean = userIngredientService.findUserIngredient(idUserIngredient);

        return new ModelAndView("/", "bean", bean);
    }

    @RequestMapping(value = "/find/{idUserIngredient}", method = RequestMethod.GET)
    public ResponseEntity<UserIngredientBean> findUserEvent(HttpSession session, @PathVariable Integer idUserIngredient,
            HttpServletRequest request) {
        UserIngredientBean bean = userIngredientService.findUserIngredient(idUserIngredient);

        return new ResponseEntity<UserIngredientBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/remove/{idUserIngredient}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public  ModelAndView removeUserIngredient(HttpSession session, @PathVariable Integer idUserIngredient,
            HttpServletRequest request) {
        userIngredientService.removeUserIngredient(idUserIngredient);
         return new ModelAndView("redirect:/app/userIngredients");
    }

}
