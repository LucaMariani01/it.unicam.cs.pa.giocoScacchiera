package it.unicam.cs.pa.giocoScacchiera.list.api;

import it.unicam.cs.pa.giocoScacchiera.list.lib.Gioco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test di una partita
 */
class GiocoDamaTest {
    /**
     * Test del ame loop
     */
    @Test
    public void testGameLoop()
    {
        Gioco g = new GiocoDama(new GiocatoreDama("LUCA",ColorePezzi.BIANCO),new GiocatoreDama("MATTEO",ColorePezzi.NERO));
        g.gameLoop();
        assertTrue(true);
    }

}