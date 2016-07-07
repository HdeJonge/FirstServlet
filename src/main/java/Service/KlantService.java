/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import POJO.*;
import interfaceDAO.IKlantDAO;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lucas
 */
@Component
public class KlantService {
    private static IKlantDAO DAO;
    
    @Autowired
    public KlantService(IKlantDAO klantDAO){
        DAO = klantDAO;
    }
    
    public void save(Klant klant){
        DAO.save(klant);
    }
    public Klant findById(int klantId){
        Klant klant = (Klant)DAO.findById(klantId);
        return klant;
    }
    public Klant findByBestellingId(int bestellingId){
        Klant klant = (Klant)DAO.findByBestellingId(bestellingId);
        return klant;
    }
    
    public ArrayList<Klant> findAll(){
        ArrayList<Klant> klantList = (ArrayList<Klant>)DAO.findAll();
        return klantList;
    }
    
    public Klant update(Klant klant){
        DAO.update(klant);
        return klant;
    }
    
    public void delete(int klantId){
        DAO.deleteById(klantId);
    }
    
    public void delete(Klant klant){
        DAO.delete(klant);
    }
    
}