/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author lucas
 */
import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;
import java.util.Date;

@Entity
@Table(name = "account")
public class Account implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int account_id;
    
    @Column(name = "naam")
    private String naam;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "klant_id")
    private Klant klant;
    
    @Column(name = "creatieDatum")
    private java.util.Date creatieDatum;
    
    public Account(){
        this.creatieDatum = new Date();
    }
    
    public Account(Klant klant){
        this.klant = klant;
        this.creatieDatum = new Date();
    }
    
    /**
     * @return the id
     */
    public int getAccount_id() {
        return account_id;
    }

    /**
     * @param id the id to set
     */
    public void setAccount_id(int id) {
        this.account_id = id;
    }

    /**
     * @return the naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * @param naam the naam to set
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * @return the klant
     */
    public Klant getKlant() {
        return klant;
    }

    /**
     * @param klant the klant to set
     */
    public void setKlant(Klant klant) {
        this.klant = klant;
    }
    
    /**
     * @return the creatieDatum
     */
    public java.util.Date getCreatieDatum() {
        return creatieDatum;
    }

    /**
     * @param creatieDatum the creatieDatum to set
     */
    public void setCreatieDatum(java.util.Date creatieDatum) {
        this.creatieDatum = creatieDatum;
    }
    
    
}
