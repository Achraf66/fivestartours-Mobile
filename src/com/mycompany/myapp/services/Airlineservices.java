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
import com.mycompany.myapp.entities.Airline;

import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Achraf
 */
public class Airlineservices
{

    public ArrayList<Airline> airlines;
    public static Airlineservices instance = null;
    public boolean resultOK;
    private ConnectionRequest req;
    public Airlineservices() 
    {
        req = new ConnectionRequest();
    }
    public static Airlineservices getInstance() 
    {
        if (instance == null) {
            instance = new Airlineservices();
        }
        return instance;
    }
 
 /******************************************************************************************************************/
    
    
 public boolean AddAirline(Airline a) 
    {
                
        String url =  Statics.BASE_URL+"addairlineJson/new?nomairline="+a.getNomairline()+"&pays="+a.getPays()+"&stars="+a.getStars() ;
        req.setUrl(url);
        /* System.out.println(url);*/
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
    
public boolean editairline(Airline a) 
{
       
String url = Statics.BASE_URL + "Upldateairlinejson/"+a.getId()
                              +"?nomairline="+a.getNomairline()  
                              +"&pays="+a.getPays()
                              +"&stars="+a.getStars();
                     
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
        
        
        
      public ArrayList<Airline> parseairline(String jsonText) {
      
           
        try {
            
            airlines = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> AirlineListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) AirlineListJson.get("root");
            for (Map<String, Object> obj : list) {
            Airline a = new Airline();
            float id = Float.parseFloat(obj.get("id").toString());
            a.setId((int)id);
            a.setNomairline(obj.get("nomairline").toString());
            a.setPays(obj.get("pays").toString());
            float stars = Float.parseFloat(obj.get("stars").toString());
            a.setStars((int)stars); 
            airlines.add(a);
      
            }
            
        } catch (IOException e) {
           e.printStackTrace();
        }
         return airlines;
    }
      
     
      
public ArrayList<Airline> getAllAirlines()        
{

String url = Statics.BASE_URL+"jsonairline";
req.setUrl(url);
req.setPost(false);

req.addResponseListener(new ActionListener<NetworkEvent>() {
    @Override
    public void actionPerformed(NetworkEvent evt) 
    {
            airlines = parseairline(new String(req.getResponseData()));
                req.removeResponseListener(this);
    }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return airlines;

}
     
      
      public boolean deleteairline(int id)
    {
        String url = Statics.BASE_URL +"deleteairlinejson/"+id ;
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
    
    
    
 
