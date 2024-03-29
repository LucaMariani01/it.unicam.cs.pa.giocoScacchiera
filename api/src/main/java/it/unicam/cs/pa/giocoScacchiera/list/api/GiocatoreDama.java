package it.unicam.cs.pa.giocoScacchiera.list.api;
import it.unicam.cs.pa.giocoScacchiera.list.lib.Giocatore;

/**
 * Classe che definisce le caratteristiche di un giocatore di dama
 */
public class GiocatoreDama implements Giocatore {
    /**
     * Nome del giocatore
     */
    final private String nome;
    /**
     * Colore dei pezzi che il giocatore muove
     */
    final private ColorePezzi colore;
    /**
     * Punteggio giocatore
     */
    private int punteggioElo;
    /**
     * Numero partite giocate dal giocatore
     */
    private int partiteGiocate;

    /**
     * Costruttore
     * @param  nome Nome passato
     * @param colore Colore passato
     * throw {@link NullPointerException}
     */
    public GiocatoreDama(String nome, ColorePezzi colore) {
        if (colore == null || nome == null) throw new NullPointerException();

        this.nome = nome;
        this.colore = colore;
        this.punteggioElo = 0;
        this.partiteGiocate = 0;

    }

    @Override
    public int partiteGiocate() {
        return this.partiteGiocate;
    }

    @Override
    public int vittorieGiocatore() {
        return this.punteggioElo;
    }


    @Override
    public void aggiungiVittoria(int n) {
        this.aggiungiPartita();
        this.punteggioElo = this.punteggioElo + n;
    }

    @Override
    public void aggiungiSconfitta(int n) {
        this.aggiungiPartita();
        this.punteggioElo = this.punteggioElo - n;
    }

    @Override
    public void aggiungiPartita() {
        this.partiteGiocate++;
    }

    @Override
    public ColorePezzi getColore() {
        return this.colore;
    }

    @Override
    public String getNome() {
        return this.nome;
    }
}
