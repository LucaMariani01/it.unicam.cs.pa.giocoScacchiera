package it.unicam.cs.pa.giocoScacchiera.list;

import it.unicam.cs.pa.giocoScacchiera.list.api.PosizionePezzo;
import it.unicam.cs.pa.giocoScacchiera.list.lib.Posizione;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPezzo {
    @Test
    public void testGetPosizione(){
        Posizione p = new PosizionePezzo(1,7);

        assertTrue(p.x() == 1);
        assertTrue(p.y() == 7);
    }



    @Test
    public void testFetNomePezzo(){
        // TODO: 25/11/2022
    }
    @Test
    public void  testMosseDisponibili()
    {
        // TODO: 25/11/2022
    }
}
