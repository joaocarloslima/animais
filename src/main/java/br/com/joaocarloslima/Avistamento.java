package br.com.joaocarloslima;

public class Avistamento {

    private int mes;
    private String animal;
    private int quantidade;
    private String pesquisador;

    public Avistamento(int mes, String animal, int quantidade, String pesquisador) {
        this.mes = mes;
        this.animal = animal;
        this.quantidade = quantidade;
        this.pesquisador = pesquisador;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getPesquisador() {
        return pesquisador;
    }

    public void setPesquisador(String pesquisador) {
        this.pesquisador = pesquisador;
    }

}
