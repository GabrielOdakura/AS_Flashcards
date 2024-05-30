package model;

import model.persistencia.PersistenciaLink;
import model.tipos.Flashcard;

import java.util.LinkedList;

public class Flashcards {

    private LinkedList<Flashcard> cards;
    private int numeroDeCartas;
    private PersistenciaLink persistencia = new PersistenciaLink();

    public Flashcards(Flashcard carta){
        cards = new LinkedList<>();
        cards.add(carta);
        numeroDeCartas = cards.size();
    }

    public Flashcards (LinkedList<Flashcard> cartoes){
        if(cartoes != null) {
            cards = cartoes;
            numeroDeCartas = cards.size();
        }
    }

    public Flashcards(String nomeDoArquivo){
        carregarFlashcards(nomeDoArquivo);
        numeroDeCartas = cards.size();
    }

    public void carregarFlashcards(String nomeDoArquivo) {
        cards = persistencia.carregarFlashcards(nomeDoArquivo);

    }

    public void criarFlashcards(String nomeDoArquivo, String pergunta,String resposta,boolean enabled, String link){ //adicionar nomeDoArquivo dps
        persistencia.salvarFlashcards(nomeDoArquivo, pergunta, resposta, enabled, link);
    }

    public void removerFlashcards(String nomeDoArquivo, int id){
        persistencia.removerFlashCards(nomeDoArquivo, id);
    }

    public int getNumeroDeCartas() {
        return numeroDeCartas;
    }

    private void setNumeroDeCartas(int numeroDeCartas) {
        this.numeroDeCartas = numeroDeCartas;
    }

    public LinkedList<Flashcard> getCards() {
        return cards;
    }

    public void setCards(LinkedList<Flashcard> cards) {
        this.cards = cards;
    }

    public Flashcard getCard(int index){
        return cards.get(index);
    }
}
