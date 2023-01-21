package it.unicam.cs.pa.giocoScacchiera.list.api;

import java.util.Objects;
import it.unicam.cs.pa.giocoScacchiera.list.lib.*;

/**
 * Classe astratta che implementa le parti di codice
 * in comune tra le varie mosse
 */
public  abstract class MossaDama implements Mosse {
    /**
     * Tipologia della mossa
     */
    protected TypeMosse tipo;
    @Override
    public abstract Posizione mossa(Posizione p);

    /**
     * Metodo che ti dice che mossa è
     * @return Type della Mossa
     */
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
