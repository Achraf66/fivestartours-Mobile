/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.views;

import com.codename1.components.MultiButton;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.entities.Airline;
import com.mycompany.myapp.entities.Vol;
import com.mycompany.myapp.services.Airlineservices;
import com.mycompany.myapp.services.Volservices;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Achraf
 */
public class ShowairlineForm extends Form
{
    Form previous;
    Airlineservices Airlineservices = new Airlineservices();
    ArrayList<Airline> AirlinesArrayList = new ArrayList<>();
    
    public ShowairlineForm(Form previous)
    {
        setTitle("Airline Liste");
        setLayout(BoxLayout.y());
    
            AirlinesArrayList = Airlineservices.getAllAirlines();
    
      Collections.reverse(AirlinesArrayList);
      
      
      
      
            for (Airline airline : AirlinesArrayList) {
            MultiButton multiButton = new MultiButton(airline.getNomairline()+ "    "+airline.getStars());
            multiButton.setTextLine2(airline.getPays()); 
       

        
          multiButton.setUIID(airline.getId() + "");
          multiButton.addActionListener(l -> new EditAirlineForm(previous, airline).show());
        add(multiButton);
        }
    
            getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        getToolbar().addCommandToOverflowMenu("Add", FontImage.createMaterial(FontImage.MATERIAL_ADD, UIManager.getInstance().getComponentStyle("TitleCommand")), (evt) -> {
            new AddairlineForm(previous).show();
        });
        
      
        getToolbar().addCommandToOverflowMenu("Refresh", FontImage.createMaterial(FontImage.MATERIAL_REFRESH, UIManager.getInstance().getComponentStyle("TitleCommand")), (evt) -> {
            //  new AdminListSpectacleForm(current).show();
        });
    
    
    
    
    }
    

    
    
    
}
