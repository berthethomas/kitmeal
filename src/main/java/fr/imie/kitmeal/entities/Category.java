/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Laura
 */
@Entity
@Table(name="categorie")
public class Category {
    
    @Id 
    @GeneratedValue 
    @Column(name="id_categorie")
    private Integer idCategory;
   
    @Column(name="nom")
    private String nom;

    public Integer getIdCategorie() {
        return idCategory;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategory = idCategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
}
