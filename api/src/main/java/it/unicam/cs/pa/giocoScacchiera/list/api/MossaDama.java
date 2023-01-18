package it.unicam.cs.pa.giocoScacchiera.list.api;

import java.util.Objects;
import it.unicam.cs.pa.giocoScacchiera.list.lib.*;
public  abstract class MossaDama implements Mosse {

    protected TypeMosse tipo;

    public abstract Posizione mossa(Posizione p);

    public  TypeMosse getType()
    {
        return this.tipo;
    }

    @Override
    public String toString() {
        return ""+tipo+" ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MossaDama mossaDama = (MossaDama) o;
        return tipo == mossaDama.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }
}
