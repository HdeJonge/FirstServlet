/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import POJO.*;
import formatMessage.PrintFormat;
import java.util.*;

/**
 *
 * @author Gebruiker
 */
public class BestellingView {
    int klantId;
    int aantal;
    int artikelId;
    int bestellingId;

    public int getKlantId() {
        return klantId;
    }

    public void setKlantId(int klantId) {
        this.klantId = klantId;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public int getArtikelId() {
        return artikelId;
    }

    public void setArtikelId(int artikelId) {
        this.artikelId = artikelId;
    }

    public int getBestellingId() {
        return bestellingId;
    }

    public void setBestellingId(int bestellingId) {
        this.bestellingId = bestellingId;
    }
    
    public void readKlantID(){
        Scanner input = new Scanner(System.in);
        System.out.print("Voer het klant ID in: ");    
        this.klantId = input.nextInt();
        System.out.print("Voer het artikel ID in: ");    
        this.artikelId = input.nextInt();
        System.out.print("Voer het aantal in: ");    
        this.aantal = input.nextInt();
    }
    public void addArtikel(){
        Scanner input = new Scanner(System.in);
        System.out.print("Voer het bestelling ID in: ");    
        this.klantId = input.nextInt();
        System.out.print("Voer het artikel ID in: ");    
        this.artikelId = input.nextInt();
        System.out.print("Voer het aantal in: ");    
        this.aantal = input.nextInt();
    }
    public void updateArtikel(){
        Scanner input = new Scanner(System.in);
        System.out.print("Voer het bestelling ID in: ");    
        this.klantId = input.nextInt();
        System.out.print("Voer het artikel ID in: ");    
        this.artikelId = input.nextInt();
        System.out.print("Voer het aantal in: ");    
        this.aantal = input.nextInt();
    }
    
    public void readBestellingID(){
        Scanner input = new Scanner(System.in);
        System.out.print("Voer het bestelling ID in: ");
        this.bestellingId = input.nextInt();
    }
    
    public void printBestellingen(ArrayList<Bestelling> list){
        PrintFormat.printHeader("BESTELLINGGEGEVENS");
        System.out.printf("%15s\t\t| %15s\t\t|\n", "Bestelling ID", "Klant ID");
        for(Bestelling e : list){
            System.out.printf("%15d\t\t| %15d\t\t|\n",e.getBestellingID(), e.getKlant().toString());
        }
    }
    public void printArtikelen(Set<BestellingArtikel> list){
        PrintFormat.printHeader("BESTELLINGARTIKEL GEGEVENS");
        System.out.printf("%15s\t\t| %15s\t\t|\n", "aantal", "artikel");
        for(BestellingArtikel e : list){
            System.out.printf("%15d\t\t| %15s\t\t|\n",e.getAantal(), e.getArtikel().getArtikelNaam());
        }
    }
    public void print(Bestelling bestelling){
        System.out.println("Bestelling ID: " + bestelling.getBestellingID());
        System.out.println("Klant ID: " + bestelling.getKlant().toString());
    }
    public void keuzeFout(){
        System.out.println(" voeg opnieuw in");
    }
}
