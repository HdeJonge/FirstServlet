/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Config.SpringConfig;
import POJO.*;
import Service.*;
import View.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 *
 * @author Gebruiker
 */

public class BestellingController {
    public static BestellingView view = new BestellingView();
    /*
    public static BestellingService bestellingService;
    
    public BestellingController(BestellingService bestellingService){
        this.bestellingService = bestellingService;
    }
    */
    
    public BestellingService bestellingService;
    public ArtikelService artikelService;
    public KlantService klantService;
    
    public BestellingController(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        this.bestellingService = context.getBean(BestellingService.class);
        this.artikelService = context.getBean(ArtikelService.class);
        this.klantService = context.getBean(KlantService.class);
                
    }
            
    public void startKeuze(){
        
        BestellingKeuzeView keuzeView = new BestellingKeuzeView();
        keuzeView.keuzeView();
        
      
        switch (keuzeView.getSelect()) {
            case 1:
                create();
                break;
            case 2:
                update();
                break;
            case 3:
                //BestellingArtikelController.update();
                break;
            case 4:
                readAll();
                break;
            case 5:
                readByID();
                break;
            case 6:
                //haal alle bestellingen op van een klant
                readByKlantID();
                break;
            case 7:
                //haal alle artikelen (bestellingArtikel op van een klant
                readArtikelen();
                break;
            case 8:
                //BestellingArtikelController.delete();
                break;
            case 9:
                delete();
                break;
            case 0:
                MainController.hoofdMenu();
                break;
            default:
                view.keuzeFout();
                break;
            }
        if(keuzeView.getSelect() != 0){
            startKeuze();
        }
        
    }
    public  void create(){
        //maak een nieuwe bestellingview waarin je vraagt voor welke klant
        //de bestelling is
        view.readKlantID();
        Klant klant = klantService.findById(view.getKlantId());
        
        //Nieuwe Bestelling
        Bestelling bestelling = new Bestelling();
        bestelling.setKlant(klant);
        
        //System.out.println("THIS IS A LOG: " + bestelling.getKlant().toString());

        //Nieuw artikel
        Artikel artikel = artikelService.findById(view.getArtikelId());
        
        //Nieuw koppel
        BestellingArtikel koppel = new BestellingArtikel();
        koppel.setAantal(view.getAantal());
        koppel.setArtikel(artikel);
        koppel.setBestelling(bestelling);
        
        bestelling.setBestellingArtikelSet(koppel);

        System.out.println("THIS IS A LOG  1");
        bestellingService.save(bestelling);
    }

    public  void update(){
        view.addArtikel();
        //haal bestelling op
        Bestelling bestelling = bestellingService.findById(view.getBestellingId());
        
        //haal artikel op
        Artikel artikel = artikelService.findById(view.getArtikelId());
        
        //maak nieuw koppel aan
        BestellingArtikel bestellingArtikel = new BestellingArtikel();
        bestellingArtikel.setAantal(view.getAantal());
        bestellingArtikel.setArtikel(artikel);
        bestellingArtikel.setBestelling(bestelling);
        
        //voeg nieuw koppel toe
        bestelling.setBestellingArtikelSet(bestellingArtikel);
        
        bestellingService.update(bestelling);
    }

    public  void readAll(){
        view.printBestellingen(bestellingService.findAll());
    }
    
    public  void readByID(){
        view.readBestellingID();
        view.print(bestellingService.findById(view.getBestellingId()));
    }
    
    public  void readByKlantID(){
        view.readKlantID();
        view.printBestellingen(bestellingService.findByKlantId(view.getKlantId()));
    }
    
    public  void readArtikelen(){
        view.readKlantID();
        //haal bestelling op
        Bestelling bestelling = bestellingService.findById(view.getBestellingId());
        view.printArtikelen(bestelling.getBestellingArtikelSet());
    }

    public  void delete(){
        view.readBestellingID();
        bestellingService.delete(view.getBestellingId());
    }
}
