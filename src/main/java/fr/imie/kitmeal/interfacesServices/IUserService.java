/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.interfacesServices;

import fr.imie.kitmeal.beans.UserBean;
import java.util.List;

/**
 *
 * @author Laura
 */
public interface IUserService {
    
    public List<UserBean> findAllUsers();

    public UserBean createUser(UserBean bean);
    
    public UserBean updateUser(Integer idUser, UserBean bean);
    
    public UserBean findUser(Integer idUser);
    
    public void removeUser(Integer idUser);

}
