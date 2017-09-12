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
@Table(name = "recipe_ingredient")
public class RecipeIngredient {

    @Id
    @GeneratedValue
    @Column(name = "id_recipe_ingredient")
    private Integer idRecipeIngredient;

    @ManyToOne(targetEntity = Recipe.class)
    @JoinColumn(name = "recipe")
    private Recipe recipe;

    @ManyToOne(targetEntity = Ingredient.class)
    @JoinColumn(name = "ingredient")
    private Ingredient ingredient;

    @Column(name = "quantite")
    private Long quantite;

    public Integer getIdRecipeIngredient() {
        return idRecipeIngredient;
    }

    public void setIdRecipeIngredient(Integer idRecipeIngredient) {
        this.idRecipeIngredient = idRecipeIngredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
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
