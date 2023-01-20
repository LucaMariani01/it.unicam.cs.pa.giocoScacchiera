package it.unicam.cs.pa.giocoScacchiera.list.api;

import it.unicam.cs.pa.giocoScacchiera.list.lib.*;

/**
 * Classe che calcola la posizione dietro a sinistra
 */
public class MossaDietroSx extends MossaDama {
    /**
     * Costruttore
     */
    public MossaDietroSx() {
        this.tipo = TypeMosse.MossaDietroSx;
    }
    @Override
    public Posizione mossa(Posizione p) {

        if(p == null) throw new NullPointerException();
        return new PosizionePezzo(p.x()-1,p.y()+1);

    }
}
