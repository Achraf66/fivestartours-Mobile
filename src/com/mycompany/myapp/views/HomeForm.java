/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.views;

import com.codename1.io.Log;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.addNetworkErrorListener;
import static com.codename1.ui.CN.updateNetworkThreadCount;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Achraf
 */
public class HomeForm extends Form 
{
    
    
    
        private Resources theme;

    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     Form current;
    public HomeForm(){
        current=this;
        setTitle("Gestion de vols");
        setLayout(BoxLayout.y());

        add(new Label("Choisir une option"));
        
        Button volButton = new Button("La Liste des Vols");
     

        volButton.addActionListener(e-> new ShowvolForm(current).show());
        addAll(volButton);

        //SIDE MENU
        getToolbar().addCommandToLeftSideMenu("", null, (evt) -> {
        });
 
        getToolbar().addCommandToLeftSideMenu("Consulter la map", null, (evt) -> {
         new MapForm();
 
        });
        
         getToolbar().addCommandToLeftSideMenu("Statistique", null, (evt) -> {
         new VolStatsForm(current).show();
 
        });
         
         
         
         
        getToolbar().addCommandToLeftSideMenu("Vols", null, (evt) -> {
            new ShowvolForm(current).show();
        });
    }
    
    
    
    
    
    
    
}
