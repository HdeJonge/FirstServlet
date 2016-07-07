/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Hibernate;

import POJO.*;
import java.util.ArrayList;
import interfaceDAO.IKlantDAO;
import org.springframework.stereotype.Component;
import org.hibernate.*;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Gebruiker
 */
@Component
public class KlantDAOHibernate extends GenericDAO<Klant,Integer> implements IKlantDAO {
    
    public KlantDAOHibernate() {
        super(Klant.class);
    }
    @Override
    public Klant findByBestellingId(int bestellingId){
        openCurrentSessionWithTransaction();
        Query query = getCurrentSession().createQuery("from Klant where bestelling_id = :bestellingId");
        query.setParameter("bestellingId", bestellingId);
        Klant klant = (Klant) query.list();
        closeCurrentSessionWithTransaction();
        return klant;
    }

    
    
//    private Session currentSession;
//    private Transaction currentTransaction;
//
//    public Session getCurrentSession() {
//        return currentSession;
//    }
//
//    public void setCurrentSession(Session currentSession) {
//        this.currentSession = currentSession;
//    }
//
//    public Transaction getCurrentTransaction() {
//        return currentTransaction;
//    }
//
//    public void setCurrentTransaction(Transaction currentTransaction) {
//        this.currentTransaction = currentTransaction;
//    }
//
//    public Session openCurrentSession(){
//        currentSession = getSessionFactory().openSession();
//        return currentSession;
//    }
//    
//    public Session openCurrentSessionWithTransaction(){
//        currentSession = getSessionFactory().openSession();
//        currentTransaction = currentSession.beginTransaction();
//        return currentSession;
//    }
//    
//    public void closeCurrentSession(){
//        currentSession.close();
//    }
//    
//    public void closeCurrentSessionWithTransaction(){
//        currentSession = getSessionFactory().openSession();
//        currentTransaction.commit();
//        currentSession.close();
//    }
//
//    public SessionFactory getSessionFactory(){
//        StandardServiceRegistry ssrb = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//        MetadataSources ms = new MetadataSources(ssrb);
//        ms.addAnnotatedClass(Klant.class);
//        ms.addAnnotatedClass(Adres.class);
//        ms.addAnnotatedClass(Account.class);
//        ms.addAnnotatedClass(Bestelling.class);
//        ms.addAnnotatedClass(BestellingArtikel.class);
//        ms.addAnnotatedClass(Artikel.class);
//        SessionFactory sf = ms.buildMetadata().buildSessionFactory();
//        return sf;
//    }

//    public Klant save(Klant klant) {
//        getCurrentSession().save(klant);
//        return klant;
//    }
//    
//    public Klant findById(int klant_id){
//        Klant klant = (Klant) getCurrentSession().get(Klant.class, klant_id);
//        return klant;
//    }
//
//    public ArrayList<Klant> findAll(){
//        ArrayList<Klant> klanten = (ArrayList<Klant>) getCurrentSession().createQuery("from Klant").list();
//        return klanten;
//    }
//    
//    public void update(Klant klant){
//        getCurrentSession().merge(klant);
//    }
//    
//    public void delete(Klant klant){
//        getCurrentSession().delete( findById( klant.getKlant_id() ) );
//    }
    
    /*
    public void delete(int klant_id){
        getCurrentSession().delete( findById(klant_id) );
    }
*/
}
