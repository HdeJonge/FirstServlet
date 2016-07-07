/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package DAO.Hibernate;

import POJO.*;
import interfaceDAO.IGenericDAO;
import java.util.List;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.io.Serializable;
import org.springframework.stereotype.Component;

/**
 *
 * @author Peter
 */
public class GenericDAO<T, PK extends Serializable> implements IGenericDAO<T, PK> {
     private Session currentSession;
    private Transaction currentTransaction;
    private Class<T> type;
    
    //Contructor om het type te defineren.
    public GenericDAO(Class<T> type){
        this.type = type;
    }
    
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
        //currentSession = getSessionFactory().getCurrentSession();
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
        ms.addAnnotatedClass(Adres.class);
        ms.addAnnotatedClass(Account.class);
        SessionFactory sf = ms.buildMetadata().buildSessionFactory();
        return sf;
    }
    
     @Override
    public void save(T entity) {
        openCurrentSessionWithTransaction();
        getCurrentSession().save(entity);
        closeCurrentSessionWithTransaction();
    }

    
     @Override
    public T findById(PK id) {
        openCurrentSessionWithTransaction();
        T entity = (T)getCurrentSession().get(type, id);
        closeCurrentSession();
        return entity;
    }

    
     @Override
    public void delete(T entity) {
        openCurrentSessionWithTransaction();
        getCurrentSession().delete(entity);
        closeCurrentSessionWithTransaction();
    }
    
     @Override
    public void deleteById(PK id) {
        T entity = findById(id);
        openCurrentSessionWithTransaction();
        getCurrentSession().delete(entity);
        closeCurrentSessionWithTransaction();
    }
    
     @Override
    public List<T> findAll() {
        openCurrentSessionWithTransaction();
        List<T> entities = (List<T>) getCurrentSession().createCriteria(type).list();
        closeCurrentSession();
        return entities; 
    }
    
     @Override
    public void update(T entity) {
        openCurrentSessionWithTransaction();
        getCurrentSession().update(entity);
        closeCurrentSessionWithTransaction();
    }
    
    
}
    
