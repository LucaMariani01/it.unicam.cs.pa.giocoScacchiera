package it.unicam.cs.pa.giocoScacchiera.list.api;

import it.unicam.cs.pa.giocoScacchiera.list.lib.*;
/**
 * Classe che calcola la posizione in caso la pedina mangi
 * dietro a destra
 */
public class MossaMangiaDietroDx extends MossaDama
{
    /**
     * Costruttore
     */
    public MossaMangiaDietroDx() {
        this.tipo = TypeMosse.MossaMangiaDietroDx;
    }

    @Override
    public Posizione mossa(Posizione p) {

        if(p == null) throw new NullPointerException();
        return new PosizionePezzo(p.x()+2,p.y()+2);

    }
}
