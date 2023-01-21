package it.unicam.cs.pa.giocoScacchiera.list.api;

/**
 * colore dei pezzi nella scacchiera
 */
public enum ColorePezzi {
    /**
     * COLORE: BIANCO
     */
    BIANCO,
    /**
     * COLORE: NERO
     */
    NERO;

    /**
     * Controlla se il colore sia bianco
     * @return true se il colore è bianco
     */
    public boolean isWhite(){
        if(this == BIANCO) return true;
        else return false;
    }

    /**
     * Controlla che un colore si nero
     * @return true se è nero
     */
    public boolean isBlack(){
        if(this == NERO) return true;
        else return false;
    }
}
