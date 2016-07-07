/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * 
 * 
 *  Allemaal niet meer nodig
 *
package Controller;

import POJO.*;
import Service.*;
import View.*;


public class BestellingArtikelController {
    
    private static BestellingArtikelView view  = new BestellingArtikelView();
    private static BestellingArtikelService BS = new BestellingArtikelService();
    
    public static void create(){
        view.readUpdate();
        
        //haal artikel op
        Artikel artikel = new ArtikelService().findById(view.getArtikelID());

        //haal bestelling op
        Bestelling bestelling = new BestellingService().findById(view.getBestellingID());
        
        BestellingArtikel koppel = new BestellingArtikel();        
        koppel.setBestelling(bestelling);
        koppel.setArtikel(artikel);
        koppel.setAantal(view.getAantal());

        BS.save(koppel);
    }

    public static void read(){
        view.readBestellingID();
        view.printArtikelLijst(BS.findByBestellingId(view.getBestellingID()));
    }
    
    public static void update(){
        view.readUpdate();
        
        BestellingArtikel koppel = BS.findById(view.getBestellingArtikelID());
        koppel.setAantal(view.getAantal());
       
        BS.update(koppel); 
    }
    
    public static void delete(){
        view.readDelete();
        BS.delete(view.getBestellingArtikelID());
    }

}
*/