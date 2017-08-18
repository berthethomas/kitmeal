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
 * @author thomasberthe
 */
@Entity
@Table(name = "unite")
public class Unite {

    @Id
    @GeneratedValue
    @Column(name = "id_unite")
    private Integer idUnite;

    @Column(name = "nom")
    private String nom;

    public Integer getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(Integer idUnite) {
        this.idUnite = idUnite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
