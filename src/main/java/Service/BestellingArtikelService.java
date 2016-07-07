/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.Hibernate.*;
import POJO.BestellingArtikel;
import interfaceDAO.IBestellingArtikelDAO;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gebruiker
 */
@Component
public class BestellingArtikelService {
    private static IBestellingArtikelDAO DAO;
    
    @Autowired
    public BestellingArtikelService(IBestellingArtikelDAO bestellingArtikelDAO){
        DAO = bestellingArtikelDAO;
    }
    //create koppel
    public void save(BestellingArtikel bestellingArtikel){
        DAO.save(bestellingArtikel);
    }

    //read all koppel
    public BestellingArtikel findById(int bestellingArtikelId){
        BestellingArtikel bestellingArtikel = DAO.findById(bestellingArtikelId);
        return bestellingArtikel;
        
    }
    
    //read by id koppel
    public ArrayList<BestellingArtikel> findByBestellingId(int bestellingId){
        ArrayList<BestellingArtikel> BestellingArtikelList = DAO.findByBestellingId(bestellingId);
        return BestellingArtikelList;
    }
    
    //update koppel
    public void update(BestellingArtikel koppel){
        DAO.update(koppel);
    }    
    //delete
    public void delete(int bestellingArtikelID){
        DAO.deleteById(bestellingArtikelID);
    }
}
