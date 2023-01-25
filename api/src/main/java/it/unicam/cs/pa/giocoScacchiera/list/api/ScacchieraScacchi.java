package it.unicam.cs.pa.giocoScacchiera.list.api;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import it.unicam.cs.pa.giocoScacchiera.list.lib.*;

/**
 *Classe che definisce una scacchiera di scacchi
 */
public class ScacchieraScacchi implements Scacchiera {
    /**
     * Mappa Pezzo -> Posizione
     */
    private final Map<Pezzo, Posizione> posizionePezzi;
    /**
     *Matrice di Optional Pezzi (Option.empty se il posto è vuoto)
     */
    private final ArrayList<ArrayList<Optional<Pezzo>>> scacchiera;
    /**
     *Array di pezzi che non sono più nella scacchiera
     */
    private final ArrayList<Pezzo> pezziMangiati;

    /**
     *Costruttore
     */
    public  ScacchieraScacchi(){
        this.posizionePezzi = new HashMap<>();
        this.scacchiera = new ArrayList<>();
        this.pezziMangiati = new ArrayList<>();

        for (int i = 0 ;i < 8;i++) this.scacchiera.add(i, new ArrayList<>(8));

        for (int i = 0 ;i < 8;i++)
        {
            for (int j = 0 ; j<8;j++) this.scacchiera.get(i).add(j,Optional.empty());
        }
    }

    @Override
    public Map<Pezzo, Posizione> listaPosizionePezzi() {
        return this.posizionePezzi;
    }

    @Override
    public ArrayList<Pezzo> listaPezziMangiati() {
        return this.pezziMangiati;
    }

    @Override
    public ArrayList<ArrayList<Optional<Pezzo>>> statoScacchiera() {
        return this.scacchiera;
    }

    @Override
    public void spostaPezzo(Pezzo p, Posizione pos) {
       this.rimuoviPezzo(p);
       this.aggiungiPezzo(p, pos);
    }

    @Override
    public Posizione cercaPezzo(Pezzo p) {
        return  this.posizionePezzi.get(p);
    }

    @Override
    public boolean postoVuoto(Posizione p) {
        if (p.y()<0 || p.y()>7 || p.x()<0 || p.x()>7) return false;
        else return (this.scacchiera.get(p.y()).get(p.x()).equals(Optional.empty()) );
    }

    @Override
    public Optional<Pezzo> statoPosizione(Posizione p) {
        if (p.y()<0 || p.y()>7 || p.x()<0 || p.x()>7) return Optional.empty();
        else return this.scacchiera.get(p.y()).get(p.x());
    }

    @Override
    public Optional<Pezzo> mangiaPezzo(Posizione p) {
        Optional<Pezzo> rimosso = this.statoPosizione(p);
        if(rimosso.isPresent() ){
                this.rimuoviPezzo(rimosso.get());
                this.pezziMangiati.add(rimosso.get());
                return rimosso;
        }
        return Optional.empty();
    }

    @Override
    public void rimuoviPezzo(Pezzo p) {
        if (!this.posizionePezzi.containsKey(p)) return;

        this.scacchiera.get(this.cercaPezzo(p).y()).set(this.cercaPezzo(p).x(),Optional.empty());
        this.posizionePezzi.remove(p);

    }

    @Override
    public Boolean aggiungiPezzo(Pezzo p, Posizione pos) {
        if (!this.postoVuoto(pos)) return false;
        this.scacchiera.get(pos.y()).set(pos.x(),Optional.of(p));
        this.posizionePezzi.put(p,pos);

        return true;
    }



    @Override
    public String toString() {
        int a = 1;
        StringBuilder app = new StringBuilder(a + "|");
        for (int i = 0 ; i< 8 ;i++)
        {
            a++;
            int y = 0 ;
            for (Optional<Pezzo> p : this.scacchiera.get(i)){

                if(y<8) {
                    if (p.isPresent()) {

                         app.append(p.get()).append("|");

                    } else app.append("[]").append("|");
                    y++;
                }
            }
            if (a != 9) app.append("\n").append(a).append("|");
        }

        char c = 65;
        app.append("\nN").append("|");
        for(int i = 0 ;i<8;i++) {
            app.append(" ").append(c).append("|");
            c++;
        }
        return app.toString();
    }

    @Override
    public boolean trasformaPezzo(Pezzo p, Pezzo pezzoNuovo) {

        Posizione posizioneApp = this.cercaPezzo(p);
        this.rimuoviPezzo(p);
        this.aggiungiPezzo(pezzoNuovo,posizioneApp);

        return true;
    }


}
