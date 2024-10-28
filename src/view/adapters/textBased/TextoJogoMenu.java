package view.adapters.textBased;

import model.tipos.Flashcard;

public class TextoJogoMenu {
    private static String bordaCimaBaixo = "--------------------";
    private static String bordaLateralEsq = "|         ";
    private static String bordaLateralDir = "         |";
    public static void imprimirMenu(){
        System.out.println("\nEscolha uma opção:\n1 - Um Jogador\n2 - Dois Jogadores\n" +
                "0 - Sair Deste Menu\nOpção Escolhida: ");
    }

    public static void imprimirOpcaoInvalida() {
        System.out.println("Opção Inválida, tente novamente!");
    }
    public static void imprimirPerguntaCartaAtual(Flashcard carta){
        String bordaCimaBaixoLocal = bordaCimaBaixo;
        int tamanhoPergunta = carta.getPergunta().length();
        for(int i = 0; i < tamanhoPergunta; i++){
            bordaCimaBaixoLocal += "-";
        }
        System.out.println(bordaCimaBaixoLocal);
        imprimirLinhaVazia(tamanhoPergunta);
        imprimirLinhaVazia(tamanhoPergunta);
        System.out.println(bordaLateralEsq + carta.getPergunta() + bordaLateralDir);
        imprimirLinhaVazia(tamanhoPergunta);
        imprimirLinhaVazia(tamanhoPergunta);
        System.out.println(bordaCimaBaixoLocal);
    }

    public static void imprimirRespostaCartaAtual(Flashcard carta){
        String bordaCimaBaixoLocal = bordaCimaBaixo;
        int tamanhoPergunta = carta.getResposta().length();
        for(int i = 0; i < tamanhoPergunta; i++){
            bordaCimaBaixoLocal += "-";
        }
        System.out.println(bordaCimaBaixoLocal);
        imprimirLinhaVazia(tamanhoPergunta);
        imprimirLinhaVazia(tamanhoPergunta);
        System.out.println(bordaLateralEsq + carta.getResposta() + bordaLateralDir);
        imprimirLinhaVazia(tamanhoPergunta);
        imprimirLinhaVazia(tamanhoPergunta);
        System.out.println(bordaCimaBaixoLocal);
    }

    public static void imprimirAnimacaoCartaAtual(Flashcard carta){
        String bordaCimaBaixoLocal = bordaCimaBaixo;
        int tamanhoPergunta = carta.getPergunta().length();
        for(int i = 0; i < tamanhoPergunta; i++){
            bordaCimaBaixoLocal += "-";
        }
        System.out.println(bordaCimaBaixoLocal);
        imprimirLinhaVazia(tamanhoPergunta);
        imprimirLinhaVazia(tamanhoPergunta);
        System.out.println(bordaLateralEsq + carta.getPergunta()
                .replaceAll(".", "*") + bordaLateralDir);
        imprimirLinhaVazia(tamanhoPergunta);
        imprimirLinhaVazia(tamanhoPergunta);
        System.out.println(bordaCimaBaixoLocal);
    }



    private static void imprimirLinhaVazia(int tamanhoPergunta){
        System.out.print(bordaLateralEsq);
        for (int i = 0; i < tamanhoPergunta; i++){
            System.out.print(" ");
        }
        System.out.println(bordaLateralDir);
    }
}
