package interfaces;

import model.Flashcards;
import model.tipos.Flashcard;

public interface InterfaceSortear {
    public Flashcard sortear(Flashcards cards, boolean acertou);
}
