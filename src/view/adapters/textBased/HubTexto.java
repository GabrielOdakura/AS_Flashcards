package view.adapters.textBased;

import utils.ConsoleUtils;

public class HubTexto {

    public static void imprimirIntro(){
        System.out.println(" ______   __         ______     ______     __  __     ______     ______     ______     _____     ______    ");
        System.out.println("/\\  ___\\ /\\ \\       /\\  __ \\   /\\  ___\\   /\\ \\_\\ \\   /\\  ___\\   /\\  __ \\   /\\  == \\   /\\  __-.  /\\  ___\\   ");
        System.out.println("\\ \\  __\\ \\ \\ \\____  \\ \\  __ \\  \\ \\___  \\  \\ \\  __ \\  \\ \\ \\____  \\ \\  __ \\  \\ \\  __<   \\ \\ \\/\\ \\ \\ \\___  \\  ");
        System.out.println(" \\ \\_\\    \\ \\_____\\  \\ \\_\\ \\_\\  \\/\\_____\\  \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_\\ \\_\\  \\ \\____-  \\/\\_____\\ ");
        System.out.println("  \\/_/     \\/_____/   \\/_/\\/_/   \\/_____/   \\/_/\\/_/   \\/_____/   \\/_/\\/_/   \\/_/ /_/   \\/____/   \\/_____/ ");
        System.out.println("_________________________________________________________________________________________________________________________________________________");
        imprimirOpcoesMenuPrincipal();
    }

    public static void imprimirOpcoesMenuPrincipal(){
        System.out.println("Escolha uma das opções a seguir: \n1 - Menu de Flashcards\n2 - Modo de Jogo\n0 - Fechar Jogo\nOpção Escolhida: ");
    }

    public static void imprimirOpcaoInvalida() {
        System.out.println("Opcao Invalida, tente novamente!\n");
    }

    public static void imprimirMensagemErroFlashcardsCarregar(){
        System.out.println("Carregue algum pacote de Flashcards antes de jogar!\n");
    }

    public static void imprimirSaidaDeJogo() {
        System.out.println( ConsoleUtils.RED + "Obrigado por jogar!" + ConsoleUtils.RESET);
    }
}
