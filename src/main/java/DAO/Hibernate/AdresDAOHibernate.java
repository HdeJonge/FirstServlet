package DAO.Hibernate;

import POJO.Adres;
/*import POJO.Artikel;
import POJO.Bestelling;
import POJO.BestellingArtikel;
import POJO.Klant;
import interfaceDAO.*;
import java.util.ArrayList;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;*/

/**
 *
 * @author Sonja
 */

public class AdresDAOHibernate extends GenericDAO<Adres,Integer> {
    public AdresDAOHibernate() {
        super(Adres.class);
    }
    
    /*private Session currentSession;
    private Transaction currentTransaction;
    
    public Session openCurrentSession(){
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    
    public void closeCurrentSession(){
        currentSession.close();
    }
    
    public Session openCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    
    public void closeCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction.commit();
        currentSession.close();
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
    
    public SessionFactory getSessionFactory() { 
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        MetadataSources mS = new MetadataSources(ssr);
        mS.addAnnotatedClass(Adres.class);
        mS.addAnnotatedClass(Bestelling.class);
        mS.addAnnotatedClass(BestellingArtikel.class);
        mS.addAnnotatedClass(Artikel.class);
        mS.addAnnotatedClass(Klant.class);
        SessionFactory sessionFactory = mS.buildMetadata().buildSessionFactory();
        return sessionFactory;
    }
   
    @Override
    public Adres save(Adres adres) {
        openCurrentSession();
        getCurrentSession().save(adres);
        closeCurrentSession();
        return adres;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<Adres> findAll() {
        openCurrentSessionWithTransaction();
        ArrayList<Adres> adresGegevens = (ArrayList<Adres>)getCurrentSession()
                .createQuery("from Adres").list();
        closeCurrentSessionWithTransaction();
        return adresGegevens;
    }

    @Override
    public Adres findById(int adresId) {
        openCurrentSessionWithTransaction();
        Adres adres = (Adres)getCurrentSession().get(Adres.class, adresId);
        closeCurrentSessionWithTransaction();
        return adres;
    }

    @Override
    public void update(Adres adres) {
        openCurrentSessionWithTransaction();
        getCurrentSession().update(adres); 
        closeCurrentSessionWithTransaction();
    }

    @Override
    public void delete(Adres adres) {
        openCurrentSessionWithTransaction();
        getCurrentSession().delete(adres); 
        closeCurrentSessionWithTransaction();
    }

    @Override
    public void delete(int adresId) {
        openCurrentSessionWithTransaction();
        Adres adres = (Adres)getCurrentSession().get(Adres.class, adresId);
        getCurrentSession().delete(adres); 
        closeCurrentSessionWithTransaction();
    }*/
}
