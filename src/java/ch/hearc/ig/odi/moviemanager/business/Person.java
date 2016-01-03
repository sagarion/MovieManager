/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.business;

import ch.hearc.ig.odi.moviemanager.exception.DuplicateElementException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thibault.daucourt
 */
public class Person implements Serializable {
    
    private Map<Long, Movie> movies;
    private long id;
    private String firstname;
    private String lastname;

    /**
     * Constructeur paramétré pour la classe Person.
     * Obligatoire.
     * Représente une personne ayant vu un ou des films
     *
     * @param id Le numéro unique d'identification de la personne
     * @param firstname Le prénom de la personne
     * @param lastname Le nom de famille de la personne
     */
    public Person(long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        movies = new HashMap();
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
    public void addMovie(Movie movie) throws DuplicateElementException{
        if(!movie.getPeople().containsKey(id)){
            movies.put(movie.getId(), movie);
            movie.getPeople().put(id, this);
        }
        else{
            throw new DuplicateElementException("La personne à déjà vu ce film");
        }
    }
    
    /**
     * Cette méthode retourne la liste des films convertie en ArrayList
     * @return Une ArrayList de films.
     */
    public List getMoviesList(){
        return new ArrayList(getMovies().values());
    }
    
    /**
     * Cette méthode retourne le nombre de films vu par la personne
     * @return le nombre de films vus
     */
    public int getNumberOfMovies(){
        return movies.size();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Map<Long, Movie> getMovies() {
        return movies;
    }
    
    public void setMovies(Map movies) {
        this.movies = movies;
    }
    
    
    
}
