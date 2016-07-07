/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

/**
 *
 * @author lucas
 */
import POJO.Klant;
import java.util.ArrayList;
        
public interface IKlantDAO extends IGenericDAO<Klant, Integer> {
    
    public Klant findByBestellingId(int bestellingId);
}
