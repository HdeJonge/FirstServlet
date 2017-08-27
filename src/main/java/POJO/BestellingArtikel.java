/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author Peter
 */

@Entity
@Table(name = "BestelRegel")
public class BestellingArtikel implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bestelRegel_id")
    private int bestellingArtikelID;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="artikel_id")
    private Artikel artikel;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="bestelling_id")
    private Bestelling bestelling;
    
    @Column(name="aantal")
    private int aantal;
    
    public int getID() {
        return bestellingArtikelID;
    }

    public void setID(int ID) {
        this.bestellingArtikelID = ID;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Bestelling getBestelling() {
        return bestelling;
    }

    public void setBestelling(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    
    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

}
