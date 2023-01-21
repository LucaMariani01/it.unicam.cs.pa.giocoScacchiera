package it.unicam.cs.pa.giocoScacchiera.list.lib;

import it.unicam.cs.pa.giocoScacchiera.list.api.ColorePezzi;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Contratto che ogni gioco da scacchiera implementante
 * questa libreria deve avere
 */
public  interface  Regolamento {
    /**
     * Controlla se uno dei giocatori ha vinto o meno
     * @param s scacchiera da controllare
     * @param g gioco
     * @return Giocatore vincente o null in caso che la partita non si ancora finita
     */
    public Giocatore casiVittoria(Scacchiera s,Gioco g);

    /**
     *Calcola lo stato iniziale della scacchiera per il gioco di dama
     * @param s scacchiera da modificare
     * @return scacchiera con le pedine posizionate
     */
    public Scacchiera statoIniziale(Scacchiera s);

    /**
     * Regola a chi sta la mossa in quel momento della partita
     * @param g Giocatore che muove in quel turno
     * @param coppia che rappresenta il pezzo e la mossa da fare su di esso
     * @param s stato scacchiera
     * @return Il colore del giocatore che ha diritto di effettuare la prossima mossa
     */
    public ColorePezzi gestioneTurno(Giocatore g, Pair<Pezzo,Mosse> coppia, Scacchiera s);


    /**
     * Regola che calcola le mosse possibili di tutti i pezzi presenti nella scacchiera
     * @param s scacchiera
     * @return  pezzo con ogni mossa che esso puo fare in quel momento nella scacchiera
     */
    public HashMap<Pezzo,ArrayList<Mosse>> calcoloMossePezzi(Scacchiera s);

    /**
     * Calcola la mossa di un singolo pezzo durante la partita
     * @param s scacchiera
     * @param p pezzo da cui calcolare le mosse
     * @return array di mosse di quel singolo pezzo
     */
    public ArrayList<Mosse> calcoloMossePezzo(Scacchiera s,Pezzo p);

    /**
     * Calcola la posizione del pezzo che viene mangiato
     * @param m mossa
     * @param s scacchiera
     * @param p pezzo mosso
     * @return la posizione del pezzo mangiato
     */
    public Posizione posizionePezzoMangiato(Mosse m, Scacchiera s, Pezzo p);

    /**
     * Regola che definisce se un pezzo ha il permesso effettivamente mangiare un altro pezzo
     * @param rimosso pezzo che viene mangiato
     * @param pezzoEating pezzo che mangia
     * @return true se mangiare
     */
    public boolean possibileMangiare(Pezzo rimosso,Pezzo pezzoEating);

    /**
     * Restituisce tutte le mosse dei pezzi del colore passato
     * @param m tutte le mosse
     * @param c colore dei pezzi
     * @return lista di mosse
     */
    public List<Mosse> mosseColore(HashMap<Pezzo,ArrayList<Mosse>> m, ColorePezzi c);

    /**
     * Quando il giocatore muove ricalcola il nuovo stato della scacchiera
     * @param s coppia Pezzo, Mossa
     * @param p coppia Pezzo, Mossa
     * @param turno Giocatore che muove
     * @param g stato partita
     * @return scacchiera ricalcolata
     */
    public Scacchiera gestisciMosseGiocatore(Scacchiera s,Pair<Pezzo,Mosse> p, Giocatore turno,Gioco g);

    /**
     * Regola che gestisce il momento che un giocatore mangia nella scacchiera
     * @param p coppia Pezzo, Mossa
     * @param s coppia Pezzo, Mossa
     * @return scacchiera ricalcolata dopo la mossa
     */
    public boolean giocatoreMangia(Pair<Pezzo,Mosse> p,Scacchiera s);
}
