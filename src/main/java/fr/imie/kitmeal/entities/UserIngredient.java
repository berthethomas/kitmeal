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
@Table(name = "user_ingredient")
public class UserIngredient {

    @Id
    @GeneratedValue
    @Column(name = "id_user_ingredient")
    private Integer idUserIngredient;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne(targetEntity = Ingredient.class)
    @JoinColumn(name = "ingredient")
    private Ingredient ingredient;

    @Column(name = "quantite")
    private Long quantite;

    public Integer getIdUserIngredient() {
        return idUserIngredient;
    }

    public void setIdUserIngredient(Integer idUserIngredient) {
        this.idUserIngredient = idUserIngredient;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }

}
