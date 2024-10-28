package interfaces;

import model.tipos.Flashcards;
import model.tipos.Flashcard;

import java.util.LinkedList;

public interface InterfacePersistencia {
    boolean salvarFlashcards(String nomeDoArquivo, String pergunta, String resposta, boolean enabled, String link);
    LinkedList<Flashcard> carregarFlashcards(String nomeDoArquivo);
    void removerFlashCards(String nomeDoArquivo, int id);
    boolean salvarPacoteBase(Flashcards cartas);
}
