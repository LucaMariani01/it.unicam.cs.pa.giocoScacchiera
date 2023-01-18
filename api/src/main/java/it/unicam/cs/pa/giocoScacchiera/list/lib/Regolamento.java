package it.unicam.cs.pa.giocoScacchiera.list.lib;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public  interface  Regolamento {
    /**
     * Controlla se uno dei giocatori ha vinto o meno
     * @param s scacchiera da controllare
     * @param g gioco
     * @return Giocatore vincente o null in caso che la partita non si ancora finita
     */
    public Giocatore casiVittoria(Scacchiera s,Gioco g);

    /**
     *Calcola la posizione dei pezzi a inizio partita
     * @return lo stato iniziale della scacchiera
     *       ancora prima che siano state effettuate mosse
     */
    public Scacchiera statoIniziale(Scacchiera s);

    /**
     * Metodo che dice chi tocca a muovere in un dato momento della partita
     * @param g Giocatore che muove in quel turno
     * @param coppia che rappresenta il pezzo e la mossa da fare su di esso
     * @param s stato scacchiera
     * @return Il colore del giocatore che ha diritto di effettuare la prossima mossa
     */
    public ColorePezzi gestioneTurno(Giocatore g, Pair<Pezzo,Mosse> coppia, Scacchiera s);


    /**
     * calcola le mosse possibili di tutti i pezzi presenti nella scacchiera
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
     * Controlla se un pezzo può effettivamente mangiare un altro pezzo
     * @param rimosso pezzo che viene mangiato
     * @param pezzoEating pezzo che mangia
     * @return true se può mangiare
     */
    public boolean possibileMangiare(Pezzo rimosso,Pezzo pezzoEating);

    public List<Mosse> mosseColore(HashMap<Pezzo,ArrayList<Mosse>> m, ColorePezzi c);


}
