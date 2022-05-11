/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.views;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.NumericSpinner;
import com.codename1.ui.spinner.Picker;
import com.mycompany.myapp.entities.Vol;
import com.mycompany.myapp.services.Volservices;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Achraf
 */
public class EditvolForm extends Form
{
    
    Volservices Volservices = new Volservices();
    
    public EditvolForm(Form previous,Vol v)
    {
    
        try {
            
            setTitle("Edit vol");
            setLayout(BoxLayout.y());
            
            Picker datedepartpicker = new Picker();
            datedepartpicker.setType(Display.PICKER_TYPE_DATE);
            String datedepart=v.getDatedepart();
            Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(datedepart);      
            datedepartpicker.setDate(date1);
       
        
            Picker datearriverpicker = new Picker();
            datearriverpicker.setType(Display.PICKER_TYPE_DATE);
            String datearrivee=v.getDatearrive();
            Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(datearrivee);      
            datearriverpicker.setDate(date2);    
            
       
            
       Picker HeuredepartPicker = new Picker();
       HeuredepartPicker.setType(Display.PICKER_TYPE_TIME);
       HeuredepartPicker.setTime
       (Integer.parseInt(v.getHeuredepart().toString().substring(0,2)),Integer.parseInt(v.getHeuredepart().toString().substring(3,5)));
            
        Picker Heurearrivepicker = new Picker();
        Heurearrivepicker.setType(Display.PICKER_TYPE_TIME);
        Heurearrivepicker.setTime
        (Integer.parseInt(v.getHeurearrive().toString().substring(0,2)),Integer.parseInt(v.getHeurearrive().toString().substring(3,5)));
       
       
            TextField tfnom = new TextField();
            tfnom.setText(v.getNom());
            
            TextField tfdestination = new TextField();
            tfdestination.setText(v.getDestination());
       
       
            NumericSpinner sp = new NumericSpinner();
            sp.setValue(v.getNbrplace());
            
       
        Button editButton = new Button("Modifier l airline");
        Button deleteButton = new Button("Supprimer l airline");
       
       
       editButton.addActionListener(
           l->{
       
       
               
                try {
                    Date date4 = new Date();
                    String dateDepart = new SimpleDateFormat("yyyy-dd-MM").format(date4);
                    String datearrive = new SimpleDateFormat("yyyy-dd-MM").format(date4);
                    
                    
                    v.setDatearrive(datearrive);
                    v.setDatedepart(dateDepart);
                    
                    v.setHeuredepart(new java.sql.Time(new SimpleDateFormat("HH:mm").parse(HeuredepartPicker.getTime() / 60 + ":" + HeuredepartPicker.getTime() % 60).getTime()));
                    v.setHeurearrive(new java.sql.Time(new SimpleDateFormat("HH:mm").parse(Heurearrivepicker.getTime() / 60 + ":" + Heurearrivepicker.getTime() % 60).getTime()));
                    
                    
                    
                    v.setNom(tfnom.getText());
                    v.setDestination(tfdestination.getText());
                    v.setNbrplace((int) sp.getValue());
                    
               
                    Volservices.editvol(v);
                   
                    Dialog.show("Success","Modification avec succes", new Command("Ok"));
                    
                   previous.showBack();
                    
                } catch (ParseException s) {
                    s.printStackTrace();
                }
           
    
   
       
           });
       
       deleteButton.addActionListener(
               e->{
    
       Volservices.deletevol(v.getId());
       Dialog.show("Success","Modification avec succes", new Command("Ok"));
       previous.showBack();
  
       
               });
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       addAll(tfnom,tfdestination,datedepartpicker,datearriverpicker,HeuredepartPicker,Heurearrivepicker,sp,editButton,deleteButton);
        
        
        
        
        } catch (ParseException ex)
        {
            ex.printStackTrace();        
        }
        
                 getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

            

    
    }
    
    
    
    
    
    
    
    
}
