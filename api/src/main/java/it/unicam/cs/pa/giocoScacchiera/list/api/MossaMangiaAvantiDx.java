package it.unicam.cs.pa.giocoScacchiera.list.api;

import it.unicam.cs.pa.giocoScacchiera.list.lib.*;
public class MossaMangiaAvantiDx extends MossaDama {

    public MossaMangiaAvantiDx() {
        this.tipo = TypeMosse.MossaMangiaAvantiDx;
    }

    @Override
    public Posizione mossa(Posizione p) {

        if(p == null) throw new NullPointerException();

        return new PosizionePezzo(p.x()+2,p.y()-2);

    }
}
