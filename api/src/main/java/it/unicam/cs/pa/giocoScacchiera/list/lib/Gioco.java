package it.unicam.cs.pa.giocoScacchiera.list.lib;


/**
 * Interfaccia che definisce il gioco
 * e fa comunicare il giocatore con la scacchiera
 * e segue le direttive del regolamento
 */
public interface Gioco {

    /**
     * Loop del gioco
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

