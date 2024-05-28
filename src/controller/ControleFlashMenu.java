package controller;

import model.Flashcards;
import model.persistencia.PacoteCartasBasico;
import model.persistencia.PersistenciaLink;
import model.tipos.Flashcard;
import view.adapters.textBased.TextoFlashMenu;
import view.adapters.textBased.TextoJogoMenu;
import view.adapters.textBased.TextoUmJogador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ControleFlashMenu {

    private Flashcards cards;
    public boolean menuFlashcards() {
        boolean cartasCarregadas = false;
        int opcao = 0;
        boolean flipflop = true;

        Scanner input = new Scanner(System.in);
        PersistenciaLink persistencia = new PersistenciaLink();
        do {
            TextoFlashMenu.imprimirMenu();
            opcao = 0;
            String nomeDoArquivo = "";
            try{
                opcao = input.nextInt();
                if(opcao != 4) {
                    if (flipflop && opcao != 0) {
                        TextoFlashMenu.imprimirSolicitarNomeArquivo();
                        input.nextLine();
                        nomeDoArquivo = input.nextLine();
                        flipflop = false;
                    }
                }
            }catch (InputMismatchException e){// caso o usuario entre um tipo errado gera uma exceção
                TextoFlashMenu.imprimirErroDeEntrada();
                TextoFlashMenu.imprimirMenu();
                opcao = -1;
            }
            if(opcao == 1){// salvar flashcard
                String pergunta = "", resposta = "", link = "", aux = "";
                boolean enabled = false;
                for (int i = 0; i < 4 ; i++) {
                    TextoFlashMenu.imprimirSalvarNovoFlashcard(i);//chama o menu 1 por 1 para o tipo de info que ele quer
                    if (i == 0) {//pede a pergunta pro usuário
                        pergunta = input.nextLine();
                    } else if (i == 1) {//pede a resposta pro usuário
                        resposta = input.nextLine();
                    } else if (i == 2) {//pergunta se a carta vai estar habilitada pro usuário
                        aux = input.nextLine();
                        if (!aux.isEmpty()) {
                            enabled = aux.equalsIgnoreCase("enabled"); //se for igual a enabled coloca como true
                        }
                    } else if (i == 3) {//pede um link caso o usuário queira importar uma imagem
                        link = input.nextLine();
                    }
                }
                if(persistencia.salvarFlashcards(nomeDoArquivo, pergunta, resposta, enabled, link)){//carrega os flashcards no arquivo + o novo
                    cards = new Flashcards(nomeDoArquivo);
                    cartasCarregadas = true;
                }else{//se nenhum card estiver carregado ele cria um novo
                    Flashcard auxFlashcard = new Flashcard(pergunta, resposta, enabled, link);
                    cards = new Flashcards(aux);
                }
                flipflop = true;
            }else if(opcao == 2){//carregar flashcards
                cards = new Flashcards(persistencia.carregarFlashcards(nomeDoArquivo));
                flipflop = true;

            }else if(opcao == 3){//deletar flashcard
                int id = -1;
                try{
                     id = input.nextInt();
                     persistencia.removerFlashCards(nomeDoArquivo, id);
                     input.nextLine();//por conta do nextInt já que ele não pula uma linha depois de ler o id
                }catch (InputMismatchException e){// caso o usuario entre um tipo errado gera uma exceção
                    TextoFlashMenu.imprimirErroDeEntrada();
                    id = -1;
                }
                if(id != -1) {//se ele for -1 é que ocorreu um erro
                    cards.removerFlashcards(nomeDoArquivo, id);
                }
            }else if(opcao == 4){
                PacoteCartasBasico pacoteBase = new PacoteCartasBasico();
                if(persistencia.salvarPacoteBase(pacoteBase.gerarPacoteBase())){
                    cards = new Flashcards("PacoteBase");
                    cartasCarregadas = true;
                }

            }else if(opcao == 0){
                TextoFlashMenu.imprimirVoltandoMenu();
            }else{// caso a opção não seja valida ele manda uma mensagem de erro e repete o loop
                TextoFlashMenu.imprimirOpcaoInvalida();
                opcao = -1;
            }
        }while(opcao != 0);
        return cartasCarregadas;
    }

    public void MenuModoDeJogo() {
        int opcao = 0;
        Scanner input = new Scanner(System.in);
        boolean jogadorAcertou = false;
        do {
            TextoJogoMenu.imprimirMenu();// chama o metodo do view pra imprimir no console
            try {
                opcao = input.nextInt();
            }catch (InputMismatchException e){
                opcao = -1;
            }
            int acertos = 0;
            if(opcao == 1){// seleciona o modo de um jogador
                ControleUmJogador modoDeJogo = new ControleUmJogador(cards);
                do {
                    TextoUmJogador.imprimirCarta(modoDeJogo.getCartaAtual());
                    TextoUmJogador.imprimirMenu();
                    TextoUmJogador.imprimirAcertos(acertos);
                    opcao = input.nextInt();
                    if(opcao == 1){
                        TextoUmJogador.imprimirCarta(modoDeJogo.getCartaAtual());
                        input.nextLine();// pula a linha para a resposta, devido ao nextInt()
                        if(!modoDeJogo.isCartaVirada()) {
                            TextoUmJogador.imprimirEntradaResposta();
                            String resposta = input.nextLine();
                            jogadorAcertou = modoDeJogo.responder(resposta); //verifica se a resposta esta correta
                        }else{
                            TextoUmJogador.imprimirCartaJaVirada();
                        }
                        if(jogadorAcertou) acertos++;
                    }else if(opcao == 2){
                        modoDeJogo.passarFlashcard(false);
                    }else if(opcao == 3){
                        modoDeJogo.sortearFlashcard(jogadorAcertou);
                    }else if(opcao == 4){
                        modoDeJogo.virarFlashcard();
                    }else{
                        TextoJogoMenu.imprimirOpcaoInvalida();
                    }
                }while(opcao != 0);
            }else if(opcao == 2){// seleciona o modo de dois jogadores
                ControleDoisJogadores modoDeJogo = new ControleDoisJogadores(cards);
            }else TextoJogoMenu.imprimirOpcaoInvalida();
        }while(opcao != 0);
    }
}
