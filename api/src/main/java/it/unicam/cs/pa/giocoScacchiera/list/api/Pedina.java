package it.unicam.cs.pa.giocoScacchiera.list.api;
import java.util.Objects;
import it.unicam.cs.pa.giocoScacchiera.list.lib.*;

/**
 * Classe che definisce una pedina di dama
 */
public class Pedina implements Pezzo {
    /**
     * Nome del pezzo
     */
    final private NomePezzi nomePezzo;
    /**
     * Colore del pezzo
     */
    final private ColorePezzi colore;
    /**
     * Numero identificativo
     */
    final private int numPezzo;

    /**
     * Costruttore
     * @throws NullPointerException se uno dei valori passati è null
     * @param nome nome passato
     * @param colore colore
     * @param numPezzo numero
     */
    public Pedina(NomePezzi nome, ColorePezzi colore, int numPezzo)
    {
        if (nome == null || colore == null) throw new NullPointerException();
        this.nomePezzo = nome;
        this.colore = colore;
        this.numPezzo = numPezzo;
    }

    @Override
    public NomePezzi getNomePezzo(){
        return this.nomePezzo;
    }

    @Override
    public int getN()
    {
        return this.numPezzo;
    }
    @Override
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
