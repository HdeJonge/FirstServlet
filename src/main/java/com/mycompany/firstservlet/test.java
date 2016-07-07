/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.firstservlet;


import DAO.Hibernate.*;
import POJO.*;
import Service.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gebruiker
 */
public class test {
    public static void main(String[]args){
        KlantDAOHibernate dao = new KlantDAOHibernate();
        Klant klant = dao.findByBestellingId(11);
        System.out.println("klant: " + klant.getVoornaam());
    }    
    

}
