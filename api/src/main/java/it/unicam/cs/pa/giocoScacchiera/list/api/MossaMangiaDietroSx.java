package it.unicam.cs.pa.giocoScacchiera.list.api;

import it.unicam.cs.pa.giocoScacchiera.list.lib.*;
public class MossaMangiaDietroSx extends MossaDama {

    public MossaMangiaDietroSx() {
        this.tipo = TypeMosse.MossaMangiaDietroSx;
    }

    @Override
    public Posizione mossa(Posizione p) {

        if(p == null) throw new NullPointerException();
        return new PosizionePezzo(p.x()-2,p.y()+2);

    }
}
