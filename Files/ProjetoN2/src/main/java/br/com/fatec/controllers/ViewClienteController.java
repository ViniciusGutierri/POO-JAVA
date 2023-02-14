/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controllers;

import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.model.Cliente;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Vinicim
 */
public class ViewClienteController implements Initializable {

    @FXML
    private Label lblCpf;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblCelular;
    @FXML
    private Label lblCep;
    @FXML
    private Label lblBairro;
    @FXML
    private Label lblRua;
    @FXML
    private Label lblNumero;
    @FXML
    private Label lblComp;
    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCelular;
    @FXML
    private TextField txtCep;
    @FXML
    private TextField txtBairro;
    @FXML
    private TextField txtRua;
    @FXML
    private TextField txtNumero;
    @FXML
    private TextField txtComp;
    @FXML
    private Button btnCadastrar;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnPesquisar;
    
    
    private Cliente cliente;
    private ClienteDAO dao = new ClienteDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        habilitaInclusao();
        
        txtCpf.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, 
                    Boolean oldValue, Boolean newValue) {
                if(newValue) { //ganhou o FOCO
                    limpaCampos();
                    habilitaInclusao();
                }
            }
        });
    }    

    @FXML
    private void btnCadastrar_Click(ActionEvent event) {
        cliente = new Cliente();
        cliente.setCpf_cli(txtCpf.getText());
        cliente.setNome(txtNome.getText());
        cliente.setCelular(txtCelular.getText());
        cliente.setCep(txtCep.getText());
        cliente.setBairro(txtBairro.getText());
        cliente.setRua(txtRua.getText());
        cliente.setNumero(txtNumero.getText());
        cliente.setComp(txtComp.getText());
        
        try {
            if(dao.insere(cliente)) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("CLIENTE CADASTRADO COM SUCESSO!!!");
                alerta.showAndWait(); //exibe a mensagem
                
                limpaCampos();
                
                txtCpf.requestFocus();
            }
            else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Ocorreu algum problema!");
                alerta.showAndWait(); //exibe a mensagem
            }
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensagem");
            alerta.setHeaderText("Erro");
            alerta.setContentText(ex.getMessage());
            
            alerta.showAndWait(); //exibe a mensagem
            
            txtCpf.requestFocus();
        }
    }

    @FXML
    private void btnAlterar_Click(ActionEvent event) {
        cliente = new Cliente();
        cliente.setCpf_cli(txtCpf.getText());
        cliente.setNome(txtNome.getText());
        cliente.setCelular(txtCelular.getText());
        cliente.setCep(txtCep.getText());
        cliente.setBairro(txtBairro.getText());
        cliente.setRua(txtRua.getText());
        cliente.setNumero(txtNumero.getText());
        cliente.setComp(txtComp.getText());
        
        try {
            if(dao.altera(cliente)) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Dados alterados com sucesso!");
                alerta.showAndWait(); //exibe a mensagem
                
                //limpa os campos
                limpaCampos();
                txtCpf.requestFocus();
                habilitaInclusao();
            }
            else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Ocorreu algum problema!");
                alerta.showAndWait(); //exibe a mensagem
            }
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensagem");
            alerta.setHeaderText("Erro");
            alerta.setContentText(ex.getMessage());
            
            alerta.showAndWait(); //exibe a mensagem
            txtCpf.requestFocus();
        }
    }

    @FXML
    private void btnExcluir_Click(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText("Atenção");
        alerta.setContentText("Deseja remover esse cliente?");
        
        Optional<ButtonType> resultado = alerta.showAndWait();
        
        if(resultado.get() == ButtonType.CANCEL) {
            return;
        }
        
        cliente = new Cliente();
        cliente.setCpf_cli(txtCpf.getText());
        cliente.setNome(txtNome.getText());
        cliente.setCelular(txtCelular.getText());
        cliente.setCep(txtCep.getText());
        cliente.setBairro(txtBairro.getText());
        cliente.setRua(txtRua.getText());
        cliente.setNumero(txtNumero.getText());
        cliente.setComp(txtComp.getText());
        
        try {
            if(dao.remove(cliente)) {
                alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Cliente removido com sucesso!");
                alerta.showAndWait(); //exibe a mensagem
                
                //limpa os campos
                limpaCampos();
                txtCpf.requestFocus();
                habilitaInclusao();
            }
            else {
                alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Ocorreu algum problema!");
                alerta.showAndWait(); //exibe a mensagem
            }
        } catch (SQLException ex) {
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensagem");
            alerta.setHeaderText("Atenção");
            alerta.setContentText(ex.getMessage());
            alerta.showAndWait(); //exibe a mensagem
            
            txtCpf.requestFocus();
        }
    }

    @FXML
    private void btnPesquisar_Click(ActionEvent event) {
        cliente = new Cliente();
        cliente.setCpf_cli(txtCpf.getText());
        
        try {
            cliente = dao.buscaID(cliente);
            
            if(cliente != null) {
                txtNome.setText(cliente.getNome());
                txtCelular.setText(cliente.getCelular());
                txtCep.setText(cliente.getCep());
                txtBairro.setText(cliente.getBairro());
                txtRua.setText(cliente.getRua());
                txtNumero.setText(cliente.getNumero());
                txtComp.setText(cliente.getComp());
                
                habilitaAlteracaoExclusao();
            }
            else {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Cliente NÃO encontrado!!!");
                alerta.showAndWait(); //exibe a mensagem

                txtCpf.requestFocus();
            }
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensagem");
            alerta.setHeaderText("Erro");
            alerta.setContentText(ex.getMessage());
            
            alerta.showAndWait(); //exibe a mensagem
            
            txtCpf.requestFocus();
        }
    }
    
    private void habilitaInclusao() {
        btnCadastrar.setDisable(false);
        btnExcluir.setDisable(true);
        btnAlterar.setDisable(true);
    }
    
    private void habilitaAlteracaoExclusao() {
        btnCadastrar.setDisable(true);
        btnExcluir.setDisable(false);
        btnAlterar.setDisable(false);
    }
    
    private void limpaCampos() {
        txtCpf.setText("");
        txtNome.setText("");
        txtCelular.setText("");
        txtCep.setText("");
        txtBairro.setText("");
        txtRua.setText("");
        txtNumero.setText("");
        txtComp.setText("");
    }
}
