package it.unicam.cs.pa.giocoScacchiera.list.lib;


public  interface  Mosse {

    /**
     * Data la posizione iniziale, calcola a seconda del pezzo
     * in quella posizione la nuova posizione nell scacchiera
     * @param p posizione corrente
     * @return la nuova posizione
     */
    public Posizione mossa(Posizione p);

    /***
     * @return il tipo della mossa
     */
    public TypeMosse getType();

}
