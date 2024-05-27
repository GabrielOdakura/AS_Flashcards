package interfaces;

import model.Flashcards;
import model.tipos.Flashcard;

public interface InterfaceJogadores {
    Flashcards cards = null;
    public void virarFlashcard();
    public Flashcard passarFlashcard(boolean acertou);
    public Flashcard sortearFlashcard(boolean acertou);
    public boolean responder(String resposta);

}
