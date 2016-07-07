/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Hibernate;

import POJO.*;
import interfaceDAO.IBestellingDAO;
import java.util.ArrayList;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gebruiker
 */
@Component
public class BestellingDAOHibernate extends GenericDAO<Bestelling,Integer> implements IBestellingDAO{
    public BestellingDAOHibernate() {
        super(Bestelling.class);
    }
    @Override
    public ArrayList<Bestelling> findByKlantId(int klantId){
        openCurrentSessionWithTransaction();
        Query query = getCurrentSession().createQuery("from Bestelling where klant_id = :klantId");
        query.setParameter("klantId", klantId);
        ArrayList<Bestelling> bestellingen = (ArrayList<Bestelling>) query.list();
        closeCurrentSessionWithTransaction();
        return bestellingen;
    }

        
        
        
    /*
    private Session currentSession;
    private Transaction currentTransaction;

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public Session openCurrentSession(){
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    
    public Session openCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    
    public void closeCurrentSession(){
        currentSession.close();
    }
    
    public void closeCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction.commit();
        currentSession.close();
    }

    public SessionFactory getSessionFactory(){
        StandardServiceRegistry ssrb = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        MetadataSources ms = new MetadataSources(ssrb);
        ms.addAnnotatedClass(Bestelling.class);
        ms.addAnnotatedClass(BestellingArtikel.class);
        ms.addAnnotatedClass(Artikel.class);
        ms.addAnnotatedClass(Klant.class);
        ms.addAnnotatedClass(Account.class);
        ms.addAnnotatedClass(Adres.class);
        SessionFactory sf = ms.buildMetadata().buildSessionFactory();
        return sf;
    }

    @Override
    public void save (Bestelling bestelling) {
        openCurrentSession();
        getCurrentSession().save(bestelling);
        closeCurrentSession();
    }
    
    @Override
    public Bestelling findById(int BestellingId){
        openCurrentSession();
        Bestelling bestelling = (Bestelling) getCurrentSession().get(Bestelling.class, BestellingId);
        closeCurrentSession();
        return bestelling;
    }

    @Override
    public ArrayList<Bestelling> findAll(){
        openCurrentSession();
        ArrayList<Bestelling> bestellingen = (ArrayList<Bestelling>) getCurrentSession().createQuery("from bestelling").list();
        closeCurrentSession();
        return bestellingen;
    }
    @Override
    public ArrayList<Bestelling> findByKlantId(int klantId){
        openCurrentSessionWithTransaction();
        Query query = getCurrentSession().createQuery("from Bestelling where id = :klantId");
        query.setParameter("klantId", klantId);
        ArrayList<Bestelling> bestellingen = (ArrayList<Bestelling>) query.list();
        closeCurrentSessionWithTransaction();
        return bestellingen;
    }
    
    @Override
    public void update(Bestelling bestelling){
        openCurrentSessionWithTransaction();
        getCurrentSession().update(bestelling);
        closeCurrentSessionWithTransaction();
    }

    @Override
    public void delete(Bestelling bestelling) {
        openCurrentSessionWithTransaction();
        getCurrentSession().delete(bestelling);
        closeCurrentSessionWithTransaction();
    }
*/


    /*
    private Session currentSession;
    private Transaction currentTransaction;

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public Session openCurrentSession(){
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    
    public Session openCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    
    public void closeCurrentSession(){
        currentSession.close();
    }
    
    public void closeCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction.commit();
        currentSession.close();
    }

    public SessionFactory getSessionFactory(){
        StandardServiceRegistry ssrb = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        MetadataSources ms = new MetadataSources(ssrb);
        ms.addAnnotatedClass(Bestelling.class);
        ms.addAnnotatedClass(BestellingArtikel.class);
        ms.addAnnotatedClass(Artikel.class);
        ms.addAnnotatedClass(Klant.class);
        ms.addAnnotatedClass(Account.class);
        ms.addAnnotatedClass(Adres.class);
        SessionFactory sf = ms.buildMetadata().buildSessionFactory();
        return sf;
    }

    @Override
    public void save (Bestelling bestelling) {
        openCurrentSession();
        getCurrentSession().save(bestelling);
        closeCurrentSession();
    }
    
    @Override
    public Bestelling findById(int BestellingId){
        openCurrentSession();
        Bestelling bestelling = (Bestelling) getCurrentSession().get(Bestelling.class, BestellingId);
        closeCurrentSession();
        return bestelling;
    }

    @Override
    public ArrayList<Bestelling> findAll(){
        openCurrentSession();
        ArrayList<Bestelling> bestellingen = (ArrayList<Bestelling>) getCurrentSession().createQuery("from bestelling").list();
        closeCurrentSession();
        return bestellingen;
    }
    @Override
    public ArrayList<Bestelling> findByKlantId(int klantId){
        openCurrentSessionWithTransaction();
        Query query = getCurrentSession().createQuery("from Bestelling where id = :klantId");
        query.setParameter("klantId", klantId);
        ArrayList<Bestelling> bestellingen = (ArrayList<Bestelling>) query.list();
        closeCurrentSessionWithTransaction();
        return bestellingen;
    }
    
    @Override
    public void update(Bestelling bestelling){
        openCurrentSessionWithTransaction();
        getCurrentSession().update(bestelling);
        closeCurrentSessionWithTransaction();
    }

    @Override
    public void delete(Bestelling bestelling) {
        openCurrentSessionWithTransaction();
        getCurrentSession().delete(bestelling);
        closeCurrentSessionWithTransaction();
    }
*/



    /*
    private Session currentSession;
    private Transaction currentTransaction;

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public Session openCurrentSession(){
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    
    public Session openCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    
    public void closeCurrentSession(){
        currentSession.close();
    }
    
    public void closeCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction.commit();
        currentSession.close();
    }

    public SessionFactory getSessionFactory(){
        StandardServiceRegistry ssrb = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        MetadataSources ms = new MetadataSources(ssrb);
        ms.addAnnotatedClass(Bestelling.class);
        ms.addAnnotatedClass(BestellingArtikel.class);
        ms.addAnnotatedClass(Artikel.class);
        ms.addAnnotatedClass(Klant.class);
        ms.addAnnotatedClass(Account.class);
        ms.addAnnotatedClass(Adres.class);
        SessionFactory sf = ms.buildMetadata().buildSessionFactory();
        return sf;
    }

    @Override
    public void save (Bestelling bestelling) {
        openCurrentSession();
        getCurrentSession().save(bestelling);
        closeCurrentSession();
    }
    
    @Override
    public Bestelling findById(int BestellingId){
        openCurrentSession();
        Bestelling bestelling = (Bestelling) getCurrentSession().get(Bestelling.class, BestellingId);
        closeCurrentSession();
        return bestelling;
    }

    @Override
    public ArrayList<Bestelling> findAll(){
        openCurrentSession();
        ArrayList<Bestelling> bestellingen = (ArrayList<Bestelling>) getCurrentSession().createQuery("from bestelling").list();
        closeCurrentSession();
        return bestellingen;
    }
    @Override
    public ArrayList<Bestelling> findByKlantId(int klantId){
        openCurrentSessionWithTransaction();
        Query query = getCurrentSession().createQuery("from Bestelling where id = :klantId");
        query.setParameter("klantId", klantId);
        ArrayList<Bestelling> bestellingen = (ArrayList<Bestelling>) query.list();
        closeCurrentSessionWithTransaction();
        return bestellingen;
    }
    
    @Override
    public void update(Bestelling bestelling){
        openCurrentSessionWithTransaction();
        getCurrentSession().update(bestelling);
        closeCurrentSessionWithTransaction();
    }

    @Override
    public void delete(Bestelling bestelling) {
        openCurrentSessionWithTransaction();
        getCurrentSession().delete(bestelling);
        closeCurrentSessionWithTransaction();
    }
*/


    /*
    private Session currentSession;
    private Transaction currentTransaction;

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public Session openCurrentSession(){
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    
    public Session openCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    
    public void closeCurrentSession(){
        currentSession.close();
    }
    
    public void closeCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction.commit();
        currentSession.close();
    }

    public SessionFactory getSessionFactory(){
        StandardServiceRegistry ssrb = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        MetadataSources ms = new MetadataSources(ssrb);
        ms.addAnnotatedClass(Bestelling.class);
        ms.addAnnotatedClass(BestellingArtikel.class);
        ms.addAnnotatedClass(Artikel.class);
        ms.addAnnotatedClass(Klant.class);
        ms.addAnnotatedClass(Account.class);
        ms.addAnnotatedClass(Adres.class);
        SessionFactory sf = ms.buildMetadata().buildSessionFactory();
        return sf;
    }

    @Override
    public void save (Bestelling bestelling) {
        openCurrentSession();
        getCurrentSession().save(bestelling);
        closeCurrentSession();
    }
    
    @Override
    public Bestelling findById(int BestellingId){
        openCurrentSession();
        Bestelling bestelling = (Bestelling) getCurrentSession().get(Bestelling.class, BestellingId);
        closeCurrentSession();
        return bestelling;
    }

    @Override
    public ArrayList<Bestelling> findAll(){
        openCurrentSession();
        ArrayList<Bestelling> bestellingen = (ArrayList<Bestelling>) getCurrentSession().createQuery("from bestelling").list();
        closeCurrentSession();
        return bestellingen;
    }
    @Override
    public ArrayList<Bestelling> findByKlantId(int klantId){
        openCurrentSessionWithTransaction();
        Query query = getCurrentSession().createQuery("from Bestelling where id = :klantId");
        query.setParameter("klantId", klantId);
        ArrayList<Bestelling> bestellingen = (ArrayList<Bestelling>) query.list();
        closeCurrentSessionWithTransaction();
        return bestellingen;
    }
    
    @Override
    public void update(Bestelling bestelling){
        openCurrentSessionWithTransaction();
        getCurrentSession().update(bestelling);
        closeCurrentSessionWithTransaction();
    }

    @Override
    public void delete(Bestelling bestelling) {
        openCurrentSessionWithTransaction();
        getCurrentSession().delete(bestelling);
        closeCurrentSessionWithTransaction();
    }
*/
}
