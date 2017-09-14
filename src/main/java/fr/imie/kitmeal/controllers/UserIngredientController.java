/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.controllers;

import fr.imie.kitmeal.beans.CategoryBean;
import fr.imie.kitmeal.beans.IngredientBean;
import fr.imie.kitmeal.beans.UniteBean;
import fr.imie.kitmeal.beans.UserBean;
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
    
    @RequestMapping(value = "/ingredients", method = RequestMethod.GET)
    public ModelAndView findAllIngredients(HttpSession session,
            HttpServletRequest request) {
        List<IngredientBean> beans = ingredientService.findAllIngredients();

        return new ModelAndView("/frigo/showIngredients.jsp", "bean", beans);
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

    @RequestMapping(value = "/create/ingredients", method = RequestMethod.POST)
    public void createIngredientRecipe(HttpSession session,
            @RequestParam("idIngredient") Integer idIngredient, @RequestParam("quantite") Long quantite,
            HttpServletRequest request) {
        
        System.err.println("ID INGREDIENT : " + idIngredient);
        System.err.println("QUANTITE : " + quantite);
        
        //RecipeBean recipe = recipeService.findRecipe(idRecipe);
        IngredientBean ingredient = ingredientService.findIngredient(idIngredient);
        UserIngredientBean bean = new UserIngredientBean();
        bean.setIngredient(ingredient);
        bean.setQuantite(quantite);
        bean.setUser((UserBean)session.getAttribute("user"));
        userIngredientService.createUserIngredient(bean);

    }

    @RequestMapping(value = "/update/{idIngredient}", method = RequestMethod.GET)
    public ModelAndView showUpdateUser(HttpSession session,
            @PathVariable Integer idIngredient, HttpServletRequest request) {
        IngredientBean bean = ingredientService.findIngredient(idIngredient);
        UserBean user = (UserBean)session.getAttribute("user");
        if(session.getAttribute("user") != null){
            if((user.getRole() == "admin")){
                return new ModelAndView("/frigo/updateIngredient.jsp", "bean", bean);
            }else{
                return new ModelAndView("redirect:/app/users");  
            }
        }else{
            return new ModelAndView("redirect:/app/log");
        }
    }

    @RequestMapping(value = "/update/{idIngredient}/{bean}", method = RequestMethod.POST)
    public ModelAndView updateRecipe(HttpSession session, IngredientBean bean,
            @PathVariable Integer idIngredient, HttpServletRequest request) {
        ingredientService.updateIngredient(idIngredient, bean);

        return new ModelAndView("redirect:/app/userIngredients");
    }

    @RequestMapping(value = "/find/{idUserIngredient}", method = RequestMethod.GET)
    public ResponseEntity<UserIngredientBean> findUserEvent(HttpSession session, @PathVariable Integer idUserIngredient,
            HttpServletRequest request) {
        UserIngredientBean bean = userIngredientService.findUserIngredient(idUserIngredient);

        return new ResponseEntity<UserIngredientBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/remove/{idUserIngredient}", method = RequestMethod.GET)
    public ModelAndView removeUseringredient(HttpSession session, @PathVariable Integer idUserIngredient,
            HttpServletRequest request) {
        userIngredientService.removeUserIngredient(idUserIngredient);

        return new ModelAndView("redirect:/app/userIngredients");
    }
    
    @RequestMapping(value = "/removeIngredient/{idIngredient}", method = RequestMethod.GET)
    public ModelAndView removeIngredient(HttpSession session, @PathVariable Integer idIngredient,
            HttpServletRequest request) {
        ingredientService.removeIngredient(idIngredient);

        return new ModelAndView("redirect:/app/userIngredients");
    }

}
