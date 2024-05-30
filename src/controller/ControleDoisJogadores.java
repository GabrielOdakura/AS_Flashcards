package controller;

import interfaces.InterfaceJogadores;
import model.Flashcards;
import model.sortear.SorteioRandom;
import model.tipos.Flashcard;
import view.adapters.textBased.TextoJogoMenu;
import view.adapters.textBased.TextoUmJogador;

public class ControleDoisJogadores implements InterfaceJogadores {
    private Flashcards cards;
    private Flashcard cartaAtualP1;
    private Flashcard cartaAtualP2;
    private boolean cartaViradaP1 = false;
    private boolean cartaViradaP2 = false;
    private boolean vezJogador = true; //lida o turno do jogador: true - P1, false - P2
    public ControleDoisJogadores(Flashcards cards) {
        this.cards = cards;
    }

    @Override
    public void virarFlashcard() {
        Flashcard cartaMostrar;
        if(vezJogador){
            cartaMostrar = cartaAtualP1;
            cartaViradaP1 = true;
        }else {
            cartaMostrar = cartaAtualP2;
            cartaViradaP2 = true;
        }
        try {
            TextoJogoMenu.imprimirPerguntaCartaAtual(cartaMostrar);
            Thread.sleep(500);
            TextoJogoMenu.imprimirAnimacaoCartaAtual(cartaMostrar);
            Thread.sleep(500);
            TextoJogoMenu.imprimirRespostaCartaAtual(cartaMostrar);
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }
    }

    @Override
    public Flashcard passarFlashcard(boolean acertou) {
        this.vezJogador = !this.vezJogador;
        return sortearFlashcard(acertou);
    }

    @Override
    public Flashcard sortearFlashcard(boolean acertou) {
        //descomentar abaixo o algoritmo desejado
        //Leitner sortear = new Leitner();// baseado na proposta de Leitner
        SorteioRandom sortear = new SorteioRandom();//baseado em um RNG
        if(vezJogador){
            cartaAtualP1 = sortear.sortear(cards, acertou);
            cartaViradaP1 = false;
        }else{
            cartaAtualP2 = sortear.sortear(cards, acertou);
            cartaViradaP2 = false;
        }

        return cartaAtualP1;
    }

    @Override
    public boolean responder(String resposta) {
        boolean acertou = false, cartaVirada = true;
        if(vezJogador){
            if(!cartaViradaP1) cartaVirada = false;
        }else{
            if(!cartaViradaP2) cartaVirada = false;
        }
        if(!cartaVirada) {
            if(vezJogador) {
                if (cartaAtualP1.getResposta().equalsIgnoreCase(resposta)) {
                    acertou = true;
                    TextoUmJogador.imprimirRespostaCorreta();
                    sortearFlashcard(true);
                } else {
                    TextoUmJogador.imprimirRespostaIncorreta();
                }
            }else {
                if (cartaAtualP2.getResposta().equalsIgnoreCase(resposta)) {
                    acertou = true;
                    TextoUmJogador.imprimirRespostaCorreta();
                    sortearFlashcard(true);
                } else {
                    TextoUmJogador.imprimirRespostaIncorreta();
                }
            }
        }
        return acertou;
    }

    public boolean getVezJogador(){
        return vezJogador;
    }

    public boolean isCartaVirada() {
        if(vezJogador) return cartaViradaP1;
        else return cartaViradaP2;
    }

    public Flashcard getCartaAtual() {
        Flashcard cartaRetorno = null;
        if(vezJogador) {
            if(cartaAtualP1 == null){
                cartaAtualP1 = sortearFlashcard(true);
                cartaRetorno = cartaAtualP1;
            }else cartaRetorno = cartaAtualP1;
        }else{
            if(cartaAtualP2 == null){
                cartaAtualP2 = sortearFlashcard(true);
                cartaRetorno = cartaAtualP2;
            }else cartaRetorno = cartaAtualP2;
        }
        return cartaRetorno;
    }

    public void passarVez() {
        this.vezJogador = !this.vezJogador;
    }

    //se for a vez do jogador 1 ele vê a carta do jogador 2 e vice versa
    public Flashcard espiarFlashcard() {
        if(vezJogador){
            return cartaAtualP2;
        }else return cartaAtualP1;
    }

    public void trocarCartas() {
        Flashcard aux;
        aux = cartaAtualP2;
        cartaAtualP2 = cartaAtualP1;
        cartaAtualP1 = aux;
    }
}
