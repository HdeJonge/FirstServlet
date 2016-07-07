/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Hibernate;

import POJO.Artikel;
import interfaceDAO.IArtikelDAO;
import org.springframework.stereotype.Component;

/**
 *
 * @author Peter
 */
@Component
public class ArtikelDAOHibernate extends GenericDAO<Artikel, Integer> implements IArtikelDAO {
    
    public ArtikelDAOHibernate() {
        super(Artikel.class);
    }

    /**
     * Dit kan er uit
     * 
    @Override
    public Artikel save(Artikel artikel) {
        getCurrentSession().save(artikel);
        return artikel;
    }

    @Override
    public Artikel findById(int artikelId) {
        Artikel artikel = (Artikel) getCurrentSession().get(Artikel.class, artikelId);
        return artikel;
    }

    @Override
    public ArrayList<Artikel> findAll() {
       ArrayList<Artikel> artikelLijst = (ArrayList<Artikel>) getCurrentSession().createQuery("from artikel").list();
        return artikelLijst;
    }

    @Override
    public void delete(Artikel artikel) {
        getCurrentSession().delete(artikel);
    }

    @Override
    public void update(Artikel artikel) {
       getCurrentSession().update(artikel);
    }
    */
}
