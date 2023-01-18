package it.unicam.cs.pa.giocoScacchiera.list;

import it.unicam.cs.pa.giocoScacchiera.list.api.*;
import it.unicam.cs.pa.giocoScacchiera.list.lib.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MossaTest {
    @Test
    void mossaAvantiTest() {
        Mosse m = new MossaAvantiDx();
        assertEquals(new PosizionePezzo(2,0),m.mossa(new PosizionePezzo(1,1)));

        m = new MossaAvantiSx();
        assertEquals(new PosizionePezzo(0,0),m.mossa(new PosizionePezzo(1,1)));
    }
    @Test
    void mossaDietroTest()
    {
        Mosse m = new MossaDietroDx();
        assertEquals(new PosizionePezzo(2,2),m.mossa(new PosizionePezzo(1,1)));

        m = new MossaDietroSx();
        assertEquals(new PosizionePezzo(0,2),m.mossa(new PosizionePezzo(1,1)));
    }

    @Test
    void mossaMangia()
    {
        Mosse m = new MossaMangiaDietroDx();
        assertEquals(new PosizionePezzo(4,4),m.mossa(new PosizionePezzo(2,2)));

        m = new MossaMangiaDietroSx();
        assertEquals(new PosizionePezzo(0,4),m.mossa(new PosizionePezzo(2,2)));

        m = new MossaMangiaAvantiDx();
        assertEquals(new PosizionePezzo(4,0),m.mossa(new PosizionePezzo(2,2)));

        m = new MossaMangiaAvantiSx();
        assertEquals(new PosizionePezzo(0,0),m.mossa(new PosizionePezzo(2,2)));
    }



}