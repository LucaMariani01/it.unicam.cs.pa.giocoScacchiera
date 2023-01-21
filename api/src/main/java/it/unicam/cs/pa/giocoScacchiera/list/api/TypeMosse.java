package it.unicam.cs.pa.giocoScacchiera.list.api;

/**
 *Enumerazione del tipo di mosse che si possono
 * effettuare a dama
 */
public enum TypeMosse {
    /**
     *TIPO: MOSSA AVANTI DX
     */
    MossaAvantiDx,
    /**
     *TIPO: MOSSA AVANTI SX
     */
    MossaAvantiSx,
    /**
     *TIPO: MOSSA DIETRO DX
     */
    MossaDietroDx,
    /**
     *TIPO: MOSSA DIETRO SX
     */
    MossaDietroSx,
    /**
     *TIPO: MOSSA MANGIA AVANTI DX
     */
    MossaMangiaAvantiDx,
    /**
     *TIPO: MOSSA MANGIA AVANTI SX
     */
    MossaMangiaAvantiSx,
    /**
     *TIPO: MOSSA MANGIA DIETRO DX
     */
    MossaMangiaDietroDx,
    /**
     *TIPO: MOSSA MANGIA DIETRO SX
     */
    MossaMangiaDietroSx,
    /**
     *TIPO: RESA
     */
    MossaResa;

    /**
     *Metodo che mi controlla che se la mossa andrà a mangiare un pezzo di un altro giocatore
     *@return true se è una mossa che mangia un pezzo di un altro giocatore
     */
    public boolean isMossaMangia()
    {
        return this == MossaMangiaAvantiDx || this == MossaMangiaAvantiSx
                || this == MossaMangiaDietroSx || this == MossaMangiaDietroDx;
    }


}
