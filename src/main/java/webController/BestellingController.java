/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webController;

import Config.SpringConfig;
import POJO.*;
import Service.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Gebruiker
 */
public class BestellingController extends HttpServlet {
    
    private static String INSERT_OR_EDIT = "/bestelling.jsp";
    private static String LIJST_KLANTEN = "/klantenLijst.jsp";
    private static String LIJST_BESTELLINGEN = "/bestellingenLijst.jsp";
    private static String LIJST_BESTELARTIKEL = "/bestellingArtikelLijst.jsp";
    private static String LIJST_ARTIKELEN = "/artikelenLijst.jsp";
    private KlantService klantService;
    private BestellingService bestellingService;
    private BestellingArtikelService bestellingArtikelService;
    private ArtikelService artikelService;
    
    public BestellingController() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        this.klantService = context.getBean(KlantService.class);
        this.bestellingService = context.getBean(BestellingService.class);
        this.bestellingArtikelService = context.getBean(BestellingArtikelService.class);
        this.artikelService = context.getBean(ArtikelService.class);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        String klantId = request.getParameter("klantId");
        String bestellingId = request.getParameter("bestellingId");
        String artikelId = request.getParameter("artikelId");
        
        if (action.equalsIgnoreCase("lijstBestellingen")) {
            //waar ga je heen
            forward = LIJST_BESTELLINGEN;
            
            ArrayList<Bestelling> bestellingen = bestellingService.findByKlantId(Integer.parseInt(klantId));
            //wat stuur je mee
            request.setAttribute("klantId", klantId);
            request.setAttribute("bestellingen", bestellingen);
        } else if (action.equalsIgnoreCase("edit")) {
            //waar ga je heen
            forward = INSERT_OR_EDIT;
            Bestelling bestelling = bestellingService.findById(Integer.parseInt(bestellingId));
            //wat stuur je mee

            request.setAttribute("klantId", klantId);
            request.setAttribute("bestelling", bestelling);
        } else if (action.equalsIgnoreCase("open")) {
            //waar ga je heen
            forward = LIJST_BESTELARTIKEL;
            ArrayList<BestellingArtikel> lijst = bestellingArtikelService.findByBestellingId(Integer.parseInt(bestellingId));
            for (BestellingArtikel ba : lijst) {
                //Artikel a = ba.getArtikel();
                //String naam = a.getArtikelNaam();
                System.out.println(ba.getID());
            }
            //wat stuur je mee
            request.setAttribute("klantId", klantId);
            request.setAttribute("bestellingId", bestellingId);
            request.setAttribute("bestellingArtikelLijst", lijst);
        } else if (action.equalsIgnoreCase("choose")) {
            //waar ga je heen
            forward = LIJST_ARTIKELEN;
            ArrayList<Artikel> lijst = artikelService.findAll();
            //wat stuur je mee
            request.setAttribute("klantId", klantId);
            request.setAttribute("bestellingId", bestellingId);
            request.setAttribute("artikelLijst", lijst);
        } else if (action.equalsIgnoreCase("add")) {
            //waar ga je heen
            Bestelling bestelling = bestellingService.findById(Integer.parseInt(bestellingId));
            Artikel artikel = artikelService.findById(Integer.parseInt(artikelId));
            ArrayList<BestellingArtikel> lijst = bestellingArtikelService.findByBestellingId(Integer.parseInt(bestellingId));
            boolean inBasket = false;
            BestellingArtikel ba = new BestellingArtikel();
            for(BestellingArtikel b : lijst){
                int a1 = b.getArtikel().getArtikelID();
                int a2 = artikel.getArtikelID();
                if(a1==a2){
                    inBasket = true;
                    ba = b;
                }
            }
            if (inBasket) {
                ba.setAantal(ba.getAantal() + 1);
                bestellingArtikelService.update(ba);
            } else {
                ba.setArtikel(artikel);
                ba.setBestelling(bestelling);
                bestellingArtikelService.save(ba);
            }
            forward = LIJST_BESTELARTIKEL;

            //wat stuur je mee
            request.setAttribute("klantId", klantId);
            request.setAttribute("bestellingId", bestellingId);
            request.setAttribute("bestellingArtikelLijst", lijst);
        } else if (action.equalsIgnoreCase("delete")) {
            //waar ga je heen
            forward = LIJST_BESTELLINGEN;
            bestellingService.delete(Integer.parseInt(bestellingId));
            //wat stuur je mee

            ArrayList<Bestelling> bestellingen = bestellingService.findByKlantId(Integer.parseInt(klantId));
            request.setAttribute("klantId", klantId);
            request.setAttribute("bestellingen", bestellingen);
        } else {
            forward = INSERT_OR_EDIT;
            //request.setAttribute("klantId", 11);
            //Bestelling bestelling =  bestellingService.findById(Integer.parseInt(bestellingId));
            request.setAttribute("klantId", klantId);
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

        /*
        request.setAttribute("users", dao.findAll());
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
         */
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String forward = "";
        String klantId = request.getParameter("klantId");
        String bestellingId = request.getParameter("bestellingId");

        //Klant klant = klantService.findByBestellingId(Integer.parseInt(bestellingId));
        if (bestellingId == null || bestellingId.isEmpty()) {
            //if(action.equalsIgnoreCase("insert")){
            Klant klant = klantService.findById(Integer.parseInt(klantId));
            //nieuwe bestelling toevoegen
            Bestelling bestelling = new Bestelling();
            bestelling.setTotaalPrijs(new BigDecimal(Integer.parseInt(request.getParameter("totaalPrijs"))));
            bestelling.setKlant(klant);
            
            klant.setBestellingSet(bestelling);
            klantService.update(klant);
            
            forward = LIJST_BESTELLINGEN;
            ArrayList<Bestelling> bestellingen = bestellingService.findAll();
            request.setAttribute("klantId", klantId);
            request.setAttribute("bestellingen", bestellingen);
        } else {
            //bestelling updaten

            Bestelling bestelling = bestellingService.findById(Integer.parseInt(bestellingId));
            bestelling.setTotaalPrijs(new BigDecimal(Integer.parseInt(request.getParameter("totaalPrijs"))));
            bestelling.setBestellingID(Integer.parseInt(bestellingId));
            
            bestellingService.update(bestelling);
            
            forward = LIJST_BESTELLINGEN;
            //ArrayList<Bestelling> bestellingen =  bestellingService.findByKlantId(Integer.parseInt(klantId));
            ArrayList<Bestelling> bestellingen = bestellingService.findAll();
            request.setAttribute("klantId", klantId);
            request.setAttribute("bestellingen", bestellingen);
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
}
