package controller;

import interfaces.InterfaceJogadores;
import model.Flashcards;
import model.sortear.SorteioRandom;
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
        if(!cartaVirada) {
            if (cartaAtual.getResposta().equalsIgnoreCase(resposta)) {
                acertou = true;
                TextoUmJogador.imprimirRespostaCorreta();
                sortearFlashcard(true);
            } else {
                TextoUmJogador.imprimirRespostaIncorreta();
            }
        }
        return acertou;
    }

    @Override
    public void virarFlashcard() {
        this.cartaVirada = true;
        try {
            TextoJogoMenu.imprimirPerguntaCartaAtual(cartaAtual);
            Thread.sleep(500);
            TextoJogoMenu.imprimirAnimacaoCartaAtual(cartaAtual);
            Thread.sleep(500);
            TextoJogoMenu.imprimirRespostaCartaAtual(cartaAtual);
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }
    }

    @Override
    public Flashcard passarFlashcard(boolean acertou) {
        return sortearFlashcard(acertou);
    }

    @Override
    public Flashcard sortearFlashcard(boolean acertou) {
        //descomentar abaixo o algoritmo desejado
        //Leitner sortear = new Leitner();// baseado na proposta de Leitner
        SorteioRandom sortear = new SorteioRandom();//baseado em um RNG
        cartaAtual = sortear.sortear(cards, acertou);
        cartaVirada = false;
        return cartaAtual;
    }

    public Flashcard getCartaAtual() {
        if(cartaAtual == null){
            cartaAtual = sortearFlashcard(true);
        }
        return cartaAtual;
    }

    public boolean isCartaVirada() {
        return cartaVirada;
    }
}
