/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.interfacesDao;

import fr.imie.kitmeal.entities.UserEvent;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Laura
 */
public interface IUserEventDao extends IGenericDao<Serializable, UserEvent> {

    public List<UserEvent> findByEvent(Integer idEvent);
}
