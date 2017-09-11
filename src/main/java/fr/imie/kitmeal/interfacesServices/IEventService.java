/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.interfacesServices;

import fr.imie.kitmeal.beans.EventBean;
import java.util.List;

/**
 *
 * @author thomasberthe
 */
public interface IEventService {

    public List<EventBean> findAllEvents();

    public EventBean createEvent(EventBean bean);

    public EventBean updateEvent(Integer idEvent, EventBean bean);

    public EventBean findEvent(Integer idEvent);

    public void removeEvent(Integer idEvent);
}
