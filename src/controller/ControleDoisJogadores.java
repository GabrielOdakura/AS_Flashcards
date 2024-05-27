package controller;

import interfaces.InterfaceJogadores;
import model.Flashcards;
import model.sortear.Simples;
import model.tipos.Flashcard;

public class ControleDoisJogadores implements InterfaceJogadores {
    private Flashcards cards;
    private Flashcard cartaAtual;
    private Flashcard cartaAtual2;
    private boolean vezJogador = true; //lida o turno do jogador: true - P1, false - P2
    public ControleDoisJogadores(Flashcards cards) {
        this.cards = cards;
    }

    @Override
    public void virarFlashcard() {

    }

    @Override
    public Flashcard passarFlashcard(boolean acertou) {
        return sortearFlashcard(acertou);
    }

    @Override
    public Flashcard sortearFlashcard(boolean acertou) {
        //descomentar abaixo o algoritmo desejado
        //Leitner sortear = new Leitner();// baseado na proposta de Leitner
        Simples sortear = new Simples();//baseado em um RNG
        cartaAtual = sortear.sortear(cards, acertou);
        return cartaAtual;
    }

    @Override
    public boolean responder(String resposta) {
        return false;
    }

    public void setVezJogador() {
        if(vezJogador){// troca do jogador 1 pro 2 e vice versa
            vezJogador = false;
        }else vezJogador = true;
    }
}
