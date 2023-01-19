package it.unicam.cs.pa.giocoScacchiera.list.lib;


import it.unicam.cs.pa.giocoScacchiera.list.api.TypeMosse;

public  interface  Mosse {

    /**
     * Data la posizione iniziale, calcola  la nuova posizione nell scacchiera
     * @param p posizione corrente
     * @return la nuova posizione
     */
    public Posizione mossa(Posizione p);

    /***
     * @return il tipo della mossa
     */
    public TypeMosse getType();

}
