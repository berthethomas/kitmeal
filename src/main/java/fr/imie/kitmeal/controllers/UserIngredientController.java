/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.controllers;

import fr.imie.kitmeal.beans.UserIngredientBean;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Laura
 */
@RestController
@RequestMapping(value = "/userIngredients")
public class UserIngredientController {

    @Autowired
    IUserIngredientService userIngredientService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<UserIngredientBean>> findAllUserIngredients(HttpSession session,
            HttpServletRequest request) {
        List<UserIngredientBean> beans = userIngredientService.findAllUserIngredients();

        return new ResponseEntity<List<UserIngredientBean>>(beans, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<UserIngredientBean> createUserIngredient(HttpSession session, @RequestBody UserIngredientBean bean,
            HttpServletRequest request) {
        userIngredientService.createUserIngredient(bean);

        return new ResponseEntity<UserIngredientBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{idUserIngredient}", method = RequestMethod.POST)
    public ResponseEntity<UserIngredientBean> updateUserEvent(HttpSession session, @RequestBody UserIngredientBean bean,
            @PathVariable Integer idUserIngredient, HttpServletRequest request) {
        userIngredientService.updateUserIngredient(idUserIngredient, bean);

        return new ResponseEntity<UserIngredientBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/find/{idUserIngredient}", method = RequestMethod.GET)
    public ResponseEntity<UserIngredientBean> findUserEvent(HttpSession session, @PathVariable Integer idUserIngredient,
            HttpServletRequest request) {
        UserIngredientBean bean = userIngredientService.findUserIngredient(idUserIngredient);

        return new ResponseEntity<UserIngredientBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/remove/{idUserIngredient}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeUserIngredient(HttpSession session, @PathVariable Integer idUserIngredient,
            HttpServletRequest request) {
        userIngredientService.removeUserIngredient(idUserIngredient);
    }

}
