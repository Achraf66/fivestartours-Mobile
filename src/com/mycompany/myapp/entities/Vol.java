/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.sql.Time;

/**
 *
 * @author Achraf
 */
public class Vol 
{
       
    private int id;
    private int airline_id;
    private String datedepart;
    private String datearrive;
    private String nom;
    private Time heuredepart;
    private Time heurearrive;
    private String destination;
    private int nbrplace;

    public Vol(int id, int airline_id, String datedepart, String datearrive, String nom, Time heuredepart, Time heurearrive, String destination, int nbrplace) {
        this.id = id;
        this.airline_id = airline_id;
        this.datedepart = datedepart;
        this.datearrive = datearrive;
        this.nom = nom;
        this.heuredepart = heuredepart;
        this.heurearrive = heurearrive;
        this.destination = destination;
        this.nbrplace = nbrplace;
    }

    public Vol(int id, String datedepart, String datearrive, String nom, Time heuredepart, Time heurearrive, String destination, int nbrplace) {
        this.id = id;
        this.datedepart = datedepart;
        this.datearrive = datearrive;
        this.nom = nom;
        this.heuredepart = heuredepart;
        this.heurearrive = heurearrive;
        this.destination = destination;
        this.nbrplace = nbrplace;
    }

    public Vol(String datedepart, String datearrive, String nom, Time heuredepart, Time heurearrive, String destination, int nbrplace) {
        this.datedepart = datedepart;
        this.datearrive = datearrive;
        this.nom = nom;
        this.heuredepart = heuredepart;
        this.heurearrive = heurearrive;
        this.destination = destination;
        this.nbrplace = nbrplace;
    }

    public Vol() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(int airline_id) {
        this.airline_id = airline_id;
    }

    public String getDatedepart() {
        return datedepart;
    }

    public void setDatedepart(String datedepart) {
        this.datedepart = datedepart;
    }

    public String getDatearrive() {
        return datearrive;
    }

    public void setDatearrive(String datearrive) {
        this.datearrive = datearrive;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Time getHeuredepart() {
        return heuredepart;
    }

    public void setHeuredepart(Time heuredepart) {
        this.heuredepart = heuredepart;
    }

    public Time getHeurearrive() {
        return heurearrive;
    }

    public void setHeurearrive(Time heurearrive) {
        this.heurearrive = heurearrive;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNbrplace() {
        return nbrplace;
    }

    public void setNbrplace(int nbrplace) {
        this.nbrplace = nbrplace;
    }

    @Override
    public String toString() {
        return "Vol{" + "id=" + id + ", airline_id=" + airline_id + ", datedepart=" + datedepart + ", datearrive=" + datearrive + ", nom=" + nom + ", heuredepart=" + heuredepart + ", heurearrive=" + heurearrive + ", destination=" + destination + ", nbrplace=" + nbrplace + '}';
    }
    
    
    
    
}
