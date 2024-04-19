package br.com.joaocarloslima;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvException;

public class Dataset {
    
    private List<Avistamento> avistamentos = new ArrayList<>();

    private int totalFiltrado;

    public Dataset(String caminhoArquivo) throws IOException, CsvException {
        Csv.carregarDadosCSV(caminhoArquivo, avistamentos);
    }

    public List<Avistamento> getAvistamentos() {
        return avistamentos;
    }

    public List<Avistamento> filtrarAvistamentosPorAnimal(String animal) {
        return new ArrayList<>();
    }

    public List<Avistamento> filtrarAvistamentosPorPesquisador(String pesquisador) {
        return new ArrayList<>();
    }

    public List<Avistamento> filtrarAvistamentosPorMes(int mes) {
        return new ArrayList<>();
    }


    public int getQtdePorAnimal(String animal, List<Avistamento> avistamentos){
        return 0;
    }

    public int getQtdePorPesquisador(String pesquisador, List<Avistamento> avistamentos){
        return 0;
    }

    public int responderQ1() {
        return 0;
        
    }

    public int responderQ2() {
        return 0;
    }
    

    public int responderQ3() {
        return 0;
    }

    
    public int getTotalFiltrado() {
        return totalFiltrado;
    }
    

}

