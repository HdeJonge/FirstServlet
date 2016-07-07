/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Hibernate;

import POJO.Account;
import POJO.Klant;
import POJO.Adres;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Gebruiker
 */
public class AccountDAOHibernate {
    
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
        ms.addAnnotatedClass(Klant.class);
        ms.addAnnotatedClass(Adres.class);
        ms.addAnnotatedClass(Account.class);
        SessionFactory sf = ms.buildMetadata().buildSessionFactory();
        return sf;
    }

    public Account save (Account account) {
        getCurrentSession().save(account);
        return account;
    }
    
    public Account findById(int account_id){
        Account account = (Account) getCurrentSession().get(Account.class, account_id);
        return account;
    }

    public ArrayList<Account> findAll(){
        ArrayList<Account> accounten = (ArrayList<Account>) getCurrentSession().createQuery("from Account").list();
        return accounten;
    }
    
    public void update(Account account){
        getCurrentSession().update(account);
    }
    
    public void delete(Account account){
        getCurrentSession().delete(account);
    }
}
