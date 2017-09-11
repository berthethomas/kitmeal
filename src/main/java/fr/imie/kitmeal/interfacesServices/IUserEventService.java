/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.interfacesServices;

import fr.imie.kitmeal.beans.UserEventBean;
import java.util.List;

/**
 *
 * @author Laura
 */
public interface IUserEventService {

    public List<UserEventBean> findAllUserEvents();

    public UserEventBean createUserEvent(UserEventBean bean);

    public UserEventBean updateUserEvent(Integer idUserEvent, UserEventBean bean);

    public UserEventBean findUserEvent(Integer idUserEvent);

    public void removeUserEvent(Integer idUserEvent);

}
