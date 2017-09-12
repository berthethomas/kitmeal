/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.entities;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author thomasberthe
 */
@Entity
@Table(name = "user_event")
public class UserEvent {

    @Id
    @GeneratedValue
    @Column(name = "id_user_event")
    private Integer idUserEvent;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne(targetEntity = Event.class)
    @JoinColumn(name = "event")
    private Event event;

    @Column(name = "response")
    private boolean response;

    public Integer getIdUserEvent() {
        return idUserEvent;
    }

    public void setIdUserEvent(Integer idUserEvent) {
        this.idUserEvent = idUserEvent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

}
