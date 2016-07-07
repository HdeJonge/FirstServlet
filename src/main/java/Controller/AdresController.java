package Controller;

/**
 *
 * @author Sonja
 * 
 */

import Config.SpringConfig;
import View.AdresView;
import POJO.Adres;
import Service.AdresService;
import View.AdresKeuzeView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AdresController {
    public static AdresView adresView = new AdresView();
    
    public AdresService adresService;
    
    public AdresController() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AdresService adresService = context.getBean(AdresService.class);
        this.adresService = adresService;
    }
    
    public void startKeuze() {
        AdresKeuzeView view = new AdresKeuzeView();
        view.keuze();
        
        switch (view.getSelect()) {
            case 1:
                create();
                break;
            case 2:
                update();
                break;
            case 3:
                readAll();
                break;
            case 4:
                readByID();
                break;
            case 5: 
                delete();
                break;
            case 0:
                MainController.hoofdMenu();
                break;
            default:
                view.herhaalKeuze();
                break;
        }
        if(view.getSelect() != 0) {
            startKeuze();
        }
    }
    
    public void create() {
        adresView.create();
        Adres adres = new Adres();
        
        adres.setAdres_id(adresView.getAdres_id());
        adres.setStraatnaam(adresView.getStraatnaam());
        adres.setHuisnummer(adresView.getHuisnummer());
        adres.setToevoeging(adresView.getToevoeging());
        adres.setPostcode(adresView.getPostcode());
        adres.setWoonplaats(adresView.getWoonplaats());
        
        adresService.save(adres);
    }
    
    public void update() {
        adresView.update();
        Adres adres = new Adres();
        
        adres.setStraatnaam(adresView.getStraatnaam()); 
        adres.setHuisnummer(adresView.getHuisnummer());
        adres.setToevoeging(adresView.getToevoeging());
        adres.setPostcode(adresView.getPostcode());
        adres.setWoonplaats(adresView.getWoonplaats());
        
        adresService.update(adres);
    }
    
    public void readAll() {
        adresView.readAll(adresService.findAll());
    }
    
    public void readByID() {
        adresView.readAdresByID();
        adresView.readAdresByID(adresService.findById(adresView.getAdres_id()));
    }
    
    public void delete() {
        adresView.readAdresByID();
        adresService.delete(adresView.getAdres_id());
    }
}