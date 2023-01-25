package it.unicam.cs.pa.giocoScacchiera.list.api;


import it.unicam.cs.pa.giocoScacchiera.list.lib.*;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe che ti permette di avviare una partita di dama
 */
public class GiocoDama implements Gioco {
    /**
     * Giocatore a cui sono assegnati i bianchi
     */
    private final Giocatore giocatoreB;
    /**
     * Giocatore a cui sono assegnati i neri
     */
    private final Giocatore giocatoreN;
    /**
     * Regolamento partita
     */
    private final Regolamento regolamento;
    /**
     * Scacchiera dove si svolge la partita
     */
    private Scacchiera scacchiera;

    /**
     * Costruttore gioco
     * @param giocatoreB giocatore che userà le pedine bianche
     * @param giocatoreN giocatore che userà le pedine nere
     */
    public GiocoDama(Giocatore giocatoreB, Giocatore giocatoreN) {

        if (giocatoreB == null || giocatoreN == null ) throw  new NullPointerException();

        this.giocatoreB = giocatoreB;
        this.giocatoreN = giocatoreN;
        this.scacchiera = new ScacchieraScacchi() ;
        this.regolamento = new RegoleDama();
    }

    @Override
    public void gameLoop() {
        Bot bot = new MyBot();
        DashBoardUtente itr = new DashBoardUtenteDama();
        this.scacchiera = this.regolamento.statoIniziale(this.scacchiera);
        Giocatore turno = this.giocatoreB;

        while (this.regolamento.casiVittoria(this.scacchiera,this)==null)
        {
            itr.stampaScacchiera(this.scacchiera);
            HashMap<Pezzo, ArrayList<Mosse>> mosseGiocatori = this.regolamento.calcoloMossePezzi(this.scacchiera);

            Pair<Pezzo,Mosse> p;
            if (!turno.getNome().equals("BOT")) p = itr.scegliMossa(turno,this.scacchiera,mosseGiocatori);
            else p = bot.faiMossa(turno.getColore(),this.scacchiera,mosseGiocatori);

            this.scacchiera = this.regolamento.gestisciMosseGiocatore(this.scacchiera,p,turno,this);
            if (p.getValue().getType()==TypeMosse.MossaResa) return;

            this.mangiataMultipla(turno,p);
            if(this.regolamento.pedinaCanBecomeDama(p.getKey(),this.scacchiera.cercaPezzo(p.getKey())))this.scacchiera.trasformaPezzo(p.getKey(),new Pedina(NomePezzi.DAMA,p.getKey().getColore(),p.getKey().getN()) );
            if (turno.getColore().isBlack()) turno =this.giocatoreB;
            else turno =this.giocatoreN;
        }

        if(itr.finePartita(this.regolamento.casiVittoria(this.scacchiera,this))==1){
            this.scacchiera = new ScacchieraScacchi();
            this.gameLoop();
        }
    }
    /**
     * Si aziona nel momento in cui un pezzo deve mangiare più volte nello stesso turno
     * @param turno il giocatore che sta muovendo in questo momento
     * @param p coppia di valore che indica il pezzo da muovere e la mossa da fare
     */
    private void mangiataMultipla(Giocatore turno,Pair<Pezzo,Mosse> p){
        DashBoardUtente itr = new DashBoardUtenteDama();
        Bot bot = new MyBot();
        while (this.regolamento.gestioneTurno(turno,p,this.scacchiera) == turno.getColore()){

            HashMap<Pezzo, ArrayList<Mosse>> mosseGiocatori = this.regolamento.calcoloMossePezzi(this.scacchiera);
            if (turno.getNome().equals("BOT")) p = new Pair<>(p.getKey(),bot.muoviSingoloPezzo(mosseGiocatori, p.getKey()));
            else p = new Pair<>(p.getKey(),itr.scegliMossaSingoloPezzo(mosseGiocatori, p.getKey()));

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
