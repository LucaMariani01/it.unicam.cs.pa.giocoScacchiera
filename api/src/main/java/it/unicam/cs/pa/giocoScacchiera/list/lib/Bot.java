package it.unicam.cs.pa.giocoScacchiera.list.lib;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public interface Bot {

    /**
     * METODO CHE PERMETTE AL BOT DI FARE UNA MOSSA
     * @param c colore bot
     * @param s stato scacchiera
     * @param mappaMosse mosse
     * @return pezzo e mossa scelta
     */
    public Pair<Pezzo,Mosse> faiMossa(ColorePezzi c, Scacchiera s, HashMap<Pezzo, ArrayList<Mosse>> mappaMosse);

    /**
     *
     * @param mosse mosse disponibili
     * @param p Pezzo
     * @return mossa scelta
     */
    public Mosse muoviSingoloPezzo(HashMap<Pezzo, ArrayList<Mosse>> mosse, Pezzo p);
}
