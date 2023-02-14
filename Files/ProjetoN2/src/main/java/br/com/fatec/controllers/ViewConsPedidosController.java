/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controllers;

import br.com.fatec.DAO.PedidoDAO;
import br.com.fatec.model.Pedido;
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
public class ViewConsPedidosController implements Initializable {

    @FXML
    private TableView<Pedido> tabPedido;
    @FXML
    private TableColumn<Pedido, Integer> colID;
    @FXML
    private TableColumn<Pedido, String> colCPF;
    @FXML
    private TableColumn<Pedido, String> colCEP;
    @FXML
    private TableColumn<Pedido, String> colNum;
    @FXML
    private TableColumn<Pedido, String> colComplemento;
    @FXML
    private TableColumn<Pedido, Integer> colMatricula;
    @FXML
    private TableColumn<Pedido, String> colSabor;
    @FXML
    private TableColumn<Pedido, String> colDescricao;
    @FXML
    private TableColumn<Pedido, Float> colVal;
    @FXML
    private TableColumn<Pedido, Integer> colQtde;
    @FXML
    private TableColumn<Pedido, Float> colTotal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colID.setCellValueFactory(
                new PropertyValueFactory<>("id_pedido"));
        colCPF.setCellValueFactory(
                new PropertyValueFactory<>("cpf_cli"));
        colCEP.setCellValueFactory(
                new PropertyValueFactory<>("cep"));
        colNum.setCellValueFactory(
                new PropertyValueFactory<>("numero"));
        colComplemento.setCellValueFactory(
                new PropertyValueFactory<>("comp"));
        colMatricula.setCellValueFactory(
                new PropertyValueFactory<>("id_func"));
        colSabor.setCellValueFactory(
                new PropertyValueFactory<>("sabor"));
        colDescricao.setCellValueFactory(
                new PropertyValueFactory<>("descricao"));
        colVal.setCellValueFactory(
                new PropertyValueFactory<>("valorUnit"));
        colQtde.setCellValueFactory(
                new PropertyValueFactory<>("qtde"));
        colTotal.setCellValueFactory(
                new PropertyValueFactory<>("valorTotal"));
        
        tabPedido.setItems(preencheTabela());
    }   
    
    private ObservableList<Pedido> preencheTabela() {
        PedidoDAO dao = new PedidoDAO();
        
        ObservableList<Pedido> pedidos
            = FXCollections.observableArrayList();
        
        try {
            //busca somente que termina com 'a'
            //proprietarios.addAll(dao.lista("nome like '%a'"));
            
            pedidos.addAll(dao.lista(""));
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR,
                    "Erro Preenche Tabela: " + ex.getMessage(),
                    ButtonType.OK);
            alerta.showAndWait();
        }
        return pedidos;
    }
    
}
