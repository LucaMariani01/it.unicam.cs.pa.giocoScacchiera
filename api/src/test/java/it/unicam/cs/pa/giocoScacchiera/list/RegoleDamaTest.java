package it.unicam.cs.pa.giocoScacchiera.list;

import it.unicam.cs.pa.giocoScacchiera.list.api.*;
import it.unicam.cs.pa.giocoScacchiera.list.lib.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RegoleDamaTest {

    @Test
    void casiVittoria() {
        Regolamento r = new RegoleDama();
        Scacchiera s = new ScacchieraScacchi();
        Giocatore g = new GiocatoreDama("LUCA", ColorePezzi.BIANCO);
        Giocatore g1 = new GiocatoreDama("MATTEO",ColorePezzi.NERO);
        Gioco d = new GiocoDama(g,g1);

        s    =  r.statoIniziale(s);
        assertNull(r.casiVittoria(s, d));

        ArrayList<Pezzo> listaPezzi = new ArrayList<>();
        for (Pezzo p :  s.listaPosizionePezzi().keySet())
        {
            if(p.getColore().isBlack())listaPezzi.add(p);
        }
        for (Pezzo pezzo : listaPezzi) s.mangiaPezzo(s.cercaPezzo(pezzo));
        assertEquals(r.casiVittoria(s,d),g);

        listaPezzi.clear();
        for (Pezzo p :  s.listaPosizionePezzi().keySet())
        {
            if(p.getColore().isWhite())listaPezzi.add(p);
        }
        for (Pezzo pezzo : listaPezzi) s.mangiaPezzo(s.cercaPezzo(pezzo));
        assertEquals(r.casiVittoria(s,d),g1);

    }

    @Test
    void statoIniziale() {
        Scacchiera s = new ScacchieraScacchi();
        Regolamento r = new RegoleDama();
        s = r.statoIniziale(s);
        int x=0;
        //CONTROLLO PRIMA RIGA BIANCA
        this.controlloRiga(1,0,0,s,ColorePezzi.BIANCO);

        //CONTROLLO SECONDA RIGA BIANCA
        this.controlloRiga(5,1,1,s,ColorePezzi.BIANCO);

        //CONTROLLO TERZA RIGA BIANCA
        this.controlloRiga(9,0,2,s,ColorePezzi.BIANCO);

        //CONTROLLO PRIMA RIGA NERO
        this.controlloRiga(13,1,5,s,ColorePezzi.NERO);

        //CONTROLLO SECONDA RIGA NERO
        this.controlloRiga(17,0,6,s,ColorePezzi.NERO);

        //CONTROLLO TERZA RIGA NERO
        this.controlloRiga(21,1,7,s,ColorePezzi.NERO);

    }
    private void controlloRiga(int i,int x,int y,Scacchiera s,ColorePezzi colore)
    {
        for ( int cont =i ;cont<=4;cont++)
        {
            Pezzo p1 = new Pedina(NomePezzi.PEDINA,colore,cont);
            assertEquals(s.cercaPezzo(p1),new PosizionePezzo(x,y));
            x += 2;
        }
    }


    @Test
    void gestioneTurno() {

    }

    @Test
    void calcoloMosseTest() {
        Scacchiera s = new ScacchieraScacchi();
        Regolamento r = new RegoleDama();
        ArrayList<Mosse> attese = new ArrayList<>();
        attese.add(new MossaDietroDx());
        //TEST MOSSA PEDINA
        Pezzo p = new Pedina(NomePezzi.PEDINA,ColorePezzi.BIANCO,1);
        s.aggiungiPezzo(p,new PosizionePezzo(0,0));

        ArrayList<Mosse> m = r.calcoloMossePezzo(s,p);
        assertEquals(attese,m);
        //TEST MOSSA MANGIA
        Pezzo p1 = new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,2);
        s.aggiungiPezzo(p1,new PosizionePezzo(1,1));
        attese.remove(new MossaDietroDx());
        attese.add(new MossaMangiaDietroDx());

        m = r.calcoloMossePezzo(s,p);
        assertEquals(attese,m);
        //TEST MOSSA DAMA
        Pezzo p2 = new Pedina(NomePezzi.DAMA,ColorePezzi.NERO,3);
        s.aggiungiPezzo(p2,new PosizionePezzo(4,4));
        attese.remove(new MossaMangiaDietroDx());
        attese.add(new MossaAvantiDx());
        attese.add(new MossaAvantiSx());
        attese.add(new MossaDietroDx());
        attese.add(new MossaDietroSx());

        m = r.calcoloMossePezzo(s,p2);
        assertEquals(attese,m);

    }

    @Test
    void possibileMangiare() {
        Regolamento r = new RegoleDama();
        Pezzo p = new Pedina(NomePezzi.PEDINA,ColorePezzi.BIANCO,1);
        Pezzo p1 = new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,2);
        Pezzo p2 = new Pedina(NomePezzi.DAMA,ColorePezzi.NERO,3);

        assertTrue(r.possibileMangiare(p,p1));
        assertFalse(r.possibileMangiare(p2,p1));
        assertTrue(r.possibileMangiare(p,p2));

    }

    @Test
    void posizionePezzoMangiato() {
        Scacchiera s = new ScacchieraScacchi();
        Regolamento r = new RegoleDama();
        Pezzo p = new Pedina(NomePezzi.PEDINA,ColorePezzi.BIANCO,1);
        Pezzo p1 = new Pedina(NomePezzi.PEDINA,ColorePezzi.NERO,2);
        s.aggiungiPezzo(p,new PosizionePezzo(0,0));
        s.aggiungiPezzo(p1,new PosizionePezzo(1,1));
        ArrayList<Mosse> m = r.calcoloMossePezzo(s,p);
        assertEquals(r.posizionePezzoMangiato(m.get(0),s,p),new PosizionePezzo(1,1));
    }
}