package it.unicam.cs.pa.giocoScacchiera.list.lib;

public interface Giocatore {

    /**
     * @return il numero di partite giocate dal giocatore
     */
    public int partiteGiocate();

    /**
     * @return il numero di vittorie del giocatore
     */
    public int vittorieGiocatore();

    /**
     * Aggiunge una vittoria al giocatore
     */
    public void aggiungiVittoria();

    /**
     * Aggiunge una partita al giocatore
     */
    public void aggiungiPartita();

    /**
     * @return colore dei pezzi che sta utilizzando il giocatore
     */
    public ColorePezzi getColore();

    /**
     * @return nome del giocatore
     */
    public String getNome();



}
