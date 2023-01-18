package it.unicam.cs.pa.giocoScacchiera.list.api;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import it.unicam.cs.pa.giocoScacchiera.list.lib.*;
public  class RegoleDama implements Regolamento{
    @Override
    public Giocatore casiVittoria(Scacchiera s, Gioco g ) {

        if(s.listaPezziMangiati().stream().filter(e->e.getColore().isWhite()).count() == 12){
            g.getGiocatoreN().aggiungiVittoria();
            g.getGiocatoreB().aggiungiPartita();
            return g.getGiocatoreN();
        }
        if (s.listaPezziMangiati().stream().filter(e->e.getColore().isBlack()).count() == 12) {
            g.getGiocatoreB().aggiungiVittoria();
            g.getGiocatoreN().aggiungiPartita();
            return g.getGiocatoreB();
        }
        return null;
    }

    @Override
    public Scacchiera statoIniziale(Scacchiera s) {

        int pezziInseriti = 0 ;
        boolean can = true ;
        ColorePezzi colore = ColorePezzi.BIANCO;

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (y < 3 || y > 4) {
                    if (can) s.aggiungiPezzo(new Pedina(NomePezzi.PEDINA, colore, ++pezziInseriti),
                                            new PosizionePezzo(x, y));
                    can = !can;
                }
            }
            can = !can;
            if(y>3) colore = ColorePezzi.NERO;
        }
        return s;
    }

    @Override
    public ColorePezzi gestioneTurno(Giocatore turno, Pair<Pezzo, Mosse> pair, Scacchiera s) {

        if (!pair.getValue().getType().isMossaMangia()){
            if(turno.getColore().isWhite()) return ColorePezzi.NERO;
            else return ColorePezzi.BIANCO;
        }else {
            if (this.calcoloMossePezzi(s).get(pair.getKey()).stream().anyMatch(e -> e.getType().isMossaMangia())) return turno.getColore();
        }
        return null;
    }

    /**
     * Funzione di aiuto al calcolo delle mosse che permette di calcolare le mosse
     * in cui un pezzo mangerebbe un altro
     * @param m mossa di partenza
     * @param s stato scacchiera
     * @param p pezzo da spostare
     * @return la nuova mossa o null se la posizione è occupata
     */
    private Mosse casoEat(Mosse m,Scacchiera s,Pezzo p) {

        Mosse m1 = switch (m.getType()) {
            case MossaAvantiDx -> new MossaMangiaAvantiDx();
            case MossaAvantiSx -> new MossaMangiaAvantiSx();
            case MossaDietroDx -> new MossaMangiaDietroDx();
            case MossaDietroSx -> new MossaMangiaDietroSx();
            default -> null;
        };

        if (s.postoVuoto(m1.mossa(s.cercaPezzo(p)))) return m1;
       else return null;
    }

    @Override
    public HashMap<Pezzo, ArrayList<Mosse>> calcoloMossePezzi(Scacchiera s) {
        HashMap<Pezzo, ArrayList<Mosse>> mappaMosse = new HashMap<>();

        for (Pezzo p : s.listaPosizionePezzi().keySet()) mappaMosse.put(p,this.calcoloMossePezzo(s,p));

        return mappaMosse;
    }

    /**
     * Controlla se una mossa è valida o no e se è possibile effettuare una mossa che mangi un
     * pezzo dell'avversario (metodo di aiuto al metodo di calcolo mosse)
     * @param m mossa da controllare la validità
     * @param s stato corrente scacchiera
     * @param p pezzo da spostare nella scacchiera
     * @return m se la mossa è valida o la c
     */
    private Mosse mossaValida(Mosse m,Scacchiera s, Pezzo p)
    {
        if (s.postoVuoto(m.mossa(s.cercaPezzo(p)))) return m;
        else{
            if (s.statoPosizione(m.mossa(s.cercaPezzo(p))).isPresent()) {
                if (!Objects.equals(s.statoPosizione(m.mossa(s.cercaPezzo(p))).get().getColore(), p.getColore()))
                    return this.casoEat(m, s, p);
            }
        }
        return null;
    }
    @Override
    public ArrayList<Mosse> calcoloMossePezzo(Scacchiera s, Pezzo p) {

        ArrayList<Mosse> a = new ArrayList<>();
        Mosse m;

        if (Objects.equals(p.getColore(), ColorePezzi.NERO) || p.getNomePezzo().equals(NomePezzi.DAMA))
        {

            m = new MossaAvantiDx();
            for (int i = 0 ;i<=1;i++) {

                if (this.mossaValida(m, s, p) != null) a.add(this.mossaValida(m, s, p));
                m = new MossaAvantiSx();
            }
        }

        if (Objects.equals(p.getColore(), ColorePezzi.BIANCO) || p.getNomePezzo().equals(NomePezzi.DAMA)){

            m = new MossaDietroDx();
            for (int i = 0; i<=1;i++) {
                if (this.mossaValida(m, s, p) != null) a.add(this.mossaValida(m, s, p));
                m = new MossaDietroSx();
            }
        }
        return a;
    }


    public boolean possibileMangiare(Pezzo rimosso,Pezzo pezzoEating)
    {
        if( rimosso.getNomePezzo().equals(NomePezzi.PEDINA) || pezzoEating.getNomePezzo().equals(NomePezzi.DAMA)) return true;
        else
        {
            System.out.println("PEDINA NON PUO MANGIARE DAMA");
            return false;
        }
    }

    @Override
    public Posizione posizionePezzoMangiato(Mosse m, Scacchiera s, Pezzo p) {

        return switch (m.getType()) {
            case MossaMangiaAvantiDx -> new PosizionePezzo(m.mossa(s.cercaPezzo(p)).x()-1,
                    m.mossa(s.cercaPezzo(p)).y()+1);
            case MossaMangiaAvantiSx -> new PosizionePezzo(m.mossa(s.cercaPezzo(p)).x()+1,
                    m.mossa(s.cercaPezzo(p)).y()+1);
            case MossaMangiaDietroDx -> new PosizionePezzo(m.mossa(s.cercaPezzo(p)).x()-1,
                    m.mossa(s.cercaPezzo(p)).y()-1);
            case MossaMangiaDietroSx ->new PosizionePezzo(m.mossa(s.cercaPezzo(p)).x()+1,
                    m.mossa(s.cercaPezzo(p)).y()-1);
            default -> null;
        };
    }

    @Override
    public List<Mosse> mosseColore(HashMap<Pezzo, ArrayList<Mosse>> m, ColorePezzi c) {
        List<Mosse> l = new ArrayList<>();
        for (Pezzo p : m.keySet()){
            if(p.getColore().equals(c)) l.addAll(m.get(p));
        }
        return l;
    }


}
