/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;
import DAO.Hibernate.BestellingDAOHibernate;
import Service.BestellingService;
import interfaceDAO.IBestellingDAO;
import org.springframework.context.annotation.*;
/**
 *
 * @author Gebruiker
 */
@Configuration
@ComponentScan(basePackages={"Service","DAO.Hibernate"})
public class SpringConfig {
    /*
    @Bean 
    public IBestellingDAO bestellingDAO(){
        return new BestellingDAOHibernate();
    }
    @Bean
    public BestellingService bestellingService(IBestellingDAO bestellingDAO){
        return new BestellingService(bestellingDAO);
    }
    
    /*
    @Bean
    public BestellingController bestellingController(BestellingService bestellingService){
        return new BestellingController(bestellingService);
    }
    */
}
