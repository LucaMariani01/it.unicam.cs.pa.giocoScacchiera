package it.unicam.cs.pa.giocoScacchiera.list.api;

import it.unicam.cs.pa.giocoScacchiera.list.lib.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test della scacchiera
 */
class ScacchieraScacchiTest {
    /**
     * Test sulla corretto posizionamento dei pezzi
     */
    @Test
    void listaPosizionePezziTest() {
        Scacchiera s = new ScacchieraScacchi();
        HashMap<Pezzo, Posizione> mappa = new HashMap<>();

        assertEquals(0, s.listaPezziMangiati().size());
        assertEquals(0,s.listaPosizionePezzi().size());

        s.aggiungiPezzo(new Pedina(NomePezzi.PEDINA, ColorePezzi.NERO,1),new PosizionePezzo(0,0));
        mappa.put(new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1),new PosizionePezzo(0,0));
        assertEquals(mappa,s.listaPosizionePezzi());

        s.aggiungiPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.BIANCO,2),new PosizionePezzo(1,1));
        mappa.put(new Pedina(NomePezzi.PEDINA,ColorePezzi.BIANCO,2),new PosizionePezzo(1,1));
        assertEquals(mappa,s.listaPosizionePezzi());
    }

    /**
     * Test se la lista dei pezzi mangiati calcolata correttamente
     */
    @Test
    void listaPezziMangiatiTest() {
        Scacchiera s = new ScacchieraScacchi();
        ArrayList<Pezzo> listaPezzi = new ArrayList<>();
        s.aggiungiPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1),new PosizionePezzo(0,0));
        s.aggiungiPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.BIANCO,2),new PosizionePezzo(1,1));
        s.mangiaPezzo(new PosizionePezzo(0,0));
        listaPezzi.add(new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1));
        assertEquals(listaPezzi,s.listaPezziMangiati());
        s.mangiaPezzo(new PosizionePezzo(1,1));
        listaPezzi.add(new Pedina(NomePezzi.PEDINA,ColorePezzi.BIANCO,2));
        assertEquals(listaPezzi,s.listaPezziMangiati());
    }

    /**
     * Test se il pezzo sia spostato correttamente
     */
    @Test
    void spostaPezzoTest() {
        Scacchiera s = new ScacchieraScacchi();
        ArrayList<Pezzo> listaPezzi = new ArrayList<>();
        s.aggiungiPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1),new PosizionePezzo(0,0));
        s.aggiungiPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.BIANCO,2),new PosizionePezzo(1,1));

        s.spostaPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1),new PosizionePezzo(3,3));

        assertEquals(s.cercaPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1)),new PosizionePezzo(3,3));

        s.spostaPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1),new PosizionePezzo(5,5));
        assertEquals(s.cercaPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1)),new PosizionePezzo(5,5));
    }

    /**
     * Test che controlla che il pezzo cercato sia restituito il risultato corretto
     */
    @Test
    void cercaPezzoTest() {
        Scacchiera s = new ScacchieraScacchi();
        s.aggiungiPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1),new PosizionePezzo(0,0));
        assertEquals(s.cercaPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1)),new PosizionePezzo(0,0));
        s.aggiungiPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1),new PosizionePezzo(1,1));
        assertEquals(s.cercaPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1)),new PosizionePezzo(1,1));
    }

    /**
     * Test che controlla che il metodo postoVuoto sia corretto
     */
    @Test
    void postoVuotoTest() {
        Scacchiera s = new ScacchieraScacchi();
        s.aggiungiPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1),new PosizionePezzo(0,0));
        assertTrue(s.postoVuoto(new PosizionePezzo(3,3)));
        assertFalse(s.postoVuoto(new PosizionePezzo(0,0)));
    }

    /**
     * Test che controlla che il metodo statoPosizione sia corretto
     */
    @Test
    void statoPosizioneTest() {
        Scacchiera s = new ScacchieraScacchi();
        s.aggiungiPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1),new PosizionePezzo(0,0));
       assertEquals(s.statoPosizione(new PosizionePezzo(0,0)).get(),new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1));
       assertTrue(s.statoPosizione(new PosizionePezzo(3,3)).isEmpty());

    }

    /**
     * Test che controlla che i pezzi vengano trasformati correttamente
     */
    @Test
    void trasformaPezzoTest() {
        Scacchiera s = new ScacchieraScacchi();
        s.aggiungiPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1),new PosizionePezzo(7,7));

        assertFalse(s.trasformaPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1), new Pedina(NomePezzi.DAMA,ColorePezzi.NERO,1) ));
        s.spostaPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1),new PosizionePezzo(0,0));
        assertTrue(s.trasformaPezzo(new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,1), new Pedina(NomePezzi.DAMA,ColorePezzi.NERO,1) ));
    }
}