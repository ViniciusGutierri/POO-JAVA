/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controllers;

import br.com.fatec.Cliente;
import br.com.fatec.Consulta;
import br.com.fatec.Estoque;
import br.com.fatec.Fornecedor;
import br.com.fatec.Funcionario;
import br.com.fatec.Pedido;
import br.com.fatec.Pizza;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class ViewMenuController implements Initializable {

    @FXML
    private Button btnCadastrarCli;
    @FXML
    private Button btnCadastrarFunc;
    @FXML
    private Button btnCadastrarForn;
    @FXML
    private Button btnCadastrarSabor;
    @FXML
    private Button btnCadastrarPedido;
    @FXML
    private Button btnCollections;
    @FXML
    private Button btnConsulta;
    
    private Stage tela = new Stage();
    @FXML
    private Button btnSair;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnCadastrarCli_Click(ActionEvent event) throws Exception {
        Cliente cli = new Cliente();
        cli.start(new Stage());
    }

    @FXML
    private void btnCadastrarFunc_Click(ActionEvent event) throws Exception {
        Funcionario func = new Funcionario();
        func.start(new Stage());
    }

    @FXML
    private void btnCadastrarForn_Click(ActionEvent event) throws Exception {
        Fornecedor forn = new Fornecedor();
        forn.start(new Stage());
    }

    @FXML
    private void btnCadastrarSabor_Click(ActionEvent event) throws Exception {
        Pizza pizza = new Pizza();
        pizza.start(new Stage());
    }

    @FXML
    private void btnCadastrarPedido_Click(ActionEvent event) throws Exception {
        Pedido ped = new Pedido();
        ped.start(new Stage());
    }

    @FXML
    private void btnCollections_Click(ActionEvent event) throws Exception {
        Estoque est = new Estoque();
        est.start(new Stage());
    }

    @FXML
    private void btnConsulta_Click(ActionEvent event) throws Exception {
        Consulta cons = new Consulta();
        cons.start(new Stage());
    }

    @FXML
    private void btnSair_Click(ActionEvent event) throws Exception {
        System.exit(0);
    }
    
    
    
}
