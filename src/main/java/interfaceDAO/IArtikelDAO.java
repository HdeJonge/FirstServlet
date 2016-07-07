/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import POJO.Artikel;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Peter
 * 
 */

/**
 * 
 * Lege interface om de speciaal alleen om de service laag te vergelijken
 * Eventueel kan je hier nog dingen toevoegen zoals findByVoorraad()
 */
public interface IArtikelDAO extends IGenericDAO<Artikel, Integer> {
    
    /**
    Artikel save(Artikel artikel);
    
    Artikel findById(int artikel_id);

    ArrayList<Artikel> findAll();
    
    void delete(Artikel artikel);

    void update(Artikel artikel);
    */
    
    
}
