/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.controllers;

import fr.imie.kitmeal.beans.UserBean;
import fr.imie.kitmeal.interfacesServices.IUserService;
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
 * @author Laura
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView findAllUsers(HttpSession session,
            HttpServletRequest request) {
        List<UserBean> beans = userService.findAllUsers();

        return new ModelAndView("/contacts.jsp", "bean", beans);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<UserBean> createUser(HttpSession session, @RequestBody UserBean bean,
            HttpServletRequest request) {
        userService.createUser(bean);

        return new ResponseEntity<UserBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{idUser}", method = RequestMethod.POST)
    public ResponseEntity<UserBean> updateUser(HttpSession session, @RequestBody UserBean bean,
            @PathVariable Integer idUser, HttpServletRequest request) {
        userService.updateUser(idUser, bean);

        return new ResponseEntity<UserBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/find/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<UserBean> findUser(HttpSession session, @PathVariable Integer idUser,
            HttpServletRequest request) {
        UserBean bean = userService.findUser(idUser);

        return new ResponseEntity<UserBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/remove/{idUser}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeUser(HttpSession session, @PathVariable Integer idUser,
            HttpServletRequest request) {
        userService.removeUser(idUser);
    }

}
