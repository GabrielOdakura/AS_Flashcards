package model.persistencia.adapters;

import interfaces.InterfacePersistencia;
import model.tipos.Flashcards;
import model.tipos.Flashcard;

import org.json.*;

import java.io.*;
import java.util.LinkedList;

public class JSONAdapter implements InterfacePersistencia {


    //abre um arquivo JSON e insere dentro dele um flashcard
    @Override
    public boolean salvarFlashcards(String nomeDoArquivo, String pergunta, String resposta, boolean enabled, String link) {
        LinkedList<Flashcard> list;
        boolean sucesso = false;
        try {
            FileReader reader = new FileReader(nomeDoArquivo + ".json");

            JSONObject jsonObject = new JSONObject(new JSONTokener(reader));

            list = carregarElementos(jsonObject,true);

            // coloca as informações da cartas já carregadas em um array de objects
            JSONObject root = new JSONObject();
            JSONObject cartas;
            JSONArray cartasArray = new JSONArray();
            Flashcard FlashcardAtual;
            for (int i = 0; i < list.size(); i++){
                FlashcardAtual = list.get(i);
                cartas = new JSONObject();
                cartas.put("pergunta", FlashcardAtual.getPergunta());
                cartas.put("resposta", FlashcardAtual.getResposta());
                cartas.put("enabled", FlashcardAtual.isEnabled());
                cartas.put("link", FlashcardAtual.getLink());
                cartasArray.put(cartas);
            }

            //colocando a carta inserida pelo usuário
            cartas = new JSONObject();
            cartas.put("pergunta", pergunta);
            cartas.put("resposta", resposta);
            cartas.put("enabled", enabled);
            cartas.put("link", link);
            cartasArray.put(cartas);

            //colocando dentro da root do arquivo
            root.put("cartas", cartasArray);

            FileWriter writer = new FileWriter((nomeDoArquivo + ".json"));
            writer.write(root.toString(4));
            writer.close();
            System.out.println("Arquivo Salvo!");
            sucesso = true;

            //finalizar
        }catch (FileNotFoundException e){
            System.out.println("Arquivo Não Encontrado! Criando um arquivo novo!");

            try {
                JSONObject root = new JSONObject();
                JSONObject carta = new JSONObject();
                JSONArray cartasArray = new JSONArray();

                carta.put("pergunta", pergunta);
                carta.put("resposta", resposta);
                carta.put("enabled", enabled);
                carta.put("link", link);

                cartasArray.put(carta);
                root.put("cartas", cartasArray);

                FileWriter writer = new FileWriter(nomeDoArquivo + ".json");
                writer.write(root.toString(4));
                writer.close();
                System.out.println("Arquivo criado com sucesso!");
                sucesso = true;
            }catch (IOException ex){
                System.out.println("Arquivo não pode ser criado/lido!");
            }
        }catch(IOException e){
            System.out.println("Arquivo não pode ser criado/lido!");
        }catch(JSONException e){
            System.out.println("Arquivo não pode ser lido! (Formatação Errada)");
        }
        return sucesso;
    }

    @Override
    public LinkedList<Flashcard> carregarFlashcards(String nomeDoArquivo) {
        LinkedList<Flashcard> list = null;
        try {
            //Le o arquivo JSON
            FileReader reader = new FileReader(nomeDoArquivo + ".json");

            // Criar um objeto JSON a partir do arquivo
            JSONObject jsonObject = new JSONObject(new JSONTokener(reader));

            list = carregarElementos(jsonObject,false);


        }catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado! Tente novamente!\n");
        }
        return list;
    }

    //remove logicamente um flashcard, colocando Enabled como false
    @Override
    public void removerFlashCards(String nomeDoArquivo, int id) {
        LinkedList<Flashcard> list;
        try{
            FileReader reader = new FileReader(nomeDoArquivo + ".json");

            JSONObject jsonObject = new JSONObject(new JSONTokener(reader));

            list = carregarParaRemover(jsonObject);

            reader.close();

            if(!list.isEmpty()) {
                Flashcard card = list.get(id);
                if (card.isEnabled()) card.setEnabled(false);
                else card.setEnabled(true);

                // coloca as informações da cartas já carregadas em um array de objects
                JSONObject root = new JSONObject();
                JSONObject cartas;
                JSONArray cartasArray = new JSONArray();
                Flashcard FlashcardAtual;
                for (int i = 0; i < list.size(); i++) {
                    FlashcardAtual = list.get(i);
                    cartas = new JSONObject();
                    cartas.put("pergunta", FlashcardAtual.getPergunta());
                    cartas.put("resposta", FlashcardAtual.getResposta());
                    cartas.put("enabled", FlashcardAtual.isEnabled());
                    cartas.put("link", FlashcardAtual.getLink());
                    cartasArray.put(cartas);
                }

                //colocando dentro da root do arquivo
                root.put("cartas", cartasArray);

                FileWriter writer = new FileWriter((nomeDoArquivo + ".json"));
                writer.write(root.toString(4));
                writer.close();
            }
        }catch (FileNotFoundException e){
            System.out.println("Arquivo inexistente/nome errado!");
        }catch(IOException e){
            System.out.println("Não foi possível criar o arquivo atualizado!");
        }
    }

    @Override
    public boolean salvarPacoteBase(Flashcards cartas) {
        boolean sucesso = false, enabled;
        String pergunta, resposta, link;
        int contador = 0;

            try {
                JSONObject root = new JSONObject();
                JSONArray cartasArray = new JSONArray();
                do {
                    pergunta = cartas.getCard(contador).getPergunta();
                    resposta = cartas.getCard(contador).getResposta();
                    enabled = cartas.getCard(contador).isEnabled();
                    link = cartas.getCard(contador).getLink();
                    JSONObject carta = new JSONObject();

                    carta.put("pergunta", pergunta);
                    carta.put("resposta", resposta);
                    carta.put("enabled", enabled);
                    carta.put("link", link);

                    cartasArray.put(carta);
                    contador++;
                }while(contador != cartas.getNumeroDeCartas());
                root.put("cartas", cartasArray);

                FileWriter writer = new FileWriter("PacoteBase.json");
                writer.write(root.toString(4));
                writer.close();
                System.out.println("Arquivo criado com sucesso!");
                sucesso = true;
            } catch (IOException ex) {
                System.out.println("Arquivo não pode ser criado/lido!");
            }
            contador++;
        return sucesso;
    }



    /*=============métodos private para ajudar em códigos que são utilizados em mais de um lugar============*/

    private LinkedList<Flashcard> carregarElementos(JSONObject jsonObject, boolean bypass){
        LinkedList<Flashcard> list = new LinkedList<Flashcard>();

        if(!jsonObject.isEmpty()){//verifica se não é um arquivo vazio
            JSONArray arrayCartas = jsonObject.getJSONArray("cartas");
            if(!arrayCartas.isEmpty()){
                String pergunta = "", resposta = "", link = "";
                for(int i = 0; i < arrayCartas.length(); i++) {//loop para pegar carta por carta e transf em um Flashcard
                    JSONObject carta = arrayCartas.getJSONObject(i);
                    boolean enabled = carta.getBoolean("enabled");
                    if(bypass) enabled = true;
                    if(enabled){
                        pergunta = carta.getString("pergunta");
                        resposta = carta.getString("resposta");
                        link = carta.getString("link");
                        enabled = carta.getBoolean("enabled");
                        Flashcard novoFlashcard = new Flashcard(pergunta,resposta,enabled,link);
                        list.add(novoFlashcard);
                    }
                }
                System.out.println("Arquivo Carregado com Sucesso!");
            }
        }else{
            System.out.println("Arquivo vazio!");
        }
        return list;
    }

    private LinkedList<Flashcard> carregarParaRemover(JSONObject jsonObject){
        LinkedList<Flashcard> list = new LinkedList<Flashcard>();

        if(!jsonObject.isEmpty()){//verifica se não é um arquivo vazio
            JSONArray arrayCartas = jsonObject.getJSONArray("cartas");
            if(!arrayCartas.isEmpty()){
                String pergunta = "", resposta = "", link = "";

                for(int i = 0; i < arrayCartas.length(); i++) {//loop para pegar carta por carta e transf em um Flashcard
                    JSONObject carta = arrayCartas.getJSONObject(i);
                    boolean enabled = carta.getBoolean("enabled");
                    pergunta = carta.getString("pergunta");
                    resposta = carta.getString("resposta");
                    link = carta.getString("link");
                    Flashcard novoFlashcard = new Flashcard(pergunta,resposta,enabled,link);
                    list.add(novoFlashcard);
                }
            }
        }else{
            System.out.println("Arquivo vazio!");
        }
        return list;
    }
}
