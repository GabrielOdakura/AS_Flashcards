package view.adapters.textBased;

import model.tipos.Flashcard;
import utils.ConsoleUtils;

public class TextoDoisJogadores {
    public static void imprimirMenu(String jogador){
        System.out.println("\nVez de jogador " + jogador +"\nEscolha uma opção:\n1 - Responder\n2 - Passar Carta\n" +
                "3 - Sortear Proxima\n4 - Virar Carta\n5 - Espiar Outro Jogador\n6 - Trocar Carta com Outro Jogador\n7 - Passar a Vez\n0 - Sair Deste Menu\nOpção Escolhida: ");
    }
    public static void imprimirAcertos(int[] acertos){
        System.out.println("Jogador 1 acertou " + acertos[0] + " carta(s)!");
        System.out.println("Jogador 2 acertou " + acertos[1] + " carta(s)!");
    }

    public static void imprimirOpcaoInvalida() {
        System.out.println("Opção Inválida, tente novamente!");
    }

    public static void imprimirRespostaCorreta() {
        System.out.println(ConsoleUtils.GREEN + "Parabens! Resposta Correta!" + ConsoleUtils.RESET + "\n");
    }

    public static void imprimirRespostaIncorreta() {
        System.out.println(ConsoleUtils.RED + "Resposta Incorreta!" + ConsoleUtils.RESET + "\n");
    }

    public static void imprimirCartaJaVirada(){
        System.out.println("A carta foi virada, revelando sua resposta, poranto não se pode mais tentar!");
    }

    public static void imprimirCarta(Flashcard cartaAtual) {
        TextoJogoMenu.imprimirPerguntaCartaAtual(cartaAtual);
    }

    public static void imprimirEntradaResposta() {
        System.out.println("Digite a sua resposta: ");
    }

    public static void imprimirCartaOutroJogador(Flashcard cartaOutroJogador){
        System.out.println("A carta do outro jogador é:");
        TextoJogoMenu.imprimirPerguntaCartaAtual(cartaOutroJogador);
    }

    public static void imprimirMensagemCartasTrocadas() {
        System.out.println("As cartas dos jogadores foram trocadas!");
    }
}
