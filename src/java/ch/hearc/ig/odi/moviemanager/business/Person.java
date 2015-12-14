/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.business;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author thibault.daucourt
 */
public class Person implements Serializable {
    
    private Map<Long, Movie> movies;
    private long id;
    private String firstName;
    private String lastName;

    /**
     * Constructeur paramétré pour la classe Person.
     * Obligatoire.
     * Représente une personne ayant vu un ou des films
     *
     * @param id Le numéro unique d'identification de la personne
     * @param firstName Le prénom de la personne
     * @param lastName Le nom de famille de la personne
     */
    public Person(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * Retourne le film correspondant au numéro passé en paramètre, ou null si
     * aucun film ne correspond.
     *
     * @param number Le numéro du film à rechercher
     * @return Le film recherché, ou null si aucun compte ne correspond
     */
    public Movie getMovieById(String id) {
        return movies.get(id);
    }
    
    /**
     * Méthode qui ajoute un film au client
     *
     * @param movie le film vu par la personne
     */
    public void addMovie(Movie movie){
        this.movies.put(movie.getId(),movie);
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

    public Map<Long, Movie> getMovies() {
        return movies;
    }
    
    
    
}
