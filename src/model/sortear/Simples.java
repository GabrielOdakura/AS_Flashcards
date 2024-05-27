package model.sortear;

import interfaces.InterfaceSortear;
import model.Flashcards;
import model.tipos.Flashcard;

import java.util.Random;

public class Simples implements InterfaceSortear {
    @Override
    public Flashcard sortear(Flashcards cards, boolean acertou){
        Random random = new Random();
        return cards.getCard(random.nextInt(0, (cards.getNumeroDeCartas() - 1)));
    }
}
