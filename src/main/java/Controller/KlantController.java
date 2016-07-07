/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author lucas
 * 
 * KlantController is part of the Klant MVC
 * 
 */

import View.KlantView;
import View.KlantKeuzeView;
import View.AdresView;
import POJO.Klant;
import POJO.Adres;
import POJO.KlantAdres;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import interfaceDAO.KlantDAO;
import interfaceDAO.AdresDAO;
import interfaceDAO.KlantAdresDAO;

import Service.*;
import Config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class KlantController {
    private KlantView kView = new KlantView();
    public KlantService klantService;
    public AdresService adresService;
    
    
    public KlantController(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        this.klantService = context.getBean(KlantService.class);
        this.adresService = context.getBean(AdresService.class);
    }
    
    
    public static void startKeuze(){
        KlantController deze = new KlantController();
        KlantKeuzeView keuze = new KlantKeuzeView();
        keuze.keuzeView();
      
        switch (keuze.getSelect()) {
            case 1:
                deze.create();
                break;
            case 2:
                deze.read();
                break;
            case 3:
                deze.update();
                break;
            case 4:
                deze.delete();
                break;
            case 5:
                deze.readAllByObject();
                break;
            case 6:
                deze.readAll();
                break;
            case 0:
                MainController.hoofdMenu();
                return;
            default:
                break;
        }
        startKeuze();
    }
    
    public void create(){
        kView.create();
        Klant klant = klantViewToKlant(kView);
        
//        try {
            klantService.save(klant);
//        }
//        catch (MySQLIntegrityConstraintViolationException ex){
//            kView.KlantBestaatAl();
//        }
        
        //maak een nieuw adres aan
        AdresView adresView = new AdresView();
        adresView.create();
        
        Adres adres = new Adres();
        adres.setAdres_id(adresView.getAdres_id());
        adres.setStraatnaam(adresView.getStraatnaam());
        adres.setHuisnummer(adresView.getHuisnummer());
        adres.setToevoeging(adresView.getToevoeging());
        adres.setPostcode(adresView.getPostcode());
        adres.setWoonplaats(adresView.getWoonplaats());
        
        
        adresService.save(adres);
        //koppel de klant aan het adres
        klant.setAdresSet(adres);
        klantService.update(klant);
        
        

    }
    
    public void read(){
        kView.read();
        kView.print(klantService.findById( kView.getKlant_id() )
        );
    }
    
    public void update(){
        Klant klant = klantViewToKlant( kView.update() );
        kView.printUpdate(klantService.update(klant) );
    }
    
//    public void delete(){
//        kView.delete();
//        KlantAdresDAO klantAdresDAO = new DAOFactory().getKlantAdresDAO();
//        klantAdresDAO.deleteKlantAdresKoppel( kView.getKlant_id() );
//        try {
//        new DAOFactory().getKlantDAO().deleteKlant( kView.getKlant_id() );
//        }
//        catch (MySQLIntegrityConstraintViolationException ex){
//            kView.KlantInKlantAdresTabel();
//        }
//    }
    public void delete(){
        kView.delete();
        klantService.delete( klantViewToKlant(kView) );
    }
    
    public void readAllByObject(){
        System.out.println("Function not supported atm.");
//        kView.readAllByKlant();
//        kView.print(new DAOFactory().getKlantDAO().readAllKlantByKlant( klantViewToKlant( kView ) )
//        );
    }
    
    public void readAll(){
        kView.print(klantService.findAll()
        );
    }
    
    
    public static Klant klantViewToKlant(KlantView kview){
        Klant klant = new Klant();
        klant.setKlant_id(kview.getKlant_id());
        klant.setVoornaam(kview.getVoornaam());
        klant.setAchternaam(kview.getAchternaam());
        klant.setTussenvoegsel(kview.getTussenvoegsel());
        klant.setEmail(kview.getEmail());
        
        return klant;
    }
    
}
