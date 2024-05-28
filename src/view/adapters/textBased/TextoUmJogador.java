package view.adapters.textBased;


import model.tipos.Flashcard;
import utils.ConsoleUtils;

public class TextoUmJogador {
    public static void imprimirMenu(){
        System.out.println("\nEscolha uma opção:\n1 - Responder\n2 - Passar Carta\n" +
                "3 - Sortear Proxima\n4 - Virar Carta\n0 - Sair Deste Menu\nOpção Escolhida: ");
    }

    public static void imprimirAcertos(int acertos){
        System.out.println("Voce acertou " + acertos + " carta(s)!");
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
}
