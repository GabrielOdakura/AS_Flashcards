package model.persistencia;

import model.Flashcards;
import model.tipos.Flashcard;

import java.util.LinkedList;

public class PacoteCartasBasico {
    public Flashcards gerarPacoteBase(){
        LinkedList<Flashcard> cartas = new LinkedList<>();
        cartas.add(new Flashcard("Qual a capital da Rússia?", "Moscou", true, ""));
        cartas.add(new Flashcard("Qual a capital do Afeganistão?", "Cabul", true, ""));
        cartas.add(new Flashcard("Qual a capital da Alemanha?", "Berlim", true, ""));
        cartas.add(new Flashcard("Qual a capital da Bélgica?", "Bruxelas", true, ""));
        cartas.add(new Flashcard("Qual a capital da Coria do Sul?", "Seul", true, ""));
        cartas.add(new Flashcard("Qual a capital da Egito?", "Cairo", true, ""));
        cartas.add(new Flashcard("Qual a capital da Espanha?", "Madri", true, ""));
        cartas.add(new Flashcard("Qual a capital da China?", "Pequim", true, ""));
        cartas.add(new Flashcard("Qual a capital do Brasil?", "Brasília", true, ""));
        cartas.add(new Flashcard("Qual a capital da França?", "Paris", true, ""));
        cartas.add(new Flashcard("Qual a capital da Grécia?", "Atenas", true, ""));
        cartas.add(new Flashcard("Qual a capital da Suíça?", "Berna", true, ""));
        cartas.add(new Flashcard("Qual a capital da Tailândia?", "Bangkok", true, ""));
        return new Flashcards(cartas);
    }
}
