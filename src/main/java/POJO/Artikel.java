/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artikel")

public class Artikel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artikel_id")
    private int artikelId;
    @Column(name = "artikel_naam")
    private String artikelNaam;
    @Column(name = "artikel_voorraad")
    private int artikelVoorraad;
    @Column(name = "artikel_prijs")
    private BigDecimal artikelPrijs;
    
   public Artikel(){
    }
   
    public void setArtikelID(int artikelId){
        this.artikelId = artikelId;
    }
   
    /**
     * @return the artikel_ID
     */
    public int getArtikelId() {
        return artikelId;
    }

    /**
     * @return the artikel_naam
     */
    public String getArtikelNaam() {
        return artikelNaam;
    }

    /**
     * @param artikelNaam the artikel_naam to set
     */
    public void setArtikelNaam(String artikelNaam) {
        this.artikelNaam = artikelNaam;
    }

    /**
     * @return the artikel_voorraad
     */
    public int getArtikelVoorraad() {
        return artikelVoorraad;
    }

    /**
     * @param artikelVoorraad the artikel_voorraad to set
     */
    public void setArtikelVoorraad(int artikelVoorraad) {
        this.artikelVoorraad = artikelVoorraad;
    }

    /**
     * @return the artikel_prijs
     */
    public BigDecimal getArtikelPrijs() {
        return artikelPrijs;
    }

    /**
     * @param artikel_prijs the artikel_prijs to set
     */
    public void setArtikelPrijs(BigDecimal artikel_prijs) {
        this.artikelPrijs = artikelPrijs;
    }

}
