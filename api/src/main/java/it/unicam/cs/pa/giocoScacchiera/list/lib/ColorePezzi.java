package it.unicam.cs.pa.giocoScacchiera.list.lib;

public enum ColorePezzi {
    BIANCO,
    NERO;

    public boolean isWhite(){
        if(this == BIANCO) return true;
        else return false;
    }

    public boolean isBlack(){
        if(this == NERO) return true;
        else return false;
    }
}
