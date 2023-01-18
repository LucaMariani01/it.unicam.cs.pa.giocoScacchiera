package it.unicam.cs.pa.giocoScacchiera.list.api;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import it.unicam.cs.pa.giocoScacchiera.list.lib.*;
public class IterazioneGiocatoreDama implements IterazioneGiocatore {
    @Override
    public Pair<Pezzo, Mosse> scegliMossa(Giocatore g, Scacchiera s, HashMap<Pezzo, ArrayList<Mosse>> mappaMosse) {

        System.out.println("TURNO GIOCATORE:"+g.getNome()+"\nMOSSE DISPONIBILI :");
        ArrayList<Integer> nPezziConMosse =  this.stampaMosseDisponibili(mappaMosse,s,g);
        System.out.println("-1)PER RESA");
        System.out.println("INSERIRE IL NUMERO DELLA PEDINA CHE SI VUOLE MUOVERE");
        Scanner scan = new Scanner(System.in);
        int input =scan.nextInt();
        if(input == -1) return new Pair<>(null,new MossaResa());
        if (nPezziConMosse.contains(input))
        {
            System.out.println("MOSSE DEL PEZZO SCELTE DISPONIBILI :");
            Pezzo p = s.listaPosizionePezzi().keySet().stream().filter(e->e.getN()==input).findAny().get();
            return new Pair<>(p,this.scegliMossaSingoloPezzo(mappaMosse,p));
        }else {
            System.out.println("PEZZO NON DISPONIBILE RIPROVA :");
            return this.scegliMossa(g,s,mappaMosse);
        }
    }

    public Mosse scegliMossaSingoloPezzo(HashMap<Pezzo, ArrayList<Mosse>> mosse, Pezzo p){
        Regolamento r = new RegoleDama();
        Scanner scan = new Scanner(System.in);
        List<Mosse> l = r.mosseColore(mosse,p.getColore());
        List<Mosse> m;
        if (l.stream().noneMatch(a->a.getType().isMossaMangia()))  m =mosse.get(p);
        else m = mosse.get(p).stream().filter(e -> e.getType().isMossaMangia()).toList();

        for (int i = 0;i<m.size();i++) System.out.println((i+1)+")"+m.get(i));

        System.out.println("INSERIRE IL NUMERO DELLA MOSSA DEL PEZZO : "+p);
        int input ;
        do {
            input = scan.nextInt();
            if (input-1<0 || input-1>=m.size())System.out.println("VALORE INSERITO NON VALIDO \n RIPROVA:");
        } while (input-1<0 || input-1>=m.size());

        return m.get(input-1);
    }



    @Override
    public ArrayList<Integer> stampaMosseDisponibili(HashMap<Pezzo, ArrayList<Mosse>> mosse, Scacchiera s, Giocatore g) {

        ArrayList<Integer> pezzi = new ArrayList<>();
        Regolamento r = new RegoleDama();
        List<Mosse> l = r.mosseColore(mosse,g.getColore());
        for (Pezzo p : mosse.keySet()) {
            if (mosse.get(p).size() > 0 && p.getColore().equals(g.getColore())) {
                if (l.stream().anyMatch(e->e.getType().isMossaMangia())){
                    if (mosse.get(p).stream().anyMatch(e -> e.getType().isMossaMangia()))
                    {
                        pezzi.add(p.getN());
                        System.out.print(p.getN() + ") " + p+ " : " + s.cercaPezzo(p).toString());
                        mosse.get(p).stream().filter(e -> e.getType().isMossaMangia()).forEach(System.out::print);
                    }
                }else {
                    pezzi.add(p.getN());
                    System.out.print(p.getN() + ") " + p+ " : " + s.cercaPezzo(p).toString());
                    mosse.get(p).forEach(System.out::print);
                }

                System.out.println();
            }
        }
        return pezzi;
    }

    @Override
    public void stampaScacchiera(Scacchiera s) {
        System.out.println("-SCACCHIERA GIOCO-");
        System.out.println(s.toString());
        System.out.println("--FINE SCACCHIERA--");
    }


    @Override
    public  Boolean rispostaPatta(Giocatore g) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n Giocatore :"+g.getNome()+" accetti il pareggio? [TRUE = SI ], resto = NO");
        return scanner.hasNextBoolean();
    }

    @Override
    public int finePartita(Giocatore g) {
        System.out.println("\nCOMPLIMENTI IL GIOCATORE :"+ g.getNome()+" HA VINTO LA PARTITA");

        System.out.println("\n VOLETE RIGIOCARE UN'ALTRA PARITA ?? \n DIGITA 1 PER SI ALTRO PER NO");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

    }
}
