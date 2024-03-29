package it.unicam.cs.pa.giocoScacchiera.list.api;
import it.unicam.cs.pa.giocoScacchiera.list.lib.*;

/**
 * Record che mi definisce la posizione nella scacchiera
 * @param x valore asse x
 * @param y valore asse y
 */
public record PosizionePezzo(int x, int y) implements Posizione {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PosizionePezzo that = (PosizionePezzo) o;
        return x == that.x && y == that.y;
    }

    @Override
    public String toString() {
        int app = 65+this.x;
        char xs = (char) app;
        int ys = y+1;
        return "[x=" + xs + ", " + "y=" + ys + "] ";
    }


}
