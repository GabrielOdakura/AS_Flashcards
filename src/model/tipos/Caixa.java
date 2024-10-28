package model.tipos;


import java.util.ArrayList;

public class Caixa {
    private ArrayList<Flashcard> cards;
    private int numeroCaixa;

    public Caixa(int numCaixa){
        this.cards = new ArrayList<Flashcard>();
        this.numeroCaixa = numCaixa;
    }

    public void removerCarta(Flashcard card) {
        cards.remove(card);
    }
    public void addCarta (Flashcard carta){
        this.cards.add(carta);
    }

    public ArrayList<Flashcard> getCards() {
        return cards;
    }

    public int getNumeroCaixa() {
        return numeroCaixa;
    }

    public void setNumeroCaixa(int numMudar){
        this.numeroCaixa = numMudar;
    }

}
