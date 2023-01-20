package it.unicam.cs.pa.giocoScacchiera.list.lib;

/**
 * Interfaccia che gestisce le posizioni all'interno della scacchiera
 */
public interface Posizione {
    /**
     * Restituisce la posizione sull'asse delle X della scacchiera
     * @return X
     */
    public int x();

    /**
     * Restituisce la posizione sull'asse delle Y della scacchiera
     * @return Y
     */
    public int y();
}
