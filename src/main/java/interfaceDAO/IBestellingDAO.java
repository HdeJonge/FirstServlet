/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import DAO.Hibernate.GenericDAO;
import POJO.Bestelling;
import java.util.ArrayList;

/**
 *
 * @author Gebruiker
 */
public interface IBestellingDAO extends IGenericDAO<Bestelling,Integer>{
    public ArrayList<Bestelling> findByKlantId(int klantId);

}
