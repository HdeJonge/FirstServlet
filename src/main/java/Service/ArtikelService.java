/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import POJO.Artikel;
import java.util.ArrayList;
import interfaceDAO.IArtikelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Peter
 */
@Component
public class ArtikelService {
    private static IArtikelDAO DAO;
    
    @Autowired
    public ArtikelService(IArtikelDAO iArtikelDAO){
        DAO = iArtikelDAO;
    }
    
    public void save(Artikel artikel){
        DAO.save(artikel);
       }
    
    public void update(Artikel artikel){
        DAO.update(artikel);
    }
    
    public void delete(int artikelId){
        Artikel artikel = (Artikel)DAO.findById(artikelId);
        DAO.delete(artikel); 
    }
    
    public Artikel findById(int artikelId){
        Artikel artikel = (Artikel)DAO.findById(artikelId);
        return artikel;
    }
    
    public ArrayList<Artikel> findAll(){
        ArrayList<Artikel> artikelLijst = (ArrayList<Artikel>)DAO.findAll();
        return artikelLijst;
    }
    
}
