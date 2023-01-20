package it.unicam.cs.pa.giocoScacchiera.list.api;

import it.unicam.cs.pa.giocoScacchiera.list.api.ColorePezzi;
import it.unicam.cs.pa.giocoScacchiera.list.api.NomePezzi;
import it.unicam.cs.pa.giocoScacchiera.list.api.Pedina;
import it.unicam.cs.pa.giocoScacchiera.list.lib.Pezzo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test della pedina
 */
class PedinaTest {

    /**
     * Test sui 3 campi
     */
    @Test
    void testPedina() {
        Pezzo p = new Pedina(NomePezzi.PEDINA, ColorePezzi.NERO,1);
        assertEquals(p.getNomePezzo(),NomePezzi.PEDINA);
        assertEquals(p.getColore(),ColorePezzi.NERO);
        assertEquals(p.getN(),1);
    }

}