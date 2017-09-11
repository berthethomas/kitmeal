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
public class UserIngredientBean {

    private Integer idUserIngredient;
    private UserBean user;
    private IngredientBean ingredient;
    private Long quantite;

    public Integer getIdUserIngredient() {
        return idUserIngredient;
    }

    public void setIdUserIngredient(Integer idUserIngredient) {
        this.idUserIngredient = idUserIngredient;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public IngredientBean getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientBean ingredient) {
        this.ingredient = ingredient;
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }

}
