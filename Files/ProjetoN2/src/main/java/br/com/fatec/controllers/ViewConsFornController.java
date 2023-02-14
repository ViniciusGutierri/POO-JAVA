/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controllers;

import br.com.fatec.DAO.FornecedorDAO;
import br.com.fatec.model.Fornecedor;
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
public class ViewConsFornController implements Initializable {

    @FXML
    private TableView<Fornecedor> tabFornecedor;
    @FXML
    private TableColumn<Fornecedor, String> colNome;
    @FXML
    private TableColumn<Fornecedor, String> colSede;
    @FXML
    private TableColumn<Fornecedor, String> colProdutos;
    @FXML
    private TableColumn<Fornecedor, Integer> colId_forn;
    @FXML
    private TableColumn<Fornecedor, String> colCnpj;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colId_forn.setCellValueFactory(
                new PropertyValueFactory<>("id_forn"));
        colCnpj.setCellValueFactory(
                new PropertyValueFactory<>("cnpj"));
        colNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        colSede.setCellValueFactory(
                new PropertyValueFactory<>("sede"));
        colProdutos.setCellValueFactory(
                new PropertyValueFactory<>("produtos"));
        
        tabFornecedor.setItems(preencheTabela());
    }    
    
    private ObservableList<Fornecedor> preencheTabela() {
        FornecedorDAO dao = new FornecedorDAO();
        
        ObservableList<Fornecedor> fornecedores
            = FXCollections.observableArrayList();
        
        try {
            //busca somente que termina com 'a'
            //proprietarios.addAll(dao.lista("nome like '%a'"));
            
            fornecedores.addAll(dao.lista(""));
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR,
                    "Erro Preenche Tabela: " + ex.getMessage(),
                    ButtonType.OK);
            alerta.showAndWait();
        }
        return fornecedores;
    }
    
}
