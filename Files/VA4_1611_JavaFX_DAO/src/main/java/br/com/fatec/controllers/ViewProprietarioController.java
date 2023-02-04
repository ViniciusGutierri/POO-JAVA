/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controllers;

import br.com.fatec.DAO.ProprietarioDAO;
import br.com.fatec.model.Proprietario;
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
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class ViewProprietarioController implements Initializable {

    @FXML
    private Label lblCodigo;
    @FXML
    private TextField txtCodigo;
    @FXML
    private Label lblNome;
    @FXML
    private TextField txtNome;
    @FXML
    private HBox hboxBotoes;
    @FXML
    private Button btnIncluir;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnSair;
    @FXML
    private Button btnPesquisar;
    
    //variaveis auxiliares
    private Proprietario proprietario;
    private ProprietarioDAO dao = new ProprietarioDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        habilitaInclusao(); //faz a tela ser de inclusao
    
        //Programa o evento de ganhar o foco
        // no txtCodigo
        txtCodigo.focusedProperty().addListener(new ChangeListener<Boolean>() {
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
    private void btnIncluir_Click(ActionEvent event) {
        proprietario = new Proprietario();
        proprietario.setCodProprietario(Integer.parseInt(txtCodigo.getText()));
        proprietario.setNome(txtNome.getText());
        
        try {
            if(dao.insere(proprietario)) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Dados incluidos com sucesso!");
                alerta.showAndWait(); //exibe a mensagem
                
                //limpa os campos
                txtCodigo.setText("");
                txtNome.setText("");
                
                txtCodigo.requestFocus();
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
            txtCodigo.requestFocus();
        }
    }   

    @FXML
    private void btnAlterar_Click(ActionEvent event) {
        //joga os dados da tela para o objeto
        proprietario = new Proprietario();
        proprietario.setCodProprietario(Integer.parseInt(txtCodigo.getText()));
        proprietario.setNome(txtNome.getText());
        
        try {
            if(dao.altera(proprietario)) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Dados alterados com sucesso!");
                alerta.showAndWait(); //exibe a mensagem
                
                //limpa os campos
                limpaCampos();
                txtCodigo.requestFocus();
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
            txtCodigo.requestFocus();
        }
    }

    @FXML
    private void btnExcluir_Click(ActionEvent event) {
        
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText("Atenção");
        alerta.setContentText("Deseja remover esse proprietario?");
        
        Optional<ButtonType> resultado = alerta.showAndWait();
        
        if(resultado.get() == ButtonType.CANCEL) {
            return;
        }
            
        proprietario = new Proprietario();
        proprietario.setCodProprietario(Integer.parseInt(txtCodigo.getText()));
        proprietario.setNome(txtNome.getText());
        
        try {
            if(dao.remove(proprietario)) {
                alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Proprietario removido com sucesso!");
                alerta.showAndWait(); //exibe a mensagem
                
                //limpa os campos
                limpaCampos();
                txtCodigo.requestFocus();
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
            
            txtCodigo.requestFocus();
        }
    }

    @FXML
    private void btnSair_Click(ActionEvent event) {
    }

    @FXML
    private void btnPesquisar_Click(ActionEvent event) {
        proprietario = new Proprietario();
        proprietario.setCodProprietario(Integer.parseInt(txtCodigo.getText()));
        
        try {
            proprietario = dao.buscaID(proprietario);
            
            //verifica se achou
            if(proprietario != null) { //achou
                //move os dados para a tela
                txtNome.setText(proprietario.getNome());
                //faz a tela alterar ou excluir
                habilitaAlteracaoExclusao();
            }
            else {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Proprietario não encontrado!");
                alerta.showAndWait(); //exibe a mensagem

                txtCodigo.requestFocus();
            }
            
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensagem");
            alerta.setHeaderText("Erro");
            alerta.setContentText(ex.getMessage());
            
            alerta.showAndWait(); //exibe a mensagem
            
            //manda o foco para o código
            txtCodigo.requestFocus();
        }
    }
    
    
    private void habilitaInclusao() {
        btnIncluir.setDisable(false);
        btnExcluir.setDisable(true);
        btnAlterar.setDisable(true);
    }
    
    private void habilitaAlteracaoExclusao() {
        btnIncluir.setDisable(true);
        btnExcluir.setDisable(false);
        btnAlterar.setDisable(false);
    }
    
    private void limpaCampos() {
        txtCodigo.setText("");
        txtNome.setText("");
    }
    
}
