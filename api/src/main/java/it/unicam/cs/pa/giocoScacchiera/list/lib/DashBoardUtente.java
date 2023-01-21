package it.unicam.cs.pa.giocoScacchiera.list.lib;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * definisce come si deve gestire l'utente
 */
public interface DashBoardUtente {
    /**
     * Metodo che permette al giocatore di effettuare una mossa
     * @param g giocatore che muove
     * @param s stato scacchiera
     * @param m mosse disponibili
     * @return coppia Pezzo da muovere, Mossa scelta
     */
    public Pair<Pezzo,Mosse> scegliMossa(Giocatore g, Scacchiera s, HashMap<Pezzo, ArrayList<Mosse>> m);

    /**
     * Stampa le mosse disponibili di ogni giocatore
     * @param mosse insieme delle mosse
     * @param s stato scacchiera
     * @param g giocatore che deve scegliere
     * @return Array con l'indice di tutti i pezzi che si puo muovere del giocatore
     */
    public ArrayList<Integer> stampaMosseDisponibili(HashMap<Pezzo, ArrayList<Mosse>> mosse,Scacchiera s,Giocatore g);

    /**
     * Stampa la scacchiera
     * @param s stato scacchiera
     */
    public void stampaScacchiera(Scacchiera s);

    /**
     * Dato un pezzo ti fa scegliere le sue mosse disponibili
     * @param mosse Tutte le mosse
     * @param p pezzo che si vuole muove
     * @return Mossa scelta
     */
    public Mosse scegliMossaSingoloPezzo(HashMap<Pezzo, ArrayList<Mosse>> mosse, Pezzo p);

    /**
     * Termina la partita e chiede se la si vuole rigiocare
     * @param g giocatore vincete
     * @return la decisione
     */
    public int finePartita(Giocatore g);

}
