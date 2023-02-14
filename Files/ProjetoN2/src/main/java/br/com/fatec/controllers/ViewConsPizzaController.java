/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controllers;

import br.com.fatec.DAO.PizzaDAO;
import br.com.fatec.model.Pizza;
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
public class ViewConsPizzaController implements Initializable {

    @FXML
    private TableView<Pizza> tabPizza;
    @FXML
    private TableColumn<Pizza, Integer> colID;
    @FXML
    private TableColumn<Pizza, String> colSabor;
    @FXML
    private TableColumn<Pizza, String> colDescricao;
    @FXML
    private TableColumn<Pizza, String> colTam;
    @FXML
    private TableColumn<Pizza, Float> colValor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colID.setCellValueFactory(
                new PropertyValueFactory<>("id_pizza"));
        colSabor.setCellValueFactory(
                new PropertyValueFactory<>("sabor"));
        colDescricao.setCellValueFactory(
                new PropertyValueFactory<>("descricao"));
        colTam.setCellValueFactory(
                new PropertyValueFactory<>("tamanho"));
        colValor.setCellValueFactory(
                new PropertyValueFactory<>("valor"));
        
        tabPizza.setItems(preencheTabela());
    }    
    
    private ObservableList<Pizza> preencheTabela() {
        PizzaDAO dao = new PizzaDAO();
        
        ObservableList<Pizza> pizzas
            = FXCollections.observableArrayList();
        
        try {
            //busca somente que termina com 'a'
            //proprietarios.addAll(dao.lista("nome like '%a'"));
            
            pizzas.addAll(dao.lista(""));
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR,
                    "Erro Preenche Tabela: " + ex.getMessage(),
                    ButtonType.OK);
            alerta.showAndWait();
        }
        return pizzas;
    }
    
}
