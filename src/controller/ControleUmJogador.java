package controller;

import interfaces.InterfaceJogadores;
import model.Flashcards;
import model.sortear.Leitner;
import model.sortear.Simples;
import model.tipos.Flashcard;
import view.adapters.textBased.TextoJogoMenu;
import view.adapters.textBased.TextoUmJogador;

public class ControleUmJogador implements InterfaceJogadores {
    private Flashcards cards;
    private Flashcard cartaAtual;
    private boolean cartaVirada;
    public ControleUmJogador(Flashcards cards) {
        this.cards = cards;
        this.cartaVirada = false;
    }
    @Override
    public boolean responder(String resposta) {
        boolean acertou = false;
        if(cartaVirada) {
            if (cartaAtual.getResposta().equalsIgnoreCase(resposta)) {
                acertou = true;
                TextoUmJogador.imprimirRespostaCorreta();
                sortearFlashcard(true);
            } else {
                TextoUmJogador.imprimirOpcaoInvalida();
            }
        }else{

        }
        return acertou;
    }

    @Override
    public void virarFlashcard() {
        TextoJogoMenu.imprimirPerguntaCartaAtual(cartaAtual);
        TextoJogoMenu.imprimirAnimacaoCartaAtual(cartaAtual);
        TextoJogoMenu.imprimirRespostaCartaAtual(cartaAtual);
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




}
