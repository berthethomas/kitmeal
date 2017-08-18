/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.controllers;

import fr.imie.kitmeal.beans.UserBean;
import fr.imie.kitmeal.interfacesServices.IUserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Laura
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @Autowired
    IUserService userService;
    
    @RequestMapping(value = "/user/createUser", method = RequestMethod.POST)
	public ResponseEntity<UserBean> createUser(HttpSession session, @RequestBody UserBean bean,
			HttpServletRequest request) {
		userService.createUser(bean);
		
		return new ResponseEntity<UserBean>(bean, HttpStatus.OK);
	}
    
}
