import controller.ControleFlashMenu;
import model.tipos.Flashcard;
import view.adapters.textBased.HubTexto;
import view.adapters.textBased.TextoJogoMenu;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
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
                    String aux = input.nextLine();
                    opcao = Integer.parseInt(aux);
                } catch (InputMismatchException e) {// caso o usuario entre um tipo errado gera uma exceção
                    HubTexto.imprimirOpcaoInvalida();
                    opcao = -1;
                } catch (NumberFormatException e){
                    HubTexto.imprimirOpcaoInvalida();
                    opcao = -1;
                }catch (NoSuchElementException e){
                    input.close();
                    input = new Scanner(System.in);
                }
                if (opcao == 1) {
                    cartasCarregadas = controle.menuFlashcards();
                    opcao = -1;
                } else if (opcao == 2) {
                    if(cartasCarregadas){//caso o jogador tenha carregado cartas ele pode jogar
                        controle.MenuModoDeJogo();
                    }else{// caso nao carregue cartas o programa nao deixa ele prosseguir
                        HubTexto.imprimirMensagemErroFlashcardsCarregar();
                    }
                }else if(opcao == 0){
                    HubTexto.imprimirSaidaDeJogo();
                    System.exit(0);
                }else {
                    HubTexto.imprimirOpcaoInvalida();
                }
                if(opcao != 0) HubTexto.imprimirOpcoesMenuPrincipal();

            }while(opcao != 0);
        }else{//enquanto o modo grafico nao existe, é possível testar funções aqui
            Flashcard teste = new Flashcard("a minha pergunta foi essa", "Essa foi a resposta", true, "");
            TextoJogoMenu.imprimirPerguntaCartaAtual(teste);
            TextoJogoMenu.imprimirAnimacaoCartaAtual(teste);
            TextoJogoMenu.imprimirRespostaCartaAtual(teste);
            //modo gui aqui
        }
        input.close();
        System.exit(0);
    }
}
