package objects;

public class OpcaoInvestimento {

    public String tempo;
    public String valor;

    public OpcaoInvestimento(String tempo, String valor) {
        this.tempo = tempo;
        this.valor = valor;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
