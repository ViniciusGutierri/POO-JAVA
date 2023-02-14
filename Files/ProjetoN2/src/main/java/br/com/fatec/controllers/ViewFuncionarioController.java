/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controllers;

import br.com.fatec.DAO.FuncionarioDAO;
import br.com.fatec.model.Funcionario;
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
public class ViewFuncionarioController implements Initializable {

    @FXML
    private Label lblCpf;
    @FXML
    private TextField txtCpf;
    @FXML
    private Label lblNome;
    @FXML
    private TextField txtNome;
    @FXML
    private Label lblCargo;
    @FXML
    private TextField txtCargo;
    @FXML
    private Label lblCelular;
    @FXML
    private TextField txtCelular;
    @FXML
    private Label lblNasc;
    @FXML
    private TextField txtNasc;
    @FXML
    private Button btnCadastrar;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnPesquisar;
    
    private Funcionario funcionario;
    private FuncionarioDAO dao = new FuncionarioDAO();

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
        funcionario = new Funcionario();
        funcionario.setCpf(txtCpf.getText());
        funcionario.setNome(txtNome.getText());
        funcionario.setCargo(txtCargo.getText());
        funcionario.setCelular(txtCelular.getText());
        funcionario.setData_nasc(txtNasc.getText());
        
        try {
            if(dao.insere(funcionario)) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("FUNCIONARIO CADASTRADO COM SUCESSO!!!");
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
        funcionario = new Funcionario();
        funcionario.setCpf(txtCpf.getText());
        funcionario.setNome(txtNome.getText());
        funcionario.setCargo(txtCargo.getText());
        funcionario.setCelular(txtCelular.getText());
        funcionario.setData_nasc(txtNasc.getText());
        
        try {
            if(dao.altera(funcionario)) {
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
        alerta.setContentText("Deseja remover esse funcionário?");
        
        Optional<ButtonType> resultado = alerta.showAndWait();
        
        if(resultado.get() == ButtonType.CANCEL) {
            return;
        }
        
        funcionario = new Funcionario();
        funcionario.setCpf(txtCpf.getText());
        funcionario.setNome(txtNome.getText());
        funcionario.setCargo(txtCargo.getText());
        funcionario.setCelular(txtCelular.getText());
        funcionario.setData_nasc(txtNasc.getText());
        
        try {
            if(dao.remove(funcionario)) {
                alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Funcionário removido com sucesso!");
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
        funcionario = new Funcionario();
        funcionario.setCpf(txtCpf.getText());
        
        try {
            funcionario = dao.buscaID(funcionario);
            
            if(funcionario != null) {
                txtNome.setText(funcionario.getNome());
                txtCargo.setText(funcionario.getCargo());
                txtCelular.setText(funcionario.getCelular());
                txtNasc.setText(funcionario.getData_nasc());
                
                habilitaAlteracaoExclusao();
            }
            else {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Funcionario NÃO encontrado!!!");
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
        txtCargo.setText("");
        txtCelular.setText("");
        txtNasc.setText("");
    }
}
