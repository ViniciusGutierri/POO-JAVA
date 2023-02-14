/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controllers;

import br.com.fatec.DAO.FuncionarioDAO;
import br.com.fatec.model.Funcionario;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ricardinojr
 */
public class ViewConsFuncController implements Initializable {

    @FXML
    private TableView<Funcionario> tabFuncionario;
    @FXML
    private TableColumn<Funcionario, Integer> colMatricula;
    @FXML
    private TableColumn<Funcionario, String> colCPF;
    @FXML
    private TableColumn<Funcionario, String> colNome;
    @FXML
    private TableColumn<Funcionario, String> colCargo;
    @FXML
    private TableColumn<Funcionario, String> colCelular;
    @FXML
    private TableColumn<Funcionario, String> colDataNasc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colMatricula.setCellValueFactory(
                new PropertyValueFactory<>("id_func"));
        colCPF.setCellValueFactory(
                new PropertyValueFactory<>("cpf"));
        colNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        colCargo.setCellValueFactory(
                new PropertyValueFactory<>("cargo"));
        colCelular.setCellValueFactory(
                new PropertyValueFactory<>("celular"));
        colDataNasc.setCellValueFactory(
                new PropertyValueFactory<>("data_nasc"));
        
        tabFuncionario.setItems(preencheTabela());
    }    
    
    private ObservableList<Funcionario> preencheTabela() {
        FuncionarioDAO dao = new FuncionarioDAO();
        
        ObservableList<Funcionario> funcionarios
            = FXCollections.observableArrayList();
        
        try {
            //busca somente que termina com 'a'
            //proprietarios.addAll(dao.lista("nome like '%a'"));
            
            funcionarios.addAll(dao.lista(""));
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR,
                    "Erro Preenche Tabela: " + ex.getMessage(),
                    ButtonType.OK);
            alerta.showAndWait();
        }
        return funcionarios;
    }
    
}
