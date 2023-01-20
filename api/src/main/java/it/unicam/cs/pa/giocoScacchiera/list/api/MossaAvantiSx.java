package it.unicam.cs.pa.giocoScacchiera.list.api;

import it.unicam.cs.pa.giocoScacchiera.list.lib.*;
/**
 *  Classe che calcola la posizione avanti a sinistra
 */
public class MossaAvantiSx extends MossaDama{
    /**
     * Costruttore
     */
    public MossaAvantiSx(){
        this.tipo = TypeMosse.MossaAvantiSx;
    }
    @Override
    public Posizione mossa(Posizione p) {

        if(p == null) throw new NullPointerException();

        return new PosizionePezzo(p.x()-1,p.y()-1);

    }
}
