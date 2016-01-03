/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thibault.daucourt
 */
public class Movie {
    
    private long id;
    private String  name;
    private String producer;
    private Map<Long, Person> people;
    
    
    /**
     * Constructeur paramétré pour la classe Movie.
     * Obligatoire.
     * Représente un film que une ou des personnes ont vu
     *
     * @param id Le numéro unique d'identification du film
     * @param name Le nom du film
     * @param producer Le nom du producteur(réalisateur) du film
     */
    public Movie(long id, String name, String producer) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        people = new HashMap();
    }
    
    public Map getPeople() {
        return people;
    }

    public void setPeople(Map people) {
        this.people = people;
    }

    /**
     * Retourne la liste des personnes convertie en ArrayList
     * @return une ArrayList de personnes
     */
    public List getPeopleList(){
        return new ArrayList(getPeople().values());
    }
    
    /**
     * Retourne le nombre de personnes ayant vues le film
     * @return le nombre de personnes ayant vues le film
     */
    public int getNumberOfPeople(){
        return people.size();
    }

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
    
    
}
