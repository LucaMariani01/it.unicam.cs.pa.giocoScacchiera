package it.unicam.cs.pa.giocoScacchiera.list.api;

import it.unicam.cs.pa.giocoScacchiera.list.lib.*;

/**
 * Classe che calcola la posizione avanti a destra
 */
public class MossaAvantiDx extends MossaDama{

    /**
     * Costruttore
     */
    public MossaAvantiDx(){
        this.tipo = TypeMosse.MossaAvantiDx;
    }

    @Override
    public Posizione mossa(Posizione p) {

        if(p == null) throw new NullPointerException();

        return new PosizionePezzo(p.x()+1,p.y()-1);

    }
}
