/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Vol;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Achraf
 */
public class Volservices 
{


/**********************************************************************************/
    public ArrayList<Vol> vols;

    public static Volservices instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public Volservices() {
        req = new ConnectionRequest();
    }

    public static Volservices getInstance() {
        if (instance == null) {
            instance = new Volservices();
        }
        return instance;
    }

/**********************************************************************************/
    
    
        public boolean addVol(Vol v) {
      /*  String url = Statics.BASE_URL + "planning/api/add?titre="+planning.getTitreEvent()+
                "&type="+planning.getTypeEvent()+
                "&salle="+planning.getNomSalle()+
                "&date="+planning.getDate()+
                "&heureDebut="+planning.getHeureDebut()+
                "&heureFin="+planning.getHeureFin(); // Add Symfony URL here
        
        */
        /**********************************************************************************/

/*String url = Statics.BASE_URL+"Datearrive="+v.getDatedepart()+"&Datedepart="+v.getDatearrive()+"&destination="+v.getDestination()+"&Heurearrive="+v.getHeurearrive()+"&Heuredepart="+v.getHeuredepart()+"&nbrplace="+v.getNbrplace()+"&Nom="+v.getNom(); */
String url =  Statics.BASE_URL+"addVolJson/new?Datearrive="+v.getDatearrive()+"&Datedepart="+v.getDatedepart()+"&destination="+v.getDestination()+"&Heurearrive="+v.getHeurearrive()+"&Heuredepart="+v.getHeuredepart()+"&nbrplace="+v.getNbrplace()+"&Nom="+v.getNom() ;
        
        
        req.setUrl(url);
         System.out.println(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

/**********************************************************************************/
       /* Modifier*/
/***********************************************************************************/
    
public boolean editvol(Vol v) 
{
       
    String url = Statics.BASE_URL + "Updatevoljson/"+v.getId()
                +"?Datearrive="+v.getDatearrive()
                +"&Datedepart="+v.getDatedepart()
                +"&destination="+v.getDestination()
                +"&Heurearrive="+v.getHeurearrive()
                +"&Heuredepart="+v.getHeuredepart()
                +"&nbrplace="+v.getNbrplace()
                +"&Nom="+v.getNom() ;
             
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
        
        
        
      public ArrayList<Vol> parsevol(String jsonText) {
        try {
            vols = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> VolListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) VolListJson.get("root");
            for (Map<String, Object> obj : list) {

                
            Vol v = new Vol();
                  
               
             float id = Float.parseFloat(obj.get("id").toString());
             v.setId((int)id);   
    /*         
             String  datedepart1 = obj.get("datedepart").toString();     
             v.setDatedepart(datedepart1);
                
             String  datearrive2 = obj.get("datearrive").toString();            
             v.setDatearrive(datearrive2);  
*/      
          v.setDatedepart(obj.get("Datedepart").toString());
          v.setDatearrive(obj.get("Datearrive").toString());
        
             v.setDestination(obj.get("destination").toString());
             v.setNom(obj.get("nom").toString());
             
             float nbrplace = Float.parseFloat(obj.get("nbrplace").toString());
             v.setNbrplace((int)nbrplace);
          
      Time heuredepart = new Time(new SimpleDateFormat("hh:mm:ss").parse(obj.get("heuredepart").toString().substring(11, 19)).getTime());
      Time heurearrive = new Time(new SimpleDateFormat("hh:mm:ss").parse(obj.get("heurearrive").toString().substring(11, 19)).getTime());
      v.setHeuredepart(heuredepart);
      v.setHeurearrive(heurearrive);      
      System.out.println(v);
       vols.add(v);
  
            }
        } catch (IOException | ParseException ex) {
        }
        return vols;
    }
  
   public ArrayList<Vol> getAllVols()        
{

String url = Statics.BASE_URL+"jsonvols";
req.setUrl(url);
req.setPost(false);

req.addResponseListener(new ActionListener<NetworkEvent>() {
    @Override
    public void actionPerformed(NetworkEvent evt) 
    {
            vols = parsevol(new String(req.getResponseData()));
                req.removeResponseListener(this);
    }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return vols;

}

       public boolean deletevol(int id)
    {
        String url = Statics.BASE_URL +"deletevolJson/"+id ;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   


}






     
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

