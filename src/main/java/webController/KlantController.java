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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 *
 * @author Gebruiker
 */
public class KlantController extends HttpServlet{
    private static String INSERT_OR_EDIT = "/klant.jsp";
    private static String LIJST_KLANTEN = "/klantenLijst.jsp";
    private static String LIJST_BESTELLINGEN = "/bestellingenLijst.jsp";
    private KlantService service;
    private BestellingService bestellingService;
    
    public KlantController(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        this.service = context.getBean(KlantService.class);
        this.bestellingService = context.getBean(BestellingService.class);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward= "";
        String action = request.getParameter("action");
        
        
        if (action.equalsIgnoreCase("delete")){            
            //waar word je heen gestuurd
            forward = LIJST_KLANTEN;
            
            //tussenstap
            int userId = Integer.parseInt(request.getParameter("userId"));
            service.delete(userId);
            
            //wat stuur je mee
            request.setAttribute("klanten", service.findAll());    
        } 
        else if (action.equalsIgnoreCase("edit")){
            //waar word je heen gestuurd
            forward = INSERT_OR_EDIT;
            
            //tussen stap
            int userId = Integer.parseInt(request.getParameter("userId"));
            Klant klant = service.findById(userId);
            
            //wat stuur je mee
            request.setAttribute("klant", klant);
        } 
        else if (action.equalsIgnoreCase("lijstKlanten")){
            //waar ga je heen
            forward = LIJST_KLANTEN;
            
            //wat stuur je mee
            request.setAttribute("klanten", service.findAll());
        
        } 
        else {
            forward = INSERT_OR_EDIT;
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
        
        Klant klant = new Klant();
        klant.setVoornaam(request.getParameter("vnaam"));
        klant.setAchternaam(request.getParameter("anaam"));
        klant.setTussenvoegsel(request.getParameter("tv"));
        klant.setEmail(request.getParameter("email"));
        String id = request.getParameter("id");
        
        if(id == null || id.isEmpty())
        {
            forward=LIJST_KLANTEN;
            service.save(klant);
            request.setAttribute("klanten", service.findAll());
        }
        /*else if(action.equalsIgnoreCase("bestellingen")){
            forward=LIJST_BESTELLINGEN;
            //request.setAttribute("bestellinigen", service.findById(Integer.parseInt(id)));
        }*/
        else
        {
            forward=LIJST_KLANTEN;
            klant.setKlant_id(Integer.parseInt(id));
            service.update(klant);
            request.setAttribute("klanten", service.findAll());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
   }
    
}
