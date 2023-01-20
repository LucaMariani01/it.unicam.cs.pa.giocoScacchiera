package it.unicam.cs.pa.giocoScacchiera.app;

import it.unicam.cs.pa.giocoScacchiera.list.api.GiocatoreDama;
import it.unicam.cs.pa.giocoScacchiera.list.api.GiocoDama;
import it.unicam.cs.pa.giocoScacchiera.list.lib.ColorePezzi;
import it.unicam.cs.pa.giocoScacchiera.list.lib.Gioco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Scanner;

public class menuController {
    public void giocoDama(javafx.event.ActionEvent actionEvent) {
        Scanner s = new Scanner(System.in);

        System.out.println("INSERIRE IL NOME DEL GIOCATORE CHE VUOLE UTILIZZARE I BIANCHI  : \n" +
                "SCRIVERE [BOT] se si vuole assegnare i bianchi al bot");
        String nomeGiocatoreBianco = s.next();

        System.out.println("INSERIRE IL NOME DEL GIOCATORE CHE VUOLE UTILIZZARE I NERI  : \n" +
                "SCRIVERE [BOT] se si assegnare i bianchi al bot");
        String nomeGiocatoreNERO = s.next();

        Gioco g = new GiocoDama(new GiocatoreDama(nomeGiocatoreBianco, ColorePezzi.BIANCO),new GiocatoreDama(nomeGiocatoreNERO,ColorePezzi.NERO));

        try {
            g.gameLoop();
        }catch (Exception ignored){}

    }

    public void giocoScacchi(javafx.event.ActionEvent actionEvent) {
        System.out.println("Scacchi sarà inserito al prossimo aggiornamento");
    }
}
