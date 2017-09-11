/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.entities;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author thomasberthe
 */
public class UserIngredient {

    @Id
    @GeneratedValue
    @Column(name = "id_user_ingredient")
    private Integer idUserIngredient;

    @OneToMany(targetEntity = User.class)
    @JoinColumn(name = "user")
    @ElementCollection
    private User user;

    @OneToMany(targetEntity = Ingredient.class)
    @JoinColumn(name = "ingredient")
    @ElementCollection
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
