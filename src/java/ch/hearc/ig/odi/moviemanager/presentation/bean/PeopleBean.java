/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Bean lié à la page personList.xhtml, qui affiche la liste des persons
 * @author Thibault.Daucourt
 */
@Named(value = "personsBean")
@RequestScoped
public class PeopleBean implements Serializable {
    
    @Inject Services services;

    public PeopleBean(){
        
    }
    
    /**
     * Retourne une liste de persons
     * @return Une liste de persons
     */
    public List<Person> persons(){
        return services.getPeopleList();
    }
}
