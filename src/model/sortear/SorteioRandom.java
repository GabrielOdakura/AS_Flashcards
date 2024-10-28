package model.sortear;

import interfaces.InterfaceSortear;
import model.tipos.Flashcards;
import model.tipos.Flashcard;

import java.util.Random;

public class SorteioRandom implements InterfaceSortear {
    private int ultimoNumero;
    @Override
    public Flashcard sortear(Flashcards cards, boolean acertou, boolean jogador){
        int numSorteado = 0;
        Random random = new Random();
        do {
            numSorteado = random.nextInt(0, (cards.getNumeroDeCartas() - 1));
        }while(ultimoNumero == numSorteado);
        ultimoNumero = numSorteado;
        return cards.getCard(numSorteado);
    }
}
