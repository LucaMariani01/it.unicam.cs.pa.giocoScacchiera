package it.unicam.cs.pa.giocoScacchiera.list.lib;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

/**
 * Definisce quello che ogni scacchiera deve fare
 */
public interface Scacchiera {

    /**
     * @return la mappa di tutti i pezzi e la loro corrispettiva posizione
     */
    public Map<Pezzo,Posizione> listaPosizionePezzi();

    /**
     * @return la lista di tutti i pezzi mangiati
     */
    public ArrayList<Pezzo> listaPezziMangiati();

    /**
     * @return lo stato attuale della scacchiera
     */
    public ArrayList<ArrayList<Optional<Pezzo>>> statoScacchiera();

    /**
     * Cambia la posizione di un pezzo nella scacchiera
     * @param p pezzo da spostare
     * @param pos nuova posizione
     */
    public void spostaPezzo(Pezzo p, Posizione pos);

    /**
     * Cerca un pezzo nella scacchiera
     * @param p Pezzo cercato
     * @return la posizione del pezzo cercato
     */
    public Posizione cercaPezzo(Pezzo p);

    /**
     *Metodo che dice se in una certa posizione ci sono o meno i pezzi
     * @param  p posizione cercata
     * @return true se il posto nella scacchiera è vuoto false se non è vuoto o fuori dalla scacchiera
     */
    public boolean postoVuoto(Posizione p);

    /**
     * Metodo che restituisce il pezzo nella posizione cercata
     * @param p posizione
     * @return pezzo che si trova in quel momento in quella posizione
     */
    public Optional<Pezzo> statoPosizione(Posizione p);

    /**
     * Mangia il pezzo in quella posizione
     * @param p Posizione del pezzo da mangiare
     * @return Pezzo mangiato
     */
    public Optional<Pezzo> mangiaPezzo(Posizione p);


    /**
     * rimuove un pezzo dalla scacchiera
     * @param p pezzo da rimuovere
     */
    public void rimuoviPezzo(Pezzo p);

    /**
     * Aggiunge un pezzo alla scacchiera
     * @param p pezzo da inserire
     * @param pos posizione pezzo
     * @return true se è andato tutto a buon fine
     */
    public Boolean aggiungiPezzo(Pezzo p, Posizione pos);

    /**
     * Trasforma un pezzo un pezzo in un altro in determinate condizioni
     *
     * @param p          pezzo
     * @param pezzoNuovo nuovo pezzo
     * @return true se il pezzo è stato trasformato
     */
    public boolean trasformaPezzo(Pezzo p, Pezzo pezzoNuovo);

}
