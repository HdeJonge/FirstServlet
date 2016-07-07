/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import POJO.*;
import java.util.ArrayList;

/**
 *
 * @author Gebruiker
 */
public interface IBestellingArtikelDAO extends IGenericDAO<BestellingArtikel,Integer>{
        public ArrayList<BestellingArtikel> findByBestellingId(int bestellingId);
}
