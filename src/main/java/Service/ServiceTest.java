/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import POJO.*;
import java.math.BigDecimal;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Gebruiker
 */
public class ServiceTest {
    public static void main(String[]args){
        
        /*
        KlantService serv = new KlantService();
        Klant klant = serv.findById(8);
        System.out.println(klant.getKlant_id());
        
        
        AdresService as = new AdresService();
        Adres adres = as.readByID(1);
        System.out.println(adres.getAdres_id());
        klant.setAdresSet(adres);
        
        serv.update(klant);
        */
        
        /*
        KlantService serv = new KlantService();
        serv.delete(7);
        */
        
        //Bestelling aanmaken
        
        //ArtikelService aserv = new ArtikelService();
        
        /*
        KlantService serv = new KlantService();
        Klant klant = serv.findById(4);
        System.out.println(klant.getKlant_id());   
        
        //Artikel artikel = aserv.findById(2);
        
        Bestelling bestelling = new Bestelling();
        
        BestellingArtikel koppel = new BestellingArtikel();
        koppel.setAantal(2);
        koppel.setBestelling(bestelling);
        //koppel.setArtikel(artikel);
        
        bestelling.setBestellingArtikelSet(koppel);
        bestelling.setKlant(klant);
 
        klant.setBestellingSet(bestelling);
        
        serv.update(klant);

        

        //klant verwijderen
        /*
        KlantService serv = new KlantService();
        serv.delete(4);
        */
        System.exit(0);


    }

    
}
