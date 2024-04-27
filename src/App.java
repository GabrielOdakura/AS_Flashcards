import controller.ControleFlashMenu;
import view.adapters.textBased.HubTexto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean modoTexto = true;
        if(modoTexto){
            boolean cartasCarregadas = false;

            HubTexto.imprimirIntro();
            int opcao = 0;
            ControleFlashMenu controle = new ControleFlashMenu();

            do {
                try {
                    opcao = input.nextInt();
                } catch (InputMismatchException e) {// caso o usuario entre um tipo errado gera uma exceção
                    HubTexto.imprimirOpcaoInvalida();
                    HubTexto.imprimirOpcoesMenuPrincipal();
                    opcao = 4;
                }
                if (opcao == 1) {
                    cartasCarregadas = controle.MenuFlashcards();
                } else if (opcao == 2) {
                    if(cartasCarregadas){//caso o jogador tenha carregado cartas ele pode jogar
                        //controle.MenuModoDeJogo();
                    }else{// caso nao carregue cartas o programa nao deixa ele prosseguir
                        HubTexto.imprimirMensagemErroFlashcardsCarregar();
                    }
                }else if(opcao == 0){
                    System.exit(0);
                }
            }while(opcao == 0);
        }else{
            //modo gui aqui
        }
        input.close();
        System.exit(0);
    }
}
