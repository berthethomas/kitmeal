/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.controllers;

import fr.imie.kitmeal.beans.IngredientBean;
import fr.imie.kitmeal.interfacesServices.IIngredientService;
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
@RequestMapping(value = "/ingredients")
public class IngredientController {

    @Autowired
    IIngredientService ingredientService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<IngredientBean>> findAllIngredients(HttpSession session,
            HttpServletRequest request) {
        List<IngredientBean> beans = ingredientService.findAllIngredients();

        return new ResponseEntity<List<IngredientBean>>(beans, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<IngredientBean> createIngredient(HttpSession session, @RequestBody IngredientBean bean,
            HttpServletRequest request) {
        ingredientService.createIngredient(bean);

        return new ResponseEntity<IngredientBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView showCreateIngredient(HttpSession session,
            HttpServletRequest request) {
        IngredientBean bean = new IngredientBean();

        return new ModelAndView("/", "bean", bean);
    }

    @RequestMapping(value = "/update/{idIngredient}", method = RequestMethod.POST)
    public ResponseEntity<IngredientBean> updateIngredient(HttpSession session, @RequestBody IngredientBean bean,
            @PathVariable Integer idIngredient, HttpServletRequest request) {
        ingredientService.updateIngredient(idIngredient, bean);

        return new ResponseEntity<IngredientBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{idIngredient}", method = RequestMethod.GET)
    public ModelAndView showUpdateIngredient(HttpSession session,
            @PathVariable Integer idIngredient, HttpServletRequest request) {
        IngredientBean bean = ingredientService.findIngredient(idIngredient);

        return new ModelAndView("/", "bean", bean);
    }

    @RequestMapping(value = "/find/{idIngredient}", method = RequestMethod.GET)
    public ResponseEntity<IngredientBean> findIngredient(HttpSession session, @PathVariable Integer idIngredient,
            HttpServletRequest request) {
        IngredientBean bean = ingredientService.findIngredient(idIngredient);

        return new ResponseEntity<IngredientBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/remove/{idIngredient}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeIngredient(HttpSession session, @PathVariable Integer idIngredient,
            HttpServletRequest request) {
        ingredientService.removeIngredient(idIngredient);
    }
}
