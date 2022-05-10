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
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.NumericSpinner;
import com.codename1.ui.spinner.Picker;
import com.mycompany.myapp.entities.Vol;
import com.mycompany.myapp.services.Volservices;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author Achraf
 */
public class AddvolForm extends Form
{

Volservices Volservices = new Volservices();


public AddvolForm(Form previous)
{

   
    setTitle("Ajouter un vol");
    setLayout(BoxLayout.y());
    Label lnom = new Label("Nom:");
       
        TextField tfnom = new TextField("","Nomvol");
           
        TextField tfdestination = new TextField("","Destination");

        
        /*TextField tfnbrplace = new TextField("","Nombre de place");*/
        NumericSpinner tfnbrplace = new NumericSpinner();
       
        
    
        Picker datedepartPicker = new Picker();
        datedepartPicker.setType(Display.PICKER_TYPE_DATE);
        datedepartPicker.setDate(new Date());

        /********************************************************************/
        
        
        Picker datearrivePicker = new Picker();
        datearrivePicker.setType(Display.PICKER_TYPE_DATE);
        datearrivePicker.setDate(new Date());

        
        Picker heuredepartPicker = new Picker();
        heuredepartPicker.setType(Display.PICKER_TYPE_TIME);
        heuredepartPicker.setTime(10 * 60);
        
        
        Picker heurearrivePicker = new Picker();
        heurearrivePicker.setType(Display.PICKER_TYPE_TIME);
        heurearrivePicker.setTime(10 * 60);
        
        
        Button addButton = new Button("Add vol");
/*********************************************************************/
        Container cnom = new Container(BoxLayout.x());
        cnom.add(lnom).add(tfnom);

/*********************************************************************/  

Label ldestination = new Label("Destination :");
Container cdestination = new Container(BoxLayout.x());
cdestination.add(ldestination).add(tfdestination);

/*********************************************************************/  

Label lnbrplace = new Label("Nombre de place :");
Container cnbrplace = new Container(BoxLayout.x());
cnbrplace.add(lnbrplace).add(tfnbrplace);

/*********************************************************************/  

Label ldatedepart = new Label("Date de depart");
Container cdatedepart = new Container(BoxLayout.x());
cdatedepart.add(ldatedepart).add(datedepartPicker);
/***************************************************************************/

Label ldatearrive = new Label("Date d'arrivé");
Container cdatearrive = new Container(BoxLayout.x());
cdatearrive.add(ldatearrive).add(datearrivePicker);


/**********************************************************************/
Label lheuredepart = new Label("Heure de depart");
Container cheuredepart = new Container();
cheuredepart.add(lheuredepart).add(heuredepartPicker);

/**********************************************************************/

Label lheuredarrive = new Label("Heure de arrive");
Container cheuredarrive = new Container();
cheuredarrive.add(lheuredarrive).add(heurearrivePicker);

/**********************************************************************/


 addButton.addActionListener(l->{
     
   if 
   ((tfnom.getText().length()==0) || (tfdestination.getText().length()==0))
   {
   Dialog.show("Alert", "Merci de remplir tous les champs", new Command("ok")); 
   }
   
   
   else{  
       
            
       try {
          
           Vol v = new Vol();
           
           /*
           Calendar calendar = Calendar.getInstance();
           
           calendar.setTime(new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").parse(datedepartPicker.getDate() + ""));
           v.setDatedepart(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DATE)).getTime()));
           
           
           calendar.setTime(new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").parse(datearrivePicker.getDate() + ""));
           v.setDatearrive(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DATE)).getTime()));
           */
           
           Date date1 = new Date();
           String dateDepart = new SimpleDateFormat("yyyy-dd-MM").format(date1);
           String datearrive = new SimpleDateFormat("yyyy-dd-MM").format(date1);
           v.setDatearrive(datearrive);
           v.setDatedepart(dateDepart);        
           v.setHeuredepart(new java.sql.Time(new SimpleDateFormat("HH:mm").parse(heuredepartPicker.getTime() / 60 + ":" + heuredepartPicker.getTime() % 60).getTime()));
           v.setHeurearrive(new java.sql.Time(new SimpleDateFormat("HH:mm").parse(heurearrivePicker.getTime() / 60 + ":" + heurearrivePicker.getTime() % 60).getTime()));
           v.setNom(tfnom.getText());
           v.setDestination(tfdestination.getText());
           v.setNbrplace((int) tfnbrplace.getValue());
           
           Volservices.addVol(v);
           System.out.println(v);
               Dialog.show("Success","Votre Vol est ajouté", new Command("Ok"));
       previous.showBack();
       } catch (ParseException ex) {
           ex.printStackTrace();
       }
            
            
        
         }
        });
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        addAll(cnom,cdestination,cnbrplace,cdatedepart,cdatearrive,cheuredepart,cheuredarrive,addButton);

        
        



}






    
}
