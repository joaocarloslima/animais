package br.com.joaocarloslima;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.util.List;  
import java.io.FileReader;
import java.io.IOException;

public class Csv {

    public static void carregarDadosCSV(String caminhoArquivo, List<Avistamento> avistamentos) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(caminhoArquivo))) {
            List<String[]> linhas = reader.readAll();
            for (String[] linha : linhas) {
                if (linha.length == 4) {
                    int mes = Integer.parseInt(linha[0]);
                    String animal = linha[1];
                    int quantidade = Integer.parseInt(linha[2]);
                    String pesquisador = linha[3];
                    Avistamento avistamento = new Avistamento(mes, animal, quantidade, pesquisador);
                    avistamentos.add(avistamento);
                } else {
                    System.out.println("Formato de linha inválido: " + String.join(",", linha));
                }
            }
        }
    }

}
