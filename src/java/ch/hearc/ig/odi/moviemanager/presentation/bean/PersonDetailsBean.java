/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Bean lié à la page customerDetails.xhtml, qui permet d'afficher les détails d'un client
 * @author julien.plumez
 */
@Named(value = "customerDetailsBean")
@SessionScoped
public class PersonDetailsBean implements Serializable{
    
    @Inject Services services;
    private Person person;

    public PersonDetailsBean(){
        
    }
    
    /**
     * Méthode qui reçoit le client à afficher sur la page.
     * @param pers Le client à afficher
     * @return "show" si le client est valide, "error" si le paramètre est null
     */
    public String showCustomer(Person pers){
        if(pers != null){
            person = pers;
            return "show";
        }else{
            person = null;
            return "error";
        }
    }
    
    /**
     * Retourne les comptes du client, ou un ArrayList vide si le client n'est pas valide
     * @return Les comptes du client
     */
    public List<Account> getAccounts(){
        if(customer == null){
            return new ArrayList();
        }
        
        return new ArrayList(customer.getAccounts().values());
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}