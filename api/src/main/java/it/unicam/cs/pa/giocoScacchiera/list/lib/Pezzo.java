package it.unicam.cs.pa.giocoScacchiera.list.lib;
import it.unicam.cs.pa.giocoScacchiera.list.api.ColorePezzi;
import it.unicam.cs.pa.giocoScacchiera.list.api.NomePezzi;

/**
 * definisce quello che ogni pezzo nella scacchiera deve fare
 */
public interface Pezzo {

    /**
     * un pezzo puo avere piu molteplicità nella scacchiera il numero serve
     * per rendere diversi due pezzi uguali
     * @return n
     */
    public int getN();

    /**
     * ritorna il colore del pezzo
     * @return colore
     */
    public ColorePezzi getColore();

    /**
     * Restituisce il nome del pezzo
     * @return NomePezzi
     */
    public NomePezzi getNomePezzo();


}
