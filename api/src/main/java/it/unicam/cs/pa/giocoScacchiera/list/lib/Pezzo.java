package it.unicam.cs.pa.giocoScacchiera.list.lib;
import it.unicam.cs.pa.giocoScacchiera.list.api.NomePezzi;

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
     * return il nome del pezzo
     */
    public NomePezzi getNomePezzo();


}
