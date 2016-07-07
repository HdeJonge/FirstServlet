/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Peter
 */


import Config.SpringConfig;
import View.ArtikelView;
import POJO.Artikel;
import Service.ArtikelService;
import View.ArtikelKeuzeView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Peter
 */
public class ArtikelController {
    public ArtikelService artikelService;
    
    public ArtikelController() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        this.artikelService = context.getBean(ArtikelService.class);
    }
        
    public static void startKeuze(){
        ArtikelKeuzeView view = new ArtikelKeuzeView();   
        view.keuze();
        ArtikelController AC = new ArtikelController();
        switch (view.getSelect()) {
            case 1:
                AC.create();
                break;
            case 2:
                AC.update();
                break;
            case 3:
                AC.readAll();
                break;            
            case 4:
                AC.readByID();
                break;
            case 5:
                AC.delete();
                break;
            case 0:
                MainController.hoofdMenu();
                break;
            default:
                view.herhaalKeuze();
                break;
        }
        if(view.getSelect() != 0){
            startKeuze();
        }
    }
    
    public void create(){
        ArtikelView aView = new ArtikelView();
        aView.create();
        Artikel artikel = new Artikel();
        artikel.setArtikelNaam(aView.getArtikel_naam());
        artikel.setArtikelPrijs(aView.getArtikel_prijs());
        artikel.setArtikelVoorraad(aView.getArtikel_voorraad());
        artikelService.save(artikel);
    }
    
    public void update(){
        ArtikelView aView = new ArtikelView();
        aView.update();
        Artikel artikel = new Artikel();                      
        artikel.setArtikelID(aView.getArtikel_id());
        artikel.setArtikelNaam(aView.getArtikel_naam());
        artikel.setArtikelVoorraad(aView.getArtikel_voorraad());
        artikel.setArtikelPrijs(aView.getArtikel_prijs());
        artikelService.update(artikel);
    }
    
    public void delete(){
        ArtikelView aView = new ArtikelView();
        aView.delete();
        artikelService.delete(aView.getArtikel_id());
     }
    
    public void readByID(){
        ArtikelView aView = new ArtikelView();
        aView.readArtikelById();
        aView.print(artikelService.findById(aView.getArtikel_id()));
    }
    
    public void readAll(){
        //nodig om de print functie aan te roepen
        ArtikelView aView = new ArtikelView();
        aView.print(artikelService.findAll());
    }
}
