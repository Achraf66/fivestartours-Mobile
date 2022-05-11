/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.views;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.NumericSpinner;
import com.mycompany.myapp.entities.Airline;
import com.mycompany.myapp.services.Airlineservices;

/**
 *
 * @author Achraf
 */
public class AddairlineForm extends Form{
    
    Airlineservices Airlineservices = new Airlineservices();
    
    
    public AddairlineForm(Form previous)
    {
    
    
        setTitle("Ajouter une airlines");  
        setLayout(BoxLayout.y());
        TextField tfnomairline = new TextField("", "Nom airline:");      
        TextField tfpays = new TextField("", "Pays :");
        NumericSpinner spstars = new NumericSpinner();
        spstars.setMin(0);
        spstars.setMax(6);     
       Button addButton = new Button("Add Airline");
      ////////////////////////////////////////////////////////////////////////////////////    
        Label lbnomairline = new Label();
        lbnomairline.setText("Nom de l'airline");
     ////////////////////////////////////////////////////////////////////////////////////         
        Label lbpays= new Label();
        lbpays.setText("Pays: ");       
     ////////////////////////////////////////////////////////////////////////////////////
        Label lbstar = new Label();
        lbstar.setText("Stars");
     ////////////////////////////////////////////////////////////////////////////////////
        Container cnomairline = new Container(BoxLayout.x());
        cnomairline.add(lbnomairline).add(tfnomairline);
      ////////////////////////////////////////////////////////////////////////////////////
        Container cpays = new Container(BoxLayout.x());
        cpays.addAll(lbpays,tfpays);
      ////////////////////////////////////////////////////////////////////////////////////
        Container cstars = new Container(BoxLayout.x());
        cstars.addAll(lbstar,spstars);
        ////////////////////////////////////////////////////////////////////////////////////
        
      addButton.addActionListener(l->{
      if ((tfnomairline.getText().length()==0) || (tfpays.getText().length()==0))
     {
         Dialog.show("Alert","Merci de remplir tous les champs", new Command("ok"));
     }
      else
      
      {  
      
      Airline a = new Airline();
      a.setNomairline(tfnomairline.getText());
      a.setPays(tfpays.getText());
      a.setStars((int) spstars.getValue());
      
      Airlineservices.AddAirline(a);    
      Dialog.show("Success","Airline est ajouté", new Command("Ok"));
      previous.showBack();
      
      
      }
      
      
      
      
      });
      
       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
       addAll(cnomairline,cpays,cstars,addButton);
      
    
    }
    
    
    
    
    
    
}
