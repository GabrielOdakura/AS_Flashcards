package model.sortear;

import interfaces.InterfaceSortear;
import model.Flashcards;
import model.tipos.Caixa;
import model.tipos.Flashcard;

import java.util.ArrayList;
import java.util.Random;

public class Leitner implements InterfaceSortear {

    private ArrayList<Caixa> caixasP1 = null;
    private Flashcard cartaAtualP1;
    private ArrayList<Caixa> caixasP2 = null;
    private Flashcard cartaAtualP2;
    private boolean doOnce = true;
    private Random random = new Random();

    @Override
    public Flashcard sortear(Flashcards cards, boolean acertou, boolean jogador) {
        if(doOnce){
            caixasP1 = new ArrayList<>();
            caixasP2 = new ArrayList<>();
            int numCaixas = cards.getNumeroDeCartas() / 4;
            for (int i = 1; i < (numCaixas + 1); i++){
                caixasP1.add(new Caixa(i));
                caixasP2.add(new Caixa(i));
                Caixa aux1 = caixasP1.get(i - 1);
                Caixa aux2 = caixasP2.get(i - 1);
                for (int j = (i - 1) * 4 + 1; j <= i * 4; j++){
                    aux1.addCarta(cards.getCard(j));
                    aux2.addCarta(cards.getCard(j));
                }
            }
            doOnce = false;
            if(jogador) return cartaAtualP1 = caixasP1.get(0).getCards().get(0);
            else return cartaAtualP2 = caixasP2.get(0).getCards().get(0);
        }
        if(jogador){
            for (Caixa caixa : caixasP1) {
                if (caixa.getCards().contains(cartaAtualP1)) {
                    if (acertou) {
                        moverCartaParaCima(cartaAtualP1, caixa.getNumeroCaixa(), caixasP1, jogador);
                    } else {
                        moverCartaParaBaixo(cartaAtualP1, caixasP1);
                    }
                    int numCartas;
                    if((numCartas = caixasP1.get(0).getCards().size()) != 1){
                        return cartaAtualP1 = caixasP1.get(0).getCards().get(random.nextInt(0,caixasP1.get(0).getCards().size() - 1));
                    }else return cartaAtualP1 = caixasP1.get(0).getCards().get(0);

                }
            }
        }else{
            for (Caixa caixa : caixasP2) {
                if (caixa.getCards().contains(cartaAtualP2)) {
                    if (acertou) {
                        moverCartaParaCima(cartaAtualP2, caixa.getNumeroCaixa(), caixasP1, jogador);
                    } else {
                        moverCartaParaBaixo(cartaAtualP2, caixasP1);
                    }
                    int numCartas;
                    if((numCartas = caixasP2.get(0).getCards().size()) != 1){
                        return cartaAtualP2 = caixasP2.get(0).getCards().get(random.nextInt(0,caixasP1.get(0).getCards().size() - 1));
                    }else return cartaAtualP2 = caixasP2.get(0).getCards().get(0);
                }
            }
        }

        return null;
    }

    private void moverCartaParaCima(Flashcard carta, int numCaixaAtual, ArrayList<Caixa> caixaJogador, boolean jogador) {
        if (numCaixaAtual < caixaJogador.size()) {
            caixaJogador.get(numCaixaAtual - 1).removerCarta(carta);
            caixaJogador.get(numCaixaAtual).addCarta(carta);
        }
        if(caixasP1.get(0).getCards().size() == 0){
            Caixa aux = caixasP1.get(0);
            caixasP1.remove(0);
            caixasP1.add(aux);
            if(jogador) {
                for (int i = 0; i < caixasP1.size(); i++) {
                    caixasP1.get(i).setNumeroCaixa(i + 1);
                }
            }else {
                for (int i = 0; i < caixasP2.size(); i++) {
                    caixasP2.get(i).setNumeroCaixa(i + 1);
                }
            }
        }
    }

    private void moverCartaParaBaixo(Flashcard carta, ArrayList<Caixa> caixaJogador) {
        for (int i = 1; i < caixaJogador.size(); i++) {
            if (caixaJogador.get(i).getCards().contains(carta)) {
                caixaJogador.get(i).removerCarta(carta);
                caixaJogador.get(0).addCarta(carta);
                i = caixaJogador.size() + 1;
            }
        }
    }
}
