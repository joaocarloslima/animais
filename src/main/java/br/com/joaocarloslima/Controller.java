package br.com.joaocarloslima;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable {

    @FXML private TableView<Avistamento> table;
    @FXML private TableColumn<Avistamento, Integer> colMes;
    @FXML private TableColumn<Avistamento, String> colAnimal;
    @FXML private TableColumn<Avistamento, Integer> colQuantidade;
    @FXML private TableColumn<Avistamento, String> colPesquisador;

    @FXML private MenuItem menuQ1;
    @FXML private MenuItem menuQ2;
    @FXML private MenuItem menuQ3;

    @FXML private TextField txtAnimal;
    @FXML private TextField txtPesquisador;
    @FXML private TextField txtMes;

    @FXML private Label lblElefante;
    @FXML private Label lblGirafa;
    @FXML private Label lblMacaco;
    @FXML private Label lblAna;
    @FXML private Label lblBob;
    @FXML private Label lblStatus;

    @FXML private Button btnLimpar;

    private Dataset dataset;

    public void filtrarPorAnimal(){
        var data = dataset.filtrarAvistamentosPorAnimal(txtAnimal.getText());
        atualizarStatus(data);
    }

    public void filtrarPorPesquisador(){
        var data = dataset.filtrarAvistamentosPorPesquisador(txtPesquisador.getText());
        atualizarStatus(data);
    }

    public void filtrarPorMes(){
        var data = dataset.filtrarAvistamentosPorMes(Integer.parseInt(txtMes.getText()));
        atualizarStatus(data);
    }
    
    private void atualizarStatus(List<Avistamento> data) {
        table.getItems().clear();
        table.getItems().addAll(data);
        lblStatus.setText("Mostrando " + table.getItems().size() + " avistamentos. Total de " + dataset.getTotalFiltrado() + " animais.");
        lblElefante.setText(dataset.getQtdePorAnimal("Elefante", data) + "");
        lblGirafa.setText(dataset.getQtdePorAnimal("Girafa", data) + "");
        lblMacaco.setText(dataset.getQtdePorAnimal("Macaco", data) + "");
        lblAna.setText(dataset.getQtdePorPesquisador("Ana", data) + "");
        lblBob.setText(dataset.getQtdePorPesquisador("Bob", data) + "");
    }

    public void limparFiltros(){
        txtAnimal.clear();
        txtPesquisador.clear();
        txtMes.clear();
        table.getItems().clear();
        var data = dataset.getAvistamentos();
        table.getItems().addAll(data);
        atualizarStatus(data);
    }

    public void responderQ1(){
        mostrarMensagem("Q1", "Total de elefantes avistados pelo Bob em Fevereiro: ", dataset.responderQ1());
    }
    
    public void responderQ2(){
        mostrarMensagem("Q2", "Total de animais avistados pela Ana no primeiro trimestre: ", dataset.responderQ2());
    }

    public void responderQ3(){
        mostrarMensagem("Q3", "Total de macacos e elefantes avistados pela Ana em Julho: ", dataset.responderQ3());
    }


    private void mostrarMensagem(String titulo, String questao, int valor) {
        var alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(questao);
        alert.setContentText(valor + "");
        alert.showAndWait();
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colMes.setCellValueFactory(new PropertyValueFactory<>("mes"));
        colAnimal.setCellValueFactory(new PropertyValueFactory<>("animal"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colPesquisador.setCellValueFactory(new PropertyValueFactory<>("pesquisador"));
        
        try{
            String path = App.class.getResource("dados.csv").getPath();
            dataset = new Dataset(path);
            var data = dataset.getAvistamentos();
            table.getItems().addAll(data);
            atualizarStatus(data);
        }catch(Exception e){
            System.out.println("Erro ao carregar dataset. " + e.getMessage());
        }
    }

}
