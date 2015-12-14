/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.business;

import java.io.Serializable;

/**
 *
 * @author thibault.daucourt
 */
public class Person implements Serializable {
    
    private long id;
    private String firstName;
    private String lastName;

    /**
     * Constructeur paramétré pour la classe Person. Obligatoire.
     * Obligatoire.
     * Représente une personne ayant regardé un ou des films
     *
     * @param id Le numéro unique d'identification du client
     * @param firstName Le prénom du client
     * @param lastName Le nom de famille du client
     */
    public Person(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    
}
