package it.unicam.cs.pa.giocoScacchiera.list.api;
import it.unicam.cs.pa.giocoScacchiera.list.lib.ColorePezzi;
import it.unicam.cs.pa.giocoScacchiera.list.lib.Giocatore;

public class GiocatoreDama implements Giocatore {

    final private String nome;
    final private ColorePezzi colore;

    private int numeroVittorie;

    private int partiteGiocate;
    public GiocatoreDama(String nome, ColorePezzi colore) {
        if (colore == null || nome == null) throw new NullPointerException();

        this.nome = nome;
        this.colore = colore;
        this.numeroVittorie = 0;
        this.partiteGiocate = 0;

    }

    @Override
    public int partiteGiocate() {
        return this.partiteGiocate;
    }

    @Override
    public int vittorieGiocatore() {
        return this.numeroVittorie;
    }

    @Override
    public void aggiungiVittoria() {
        this.aggiungiPartita();
        this.numeroVittorie++;
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
