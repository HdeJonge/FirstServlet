/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Hibernate;

import POJO.*;
import interfaceDAO.IBestellingArtikelDAO;
import interfaceDAO.IBestellingDAO;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gebruiker
 */
@Component
public class BestellingArtikelDAOHibernate extends GenericDAO<BestellingArtikel,Integer> implements IBestellingArtikelDAO {
    public BestellingArtikelDAOHibernate(){
        super(BestellingArtikel.class);
    }
    public ArrayList<BestellingArtikel> findByBestellingId(int bestellingId){
        openCurrentSessionWithTransaction();
        Query query = getCurrentSession().createQuery("from BestellingArtikel where bestelling_Id = :bestellingId");
        query.setParameter("bestellingId", bestellingId);
        ArrayList<BestellingArtikel> bestellingArtikelLijst = (ArrayList<BestellingArtikel>) query.list();
        closeCurrentSessionWithTransaction();
        return bestellingArtikelLijst;
    }
    public BestellingArtikel findByArtikelId(int artikelId){
        openCurrentSessionWithTransaction();
        Query query = getCurrentSession().createQuery("from BestellingArtikel where artikel_Id = :artikelId");
        query.setParameter("artikelId", artikelId);
        BestellingArtikel bestellingArtikel = (BestellingArtikel) query.list();
        closeCurrentSessionWithTransaction();
        return bestellingArtikel;
    }
}
