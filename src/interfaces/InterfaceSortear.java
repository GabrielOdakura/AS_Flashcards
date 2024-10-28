package interfaces;

import model.tipos.Flashcards;
import model.tipos.Flashcard;

public interface InterfaceSortear {
    public Flashcard sortear(Flashcards cards, boolean acertou, boolean jogador);
}
