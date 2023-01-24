package it.unicam.cs.pa.giocoScacchiera.list.lib;

import it.unicam.cs.pa.giocoScacchiera.list.api.ColorePezzi;

/**
 * Interfaccia che definisce quello che il giocatore deve fare
 */
public interface Giocatore {

    /**
     *Restituisce il numero di partite giocate dal giocatore
     * @return int
     */
    public int partiteGiocate();

    /**
     * Restituisce il numero di vittorie del giocatore
     * @return int
     */
    public int vittorieGiocatore();

    /**
     * Aggiorna il punteggio del giocatore
     * @param n intero da incrementare
     */
    public void aggiungiVittoria(int n);

    /**
     * Aggiunge una partita al giocatore
     */
    public void aggiungiPartita();

    /**
     * Aggiorna il punteggio del giocatore in caso di sconfitta
     * @param n valore da decrementare
     */
    public void aggiungiSconfitta(int n);

    /**
     * Restituisce il colore assegnato al giocatore
     * @return colore dei pezzi che sta utilizzando il giocatore
     */
    public ColorePezzi getColore();

    /**
     * Restituisce il nome
     * @return nome del giocatore
     */
    public String getNome();



}
