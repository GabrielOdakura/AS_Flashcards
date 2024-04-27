package controller;

public class ModoDeJogo {
    int modoDeJogo;

    public ModoDeJogo(String modo){
        do {
            try {
                modoDeJogo = Integer.parseInt(modo);
            } catch (NumberFormatException e) {
                System.out.println("\n\n0 - sair do programa\n1 - Um Jogador\n2 - Dois Jogadores");
            }
            if(modoDeJogo == 1){
                UmJogador modoAtual = new UmJogador();
            }else if(modoDeJogo == 2){
                DoisJogadores modoAtual = new DoisJogadores();
            }else if(modoDeJogo == 0){
                System.exit(0);
            }
        }while(modoDeJogo != 0);
    }
}
