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
public class EventBean {

    private Integer idEvent;
    private String nom;
    private String description;
    private String dateDebut;
    private String dateFin;
    private RecipeBean recipe;
    private UserBean organisateur;

    public EventBean() {

    }

    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public RecipeBean getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeBean recipe) {
        this.recipe = recipe;
    }

    public UserBean getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(UserBean organisateur) {
        this.organisateur = organisateur;
    }

}
