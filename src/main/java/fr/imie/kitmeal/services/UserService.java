/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.services;

import fr.imie.kitmeal.beans.UserBean;
import fr.imie.kitmeal.entities.User;
import fr.imie.kitmeal.interfacesDao.IUserDao;
import fr.imie.kitmeal.interfacesServices.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Laura
 */
@Service
@Transactional(transactionManager = "txManagerKitmeal")
public class UserService implements IUserService{
    
    @Autowired
	private IUserDao userDao;
    
    @Override
    public UserBean createUser (UserBean bean){
        User user = new User();
        user.setPrenom(bean.getPrenom());
        user.setNom(bean.getNom());
        user.setMail(bean.getMail());
        user.setTelephone(bean.getTelephone());
        user.setBirthday(bean.getBirthday());
        user.setUsername(bean.getUsername());
        user.setPassword(bean.getPassword());
        user.setPhoto(bean.getPhoto());
        user.setRole("user");
        
        userDao.create(user);
        
        return bean;   
    }
            
}
