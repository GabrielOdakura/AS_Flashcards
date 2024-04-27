package model.tipos;

public class Flashcard {
    private String pergunta;
    private String resposta;
    private boolean enabled;
    private String link;

    public Flashcard(String pergunta,String resposta,boolean enabled, String link){
        this.setPergunta(pergunta);
        this.setResposta(resposta);
        this.setEnabled(enabled);
        this.setLink(link);
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
