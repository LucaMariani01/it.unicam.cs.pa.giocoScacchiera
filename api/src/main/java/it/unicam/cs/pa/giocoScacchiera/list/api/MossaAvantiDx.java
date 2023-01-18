package it.unicam.cs.pa.giocoScacchiera.list.api;

import it.unicam.cs.pa.giocoScacchiera.list.lib.*;
public class MossaAvantiDx extends MossaDama{

    public MossaAvantiDx(){
        this.tipo = TypeMosse.MossaAvantiDx;
    }

    @Override
    public Posizione mossa(Posizione p) {

        if(p == null) throw new NullPointerException();

        return new PosizionePezzo(p.x()+1,p.y()-1);

    }
}
