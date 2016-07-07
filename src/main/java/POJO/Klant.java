/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;


/**
 *
 * @author lucas
 */
@Entity
@Table(name = "klant")
public class Klant implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "klant_id")
    private int klantId;
    @Column(name = "voornaam")
    private String voornaam;
    @Column(name = "achternaam")
    private String achternaam;
    @Column(name = "tussenvoegsel")
    private String tussenvoegsel;
    @Column(name = "email")
    private String email;
    
    @ManyToMany//(cascade=CascadeType.ALL)
    @JoinTable(name="koppelklantadres",
      joinColumns=@JoinColumn(name="klant_id"),
      inverseJoinColumns=@JoinColumn(name="adres_id"))
    private Set<Adres> adresSet = new HashSet();
    
    /*
    @OneToMany(mappedBy = "klant", cascade=CascadeType.ALL)
    private Set<Account> accountSet = new HashSet();
    */
    
    @OneToMany(mappedBy="klant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Bestelling> bestellingSet = new HashSet();
    
    
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "factuur")
//    private Set<Factuur> factuurSet = new HashSet<Factuur>(0);
    
    
    
//    public String toString(){
//        return "" + getKlant_id() + ", " + getVoornaam() + ", " + getAchternaam() + ", "
//                + getTussenvoegsel() + ", " + getEmail();
//    }

    /**
     * @return the klant_id
     */
    public int getKlantId() {
        return klantId;
    }

    /**
     * @param klant_id the klant_id to set
     */
    public void setKlant_id(int klantId) {
        this.klantId = klantId;
    }

    /**
     * @return the voornaam
     */
    public String getVoornaam() {
        return voornaam;
    }

    /**
     * @param voornaam the voornaam to set
     */
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    /**
     * @return the achternaam
     */
    public String getAchternaam() {
        return achternaam;
    }

    /**
     * @param achternaam the achternaam to set
     */
    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    /**
     * @return the tussenvoegsel
     */
    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    /**
     * @param tussenvoegsel the tussenvoegsel to set
     */
    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the bestellingSet
     */
    public Set<Bestelling> getBestellingSet() {
        return bestellingSet;
    }

    /**
     * @param bestellingSet the bestellingSet to set
     */
    public void setBestellingSet(Set<Bestelling> bestellingSet) {
        this.bestellingSet = bestellingSet;
    }
    public void setBestellingSet(Bestelling bestelling) {
        this.bestellingSet.add(bestelling);
    }
//
//    /**
//     * @return the factuurSet
//     */
//    public Set<Factuur> getFactuurSet() {
//        return factuurSet;
//    }
//
//    /**
//     * @param factuurSet the factuurSet to set
//     */
//    public void setFactuurSet(Set<Factuur> factuurSet) {
//        this.factuurSet = factuurSet;
//    }
//    
//    public void setFactuurSet(Factuur factuur) {
//        this.factuurSet.add(factuur);
//    }
    

    
    /*
    public Set<Account> getAccountSet() {
        return accountSet;
    }


    public void setAccountSet(Set<Account> accountSet) {
        this.accountSet = accountSet;
    }
    
    public void setAccountSet(Account account) {
        this.accountSet.add(account);
    }

    */
    
    
    /**
     * @return the adresSet
     */
    public Set<Adres> getAdresSet() {
        return adresSet;
    }

    /**
     * @param adresSet the adresSet to set
     */
    public void setAdresSet(Set<Adres> adresSet) {
        this.adresSet = adresSet;
    }
    
    public void setAdresSet(Adres adres) {
        this.adresSet.add(adres);
    }
}
