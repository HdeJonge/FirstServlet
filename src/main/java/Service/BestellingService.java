/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import POJO.*;
import interfaceDAO.*;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Peter
 */

@Component
public class BestellingService {
    private static IBestellingDAO DAO;
    
    @Autowired
    public BestellingService(IBestellingDAO bestellingDAO){
        DAO = bestellingDAO;
    }
    
    //create bestelling
    public void save(Bestelling bestelling){
        //DAO.openCurrentSessionWithTransaction(); // naar DAO
        DAO.save(bestelling);
        //DAO.closeCurrentSessionWithTransaction(); // naar DAO
    }

    //read all bestelling
    public ArrayList<Bestelling>findAll(){
        //DAO.openCurrentSession();
        ArrayList<Bestelling> bestellingen = (ArrayList<Bestelling>) DAO.findAll();
        //DAO.closeCurrentSession();
        return bestellingen;
    }
    //read bestelling
    public Bestelling findById(int bestellingId){
        //DAO.openCurrentSession();
        Bestelling bestelling = (Bestelling)DAO.findById(bestellingId);
        //DAO.closeCurrentSession();
        return bestelling;
    }
    
    //read bestelling by klantId
    public ArrayList<Bestelling> findByKlantId(int klantId){
        //DAO.openCurrentSessionWithTransaction();
        ArrayList<Bestelling> bestellingen = DAO.findByKlantId(klantId);
        //DAO.closeCurrentSessionWithTransaction();
        return bestellingen;
    }
    
    public void update(Bestelling bestelling){
        //DAO.openCurrentSessionWithTransaction();
        DAO.update(bestelling);
        //DAO.closeCurrentSessionWithTransaction();
    }
    //delete 
    public void delete(int bestellingId){
        Bestelling bestelling = findById(bestellingId);
        //DAO.openCurrentSessionWithTransaction();
        DAO.delete(bestelling); 
        //DAO.closeCurrentSessionWithTransaction();
    }
    public void delete(Bestelling bestelling){
        //DAO.openCurrentSessionWithTransaction();
        DAO.delete(bestelling); 
        //DAO.closeCurrentSessionWithTransaction();
    }
}
