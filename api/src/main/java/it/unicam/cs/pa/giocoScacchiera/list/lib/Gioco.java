package it.unicam.cs.pa.giocoScacchiera.list.lib;


/**
 * interfaccia che definisce il loopGAME
 * e fa comunicare il giocatore con la scacchiera
 * e segue le direttive del regolamento
 */
public interface Gioco {

    /**
     * Ricalcola tutte le mosse disponibili dei due giocatori
     */
    public void controlloStatoPartita();

    /**
     * loop del gioco
     */
    public void gameLoop();

    /**
     * @return giocatore che sta utilizzando i neri
     */
    public Giocatore getGiocatoreN();

    /**
     * @return giocatore che sta utilizzando i bianchi
     */
    public Giocatore getGiocatoreB();

}

