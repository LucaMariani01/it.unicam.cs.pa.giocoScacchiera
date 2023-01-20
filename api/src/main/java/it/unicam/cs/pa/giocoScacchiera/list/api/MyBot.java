package it.unicam.cs.pa.giocoScacchiera.list.api;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import it.unicam.cs.pa.giocoScacchiera.list.lib.*;

/**
 * Classe che permette al computer di compiere mosse
 */
public class MyBot implements Bot {
    @Override
    public Pair<Pezzo, Mosse> faiMossa(ColorePezzi c, Scacchiera s, HashMap<Pezzo, ArrayList<Mosse>> mappaMosse) {

        Random random = new Random();
        ArrayList<Integer> nPezziConMosse =  this.getArrayPezzi(mappaMosse, c);
        int scelta ;
        do {
            scelta = random.nextInt(24)+1 ;
        }while (!nPezziConMosse.contains(scelta));

        int finalScelta = scelta;
        Pezzo p = s.listaPosizionePezzi().keySet().stream().filter(e->e.getN()== finalScelta).findAny().get();
        Pair<Pezzo,Mosse> mossaBot = new Pair<>(p,this.muoviSingoloPezzo(mappaMosse,p));

        System.out.println("IL BOT MUOVE IL PEZZO NUMERO :"+scelta +" FACENDO LA MOSSA : "+mossaBot.getValue() );
        return mossaBot;
    }

    /**
     * Mostra i pezzi che il bot deve muovere
     * @param mosse tutte le mosse disponibili
     * @param c colore dei pezzi che si muove
     * @return array con l'indice dei pezzi disponibili
     */
    private ArrayList<Integer> getArrayPezzi(HashMap<Pezzo, ArrayList<Mosse>> mosse, ColorePezzi c)
    {
        Regolamento r = new RegoleDama();
        ArrayList<Integer> pezzi = new ArrayList<>();
        List<Mosse> l = r.mosseColore(mosse,c);
        for (Pezzo p : mosse.keySet()) {
            if (mosse.get(p).size() > 0 && p.getColore().equals(c)) {
                if (l.stream().anyMatch(e->e.getType().isMossaMangia())){
                    if (mosse.get(p).stream().anyMatch(e -> e.getType().isMossaMangia()))pezzi.add(p.getN());
                }else pezzi.add(p.getN());
            }
        }
        return pezzi;
    }
    @Override
    public Mosse muoviSingoloPezzo(HashMap<Pezzo, ArrayList<Mosse>> mosse, Pezzo p){
        Regolamento r = new RegoleDama();
        Random random = new Random();
        List<Mosse> l = r.mosseColore(mosse,p.getColore());
        List<Mosse> m;
        if (l.stream().noneMatch(a->a.getType().isMossaMangia()))  m =mosse.get(p);
        else m = mosse.get(p).stream().filter(e -> e.getType().isMossaMangia()).toList();

        int scelta =  random.nextInt(m.size()) ;

        return m.get(scelta);
    }
}
