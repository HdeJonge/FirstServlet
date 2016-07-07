package Service;

import DAO.Hibernate.*;
import POJO.Adres;
import interfaceDAO.*;
import java.util.ArrayList;

/**
 *
 * @author Sonja
 * 
 */

public class AdresService {
    
    private static IAdresDAO DAO;
    
    public AdresService(IAdresDAO adresDAO){
        DAO = adresDAO;
    }
    
    public void save(Adres adres) {
        DAO.save(adres);
    }
    
    public void update(Adres adres) {
        DAO.update(adres);
    }
    
    public ArrayList<Adres> findAll() {
        ArrayList<Adres> adresGegevens = (ArrayList<Adres>)DAO.findAll();
        return adresGegevens;
    }
    
    public Adres findById(int adresId) {
        Adres adres = (Adres)DAO.findById(adresId);
        return adres;
    }
    
    public void delete (int adresId) {
        Adres adres = findById(adresId);
        DAO.delete(adres);
    }
    
    public void delete (Adres adres) {
        DAO.delete(adres);
    }
}
