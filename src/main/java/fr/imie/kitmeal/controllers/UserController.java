/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.controllers;

import fr.imie.kitmeal.beans.AddressBean;
import fr.imie.kitmeal.beans.UserBean;
import fr.imie.kitmeal.interfacesServices.IAddressService;
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

    @Autowired
    IAddressService addressService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView findAllUsers(HttpSession session,
            HttpServletRequest request) {
        List<UserBean> beans = userService.findAllUsers();
        if(session.getAttribute("user") != null){
            return new ModelAndView("/contacts/contacts.jsp", "bean", beans);
        }else{
            return new ModelAndView("redirect:/app/log");
        }
    }

    @RequestMapping(value = "/create/{bean}", method = RequestMethod.POST)
    public ModelAndView createUser(HttpSession session, UserBean bean,
            HttpServletRequest request) {
        AddressBean address = addressService.createAddress(bean.getAddress());
        userService.createUser(bean);

        return new ModelAndView("redirect:/app/users");
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView showCreateUser(HttpSession session,
            HttpServletRequest request) {
        UserBean bean = new UserBean();
        UserBean user = (UserBean)session.getAttribute("user");
        if(session.getAttribute("user") != null){
            if((user.getRole() == "admin")){
            return new ModelAndView("/contacts/form.jsp", "bean", bean);
            }else{
              return new ModelAndView("redirect:/app/users");  
            }
        }else{
            return new ModelAndView("redirect:/app/log");
        }
    }

    @RequestMapping(value = "/update/{idUser}/{bean}", method = RequestMethod.POST)
    public ModelAndView updateUser(HttpSession session, UserBean bean,
            @PathVariable Integer idUser, HttpServletRequest request) {

        addressService.updateAddress(bean.getAddress().getIdAddress(), bean.getAddress());
        userService.updateUser(idUser, bean);

        return new ModelAndView("redirect:/app/users");
    }

    @RequestMapping(value = "/update/{idUser}", method = RequestMethod.GET)
    public ModelAndView showUpdateUser(HttpSession session,
            @PathVariable Integer idUser, HttpServletRequest request) {
        UserBean bean = userService.findUser(idUser);
        UserBean user = (UserBean)session.getAttribute("user");
        if(session.getAttribute("user") != null){
            if((user.getRole() == "admin")){
                return new ModelAndView("/contacts/update.jsp", "bean", bean);
            }else{
                return new ModelAndView("redirect:/app/users");  
            }
        }else{
            return new ModelAndView("redirect:/app/log");
        }
    }

    @RequestMapping(value = "/find/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<UserBean> findUser(HttpSession session, @PathVariable Integer idUser,
            HttpServletRequest request) {
        UserBean bean = userService.findUser(idUser);

        return new ResponseEntity<UserBean>(bean, HttpStatus.OK);
    }

    @RequestMapping(value = "/remove/{idUser}", method = RequestMethod.GET)
    public ModelAndView removeUser(HttpSession session, @PathVariable Integer idUser,
            HttpServletRequest request) {
        userService.removeUser(idUser);

        return new ModelAndView("redirect:/app/users");
    }

}
