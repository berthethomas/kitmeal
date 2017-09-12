/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.beans;

/**
 *
 * @author thomasberthe
 */
public class UserEventBean {

    private Integer idUserEvent;
    private UserBean user;
    private EventBean event;
    private boolean response;

    public UserEventBean() {

    }

    public Integer getIdUserEvent() {
        return idUserEvent;
    }

    public void setIdUserEvent(Integer idUserEvent) {
        this.idUserEvent = idUserEvent;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public EventBean getEvent() {
        return event;
    }

    public void setEvent(EventBean event) {
        this.event = event;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

}
