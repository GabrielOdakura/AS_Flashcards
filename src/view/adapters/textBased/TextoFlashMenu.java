package view.adapters.textBased;

public class TextoFlashMenu {
    public static void imprimirMenu(){
        System.out.println("\nEscolha uma opção:\n1 - Salvar Flashcard\n2 - Carregar Flashcard\n" +
                "3 - Remover Flashcard\n0 - Sair Deste Menu\nOpção Escolhida: ");
    }

    public static void imprimirErroDeEntrada(){
        System.out.println("\nEntrada Inválida! Digite apenas um dígito!\n");
    }

    public static void imprimirSalvarNovoFlashcard(int indice){
        if(indice == 0){
            System.out.println("Digite a pergunta: ");
        }else if(indice == 1){
            System.out.println("Digite a resposta: ");
        }else if(indice == 2){
            System.out.println("Digite se ela estará habilitada de padrão: ");
        }else if(indice == 3){
            System.out.println("Digite um link para uma imagem(deixe em branco caso não queira adicionar): ");
        }
    }

    public static void imprimirSolicitarNomeArquivo() {
        System.out.println("Digite o nome do arquivo: ");
    }

    public static void imprimirOpcaoInvalida() {
        System.out.println("Opção Inválida, tente novamente!");
    }
}
