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
public class IngredientBean {

    private Integer idIngredient;
    private String nom;
    private UniteBean unite;
    private CategoryBean category;

    public IngredientBean() {

    }

    public Integer getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Integer idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public UniteBean getUnite() {
        return unite;
    }

    public void setUnite(UniteBean unite) {
        this.unite = unite;
    }

    public CategoryBean getCategory() {
        return category;
    }

    public void setCategory(CategoryBean category) {
        this.category = category;
    }

}
