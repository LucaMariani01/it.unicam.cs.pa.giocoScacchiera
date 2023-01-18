package it.unicam.cs.pa.giocoScacchiera.list.api;
import java.util.Objects;
import it.unicam.cs.pa.giocoScacchiera.list.lib.*;

public class Pedina implements Pezzo {

    final private NomePezzi nomePezzo;
    final private ColorePezzi colore;
    final private int numPezzo;

    public Pedina(NomePezzi nome, ColorePezzi colore, int numPezzo)
    {
        this.nomePezzo = nome;
        this.colore = colore;
        this.numPezzo = numPezzo;
    }

    public NomePezzi getNomePezzo(){
        return this.nomePezzo;
    }

    public int getN()
    {
        return this.numPezzo;
    }

    public ColorePezzi getColore()
    {
        return this.colore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedina pedina = (Pedina) o;
        return numPezzo == pedina.numPezzo && nomePezzo == pedina.nomePezzo && colore == pedina.colore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomePezzo, colore, numPezzo);
    }

    @Override
    public String toString() {
        String r = "";
        if (this.nomePezzo== NomePezzi.PEDINA) r=  r+"P";
        else  r = r + "D";
        if (this.colore== ColorePezzi.BIANCO) r=  r+"B";
        else  r = r + "N";

        return r;
    }
}
