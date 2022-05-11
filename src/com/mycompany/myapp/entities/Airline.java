/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author Achraf
 */
public class Airline 
{ 
    
    private int id;
    private String nomairline;
    private String pays;
    private int stars;

    public Airline(int id, String nomairline, String pays, int stars) {
        this.id = id;
        this.nomairline = nomairline;
        this.pays = pays;
        this.stars = stars;
    }

    public Airline(String nomairline, String pays, int stars) {
        this.nomairline = nomairline;
        this.pays = pays;
        this.stars = stars;
    }

    public Airline() 
    {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomairline() {
        return nomairline;
    }

    public void setNomairline(String nomairline) {
        this.nomairline = nomairline;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Airline{" + "id=" + id + ", nomairline=" + nomairline + ", pays=" + pays + ", stars=" + stars + '}';
    }
    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
