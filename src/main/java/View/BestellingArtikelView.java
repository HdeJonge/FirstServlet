/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import POJO.BestellingArtikel;
import formatMessage.PrintFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gebruiker
 */
public class BestellingArtikelView {
    int bestellingArtikelID;
    int bestellingID;
    int artikelID;
    int aantal;

    public int getBestellingArtikelID() {
        return bestellingArtikelID;
    }
    public int getBestellingID() {
        return bestellingID;
    }
    public int getArtikelID() {
        return artikelID;
    }

    public int getAantal() {
        return aantal;
    }

    public void readCreate(){
        Scanner input = new Scanner(System.in);
        System.out.print("Voer het artikel ID in: ");
        artikelID = input.nextInt();
        System.out.print("Voer het aantal artikelen in: ");
        aantal = input.nextInt();
    }
    
    public void readBestellingID(){
        Scanner input = new Scanner(System.in);
        System.out.print("Voer het bestelling ID in: ");
        this.bestellingID = input.nextInt();
    }
    
    public void readUpdate(){
        Scanner input = new Scanner(System.in);
        System.out.print("Voer het bestellingArtikel ID in: ");
        bestellingArtikelID = input.nextInt();
        System.out.print("Voer het aantal artikelen in: ");
        aantal = input.nextInt();
    }
    
    public void readDelete(){
        Scanner input = new Scanner(System.in);
        System.out.print("Voer het bestellingArtikel ID in: ");
        bestellingArtikelID = input.nextInt();
    }
    
        public void printArtikelLijst(ArrayList<BestellingArtikel> list){
        PrintFormat.printHeader("ARTIKELLIJST");
        System.out.printf("%15s\t\t| %15s\t\t|\n", "Artikel ID", 
                "Aantal");
        for(BestellingArtikel e : list){
             System.out.printf("%15s\t\t| %15d\t\t|\n",e.getArtikel().getArtikelNaam(), e.getAantal());  
        }
    }
    
}
