/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controllers;

import br.com.fatec.ConsCliente;
import br.com.fatec.ConsForn;
import br.com.fatec.ConsFunc;
import br.com.fatec.ConsPedidos;
import br.com.fatec.ConsPizzas;
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
 * @author Vinicim
 */
public class ViewConsultaController implements Initializable {

    @FXML
    private Button btnCliente;
    @FXML
    private Button btnFornecedores;
    @FXML
    private Button btnFuncionarios;
    @FXML
    private Button btnPizzas;
    @FXML
    private Button btnPedidos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnCliente_Click(ActionEvent event) throws Exception {
        ConsCliente consCli = new ConsCliente();
        consCli.start(new Stage());
    }

    @FXML
    private void btnFornecedores_Click(ActionEvent event) throws Exception {
        ConsForn consForn = new ConsForn();
        consForn.start(new Stage());
    }

    @FXML
    private void btnFuncionarios_Click(ActionEvent event) throws Exception {
        ConsFunc consFunc = new ConsFunc();
        consFunc.start(new Stage());
    }

    @FXML
    private void btnPizzas_Click(ActionEvent event) throws Exception {
        ConsPizzas consPizzas = new ConsPizzas();
        consPizzas.start(new Stage());
    }

    @FXML
    private void btnPedidos_Click(ActionEvent event) throws Exception {
        ConsPedidos consPedidos = new ConsPedidos();
        consPedidos.start(new Stage());
    }
    
}
