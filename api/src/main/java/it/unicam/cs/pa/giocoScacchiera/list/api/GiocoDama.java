package it.unicam.cs.pa.giocoScacchiera.list.api;


import it.unicam.cs.pa.giocoScacchiera.list.lib.*;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;


public class GiocoDama implements Gioco {

    private final Giocatore giocatoreB;
    private final Giocatore giocatoreN;
    private final Regolamento regolamento;
    private Scacchiera scacchiera;
    private HashMap<Pezzo, ArrayList<Mosse>> mosseGiocatori;


    public GiocoDama(Giocatore giocatoreB, Giocatore giocatoreN) {

        if (giocatoreB == null || giocatoreN == null ) throw  new NullPointerException();

        this.giocatoreB = giocatoreB;
        this.giocatoreN = giocatoreN;
        this.scacchiera = new ScacchieraScacchi() ;
        this.mosseGiocatori = new HashMap<>();
        this.regolamento = new RegoleDama();
    }

    @Override
    public void controlloStatoPartita() {
        this.mosseGiocatori = this.regolamento.calcoloMossePezzi(this.scacchiera);

    }

    @Override
    public void gameLoop() {
        Bot bot = new MyBot();
        IterazioneGiocatore itr = new IterazioneGiocatoreDama();
        this.scacchiera = this.regolamento.statoIniziale(this.scacchiera);
        Giocatore turno = this.giocatoreB;

        while (this.regolamento.casiVittoria(this.scacchiera,this)==null)
        {
            itr.stampaScacchiera(this.scacchiera);
            this.controlloStatoPartita();

            Pair<Pezzo,Mosse> p;
            if (!turno.getNome().equals("BOT")) p = itr.scegliMossa(turno,this.scacchiera,this.mosseGiocatori);
            else p = bot.faiMossa(turno.getColore(),this.scacchiera,this.mosseGiocatori);

            this.scacchiera = this.regolamento.gestisciMosseGiocatore(this.scacchiera,p,turno,this);
            if (p.getValue().getType()==TypeMosse.MossaResa) return;

            this.mangiataMultipla(turno,p);
            this.scacchiera.trasformaPezzo(p.getKey());
            if (turno.getColore().isBlack()) turno =this.giocatoreB;
            else turno =this.giocatoreN;

            }

        if(itr.finePartita(this.regolamento.casiVittoria(this.scacchiera,this))==1){
            this.scacchiera = new ScacchieraScacchi();
            this.gameLoop();
        }
    }
    /**
     * Si aziona nel momento in cui un pezzo può mangiare più volte nello stesso turno
     * @param turno il giocatore che sta muovendo in questo momento
     * @param p coppia di valore che indica il pezzo da muovere e la mossa da fare
     */
    private void mangiataMultipla(Giocatore turno,Pair<Pezzo,Mosse> p){
        IterazioneGiocatore itr = new IterazioneGiocatoreDama();
        Bot bot = new MyBot();
        while (this.regolamento.gestioneTurno(turno,p,this.scacchiera) == turno.getColore()){

            this.controlloStatoPartita();
            if (turno.getNome().equals("BOT")) p = new Pair<>(p.getKey(),bot.muoviSingoloPezzo(this.mosseGiocatori, p.getKey()));
            else p = new Pair<>(p.getKey(),itr.scegliMossaSingoloPezzo(this.mosseGiocatori, p.getKey()));

            if (!this.regolamento.giocatoreMangia(p,this.scacchiera)) p = new Pair<>(p.getKey(),null);
        }
    }

    @Override
    public Giocatore getGiocatoreN() {
        return this.giocatoreN;
    }

    @Override
    public Giocatore getGiocatoreB() {
        return this.giocatoreB;
    }
}
