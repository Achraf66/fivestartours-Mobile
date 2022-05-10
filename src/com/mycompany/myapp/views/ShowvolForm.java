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
import com.mycompany.myapp.entities.Vol;
import com.mycompany.myapp.services.Volservices;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Achraf
 */
public class ShowvolForm extends Form
{
   Form previous;
    Volservices Volservices = new Volservices();
    ArrayList<Vol> VolsArrayList = new ArrayList<>();

    
    public ShowvolForm(Form previous) 
    {
        setTitle("Vol Liste");
        setLayout(BoxLayout.y());
    
            VolsArrayList = Volservices.getAllVols();
            
            
             Collections.reverse(VolsArrayList);
    
        System.out.println(VolsArrayList);
 
        for (Vol vol : VolsArrayList) {
            MultiButton multiButton = new MultiButton(vol.getNom() + "               "+vol.getNbrplace());
            multiButton.setTextLine2(vol.getDestination()); 
            multiButton.setTextLine3(vol.getDatearrive()+vol.getDatedepart());
            multiButton.setTextLine4("Heure depart:"+vol.getHeuredepart()+"Heurearrive: "+vol.getHeurearrive());

        
            multiButton.setUIID(vol.getId() + "");
           multiButton.addActionListener(l -> new EditvolForm(previous, vol).show());
        add(multiButton);
        }
        
        
        
        
        
        
        
               //TOOLBAR BUTTONS
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        getToolbar().addCommandToOverflowMenu("Add", FontImage.createMaterial(FontImage.MATERIAL_ADD, UIManager.getInstance().getComponentStyle("TitleCommand")), (evt) -> {
            new AddvolForm(previous).show();
        });
        
        
        
        
        getToolbar().addCommandToOverflowMenu("Refresh", FontImage.createMaterial(FontImage.MATERIAL_REFRESH, UIManager.getInstance().getComponentStyle("TitleCommand")), (evt) -> {
            //  new AdminListSpectacleForm(current).show();
        });

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
    }
            
}
