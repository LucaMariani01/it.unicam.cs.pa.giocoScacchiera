package it.unicam.cs.pa.giocoScacchiera.list.lib;
import it.unicam.cs.pa.giocoScacchiera.list.lib.*;
public enum TypeMosse {

    MossaAvantiDx,
    MossaAvantiSx,
    MossaDietroDx,
    MossaDietroSx,
    MossaMangiaAvantiDx,
    MossaMangiaAvantiSx,
    MossaMangiaDietroDx,
    MossaMangiaDietroSx,
    MossaPatta,
    MossaResa;

    /**
     * Metodo che mi controlla che se la mossa andrà a mangiare un pezzo di un altro giocatore
     * @return true se è una mossa che mangia un pezzo di un altro giocatore
     */
    public boolean isMossaMangia()
    {
        return this == MossaMangiaAvantiDx || this == MossaMangiaAvantiSx
                || this == MossaMangiaDietroSx || this == MossaMangiaDietroDx;
    }


}
