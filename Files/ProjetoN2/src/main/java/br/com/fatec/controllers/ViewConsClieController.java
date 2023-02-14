/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controllers;

import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.model.Cliente;
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
public class ViewConsClieController implements Initializable {
    @FXML
    private TableView<Cliente> tabCliente;
    @FXML
    private TableColumn<Cliente, String> colCPF;
    @FXML
    private TableColumn<Cliente, String> colNome;
    @FXML
    private TableColumn<Cliente, String> colCelular;
    @FXML
    private TableColumn<Cliente, String> colCEP;
    @FXML
    private TableColumn<Cliente, String> colBairro;
    @FXML
    private TableColumn<Cliente, String> colRua;
    @FXML
    private TableColumn<Cliente, String> colNum;
    @FXML
    private TableColumn<Cliente, String> colComplemento;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colCPF.setCellValueFactory(
                new PropertyValueFactory<>("cpf_cli"));
        colNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        colCelular.setCellValueFactory(
                new PropertyValueFactory<>("celular"));
        colCEP.setCellValueFactory(
                new PropertyValueFactory<>("cep"));
        colBairro.setCellValueFactory(
                new PropertyValueFactory<>("bairro"));
        colRua.setCellValueFactory(
                new PropertyValueFactory<>("rua"));
        colNum.setCellValueFactory(
                new PropertyValueFactory<>("numero"));
        colComplemento.setCellValueFactory(
                new PropertyValueFactory<>("comp"));
        
        tabCliente.setItems(preencheTabela());
    }    
    
    private ObservableList<Cliente> preencheTabela() {
        ClienteDAO dao = new ClienteDAO();
        
        ObservableList<Cliente> clientes
            = FXCollections.observableArrayList();
        
        try {
            //busca somente que termina com 'a'
            //proprietarios.addAll(dao.lista("nome like '%a'"));
            
            clientes.addAll(dao.lista(""));
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR,
                    "Erro Preenche Tabela: " + ex.getMessage(),
                    ButtonType.OK);
            alerta.showAndWait();
        }
        return clientes;
    }
}