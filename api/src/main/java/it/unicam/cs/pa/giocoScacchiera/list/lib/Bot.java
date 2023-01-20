package it.unicam.cs.pa.giocoScacchiera.list.lib;

import it.unicam.cs.pa.giocoScacchiera.list.api.ColorePezzi;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *Definisce il contratto che un bot
 *deve avere per giocare a scacchi
 */
public interface Bot {

    /**
     * Metodo che permette al bot di effettuare una mossa
     * @param c colore bot
     * @param s stato scacchiera
     * @param mappaMosse mosse
     * @return pezzo e mossa scelta
     */
    public Pair<Pezzo,Mosse> faiMossa(ColorePezzi c, Scacchiera s, HashMap<Pezzo, ArrayList<Mosse>> mappaMosse);

    /**
     *Metodo che ti permette di scegliere una mossa per il pezzo passato
     * @param mosse mosse disponibili
     * @param p Pezzo
     * @return mossa scelta
     */
    public Mosse muoviSingoloPezzo(HashMap<Pezzo, ArrayList<Mosse>> mosse, Pezzo p);
}
