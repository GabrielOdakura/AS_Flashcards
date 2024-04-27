package model.persistencia;

import model.tipos.Flashcard;
import model.persistencia.adapters.JSONAdapter;

import java.util.LinkedList;

public class PersistenciaLink {
    JSONAdapter adaptador = new JSONAdapter();


    public LinkedList<Flashcard> carregarFlashcards(String nomeDoArquivo) {
        return adaptador.carregarFlashcards(nomeDoArquivo);
    }

    public boolean salvarFlashcards(String nomeDoArquivo, String pergunta,String resposta,boolean enabled, String link){
        return adaptador.salvarFlashcards(nomeDoArquivo, pergunta, resposta, enabled, link);
    }
    public void removerFlashCards(String nomeDoArquivo, int id){
        adaptador.removerFlashCards(nomeDoArquivo, id);
    }
}
