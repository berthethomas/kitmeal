/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.interfacesDao;

import fr.imie.kitmeal.entities.User;
import java.io.Serializable;

/**
 *
 * @author Laura
 */
public interface IUserDao extends IGenericDao<Serializable, User> {
    
    public User findUser(String username, String password);

}
