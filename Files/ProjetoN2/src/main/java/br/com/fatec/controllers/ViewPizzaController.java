/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controllers;

import br.com.fatec.DAO.PizzaDAO;
import br.com.fatec.model.Pizza;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Vinicim
 */
public class ViewPizzaController implements Initializable {

    @FXML
    private Label lblSabor;
    @FXML
    private TextField txtSabor;
    @FXML
    private Label lblDescricao;
    @FXML
    private TextArea txtDescricao;
    @FXML
    private Label lblTam;
    @FXML
    private TextField txtTam;
    @FXML
    private Label lblValor;
    @FXML
    private TextField txtValor;
    @FXML
    private Button btnCadastrar;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnPesquisar;
    
    private Pizza pizza;
    private PizzaDAO dao = new PizzaDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        habilitaInclusao();
        
        txtSabor.focusedProperty().addListener(new ChangeListener<Boolean>() {
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
        pizza = new Pizza();
        pizza.setSabor(txtSabor.getText().toLowerCase());
        pizza.setDescricao(txtDescricao.getText());
        pizza.setTamanho(txtTam.getText());
        pizza.setValor(Float.parseFloat(txtValor.getText()));
        
        try {
            if(dao.insere(pizza)) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("SABOR CADASTRADO COM SUCESSO!!!");
                alerta.showAndWait(); //exibe a mensagem
                
                limpaCampos();
                
                txtSabor.requestFocus();
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
            
            txtSabor.requestFocus();
        }
    }

    @FXML
    private void btnAlterar_Click(ActionEvent event) {
        pizza = new Pizza();
        pizza.setSabor(txtSabor.getText().toLowerCase());
        pizza.setDescricao(txtDescricao.getText());
        pizza.setTamanho(txtTam.getText());
        pizza.setValor(Float.parseFloat(txtValor.getText()));
        
        try {
            if(dao.altera(pizza)) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Dados alterados com sucesso!");
                alerta.showAndWait(); //exibe a mensagem
                
                //limpa os campos
                limpaCampos();
                txtSabor.requestFocus();
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
            txtSabor.requestFocus();
        }
    }

    @FXML
    private void btnExcluir_Click(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText("Atenção");
        alerta.setContentText("Deseja remover esse sabor?");
        
        Optional<ButtonType> resultado = alerta.showAndWait();
        
        if(resultado.get() == ButtonType.CANCEL) {
            return;
        }
        
        pizza = new Pizza();
        pizza.setSabor(txtSabor.getText().toLowerCase());
        pizza.setDescricao(txtDescricao.getText());
        pizza.setTamanho(txtTam.getText());
        pizza.setValor(Float.parseFloat(txtValor.getText()));
        
        try {
            if(dao.remove(pizza)) {
                alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Sabor removido com sucesso!");
                alerta.showAndWait(); //exibe a mensagem
                
                //limpa os campos
                limpaCampos();
                txtSabor.requestFocus();
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
            
            txtSabor.requestFocus();
        }
    }

    @FXML
    private void btnPesquisar_Click(ActionEvent event) {
        pizza = new Pizza();
        pizza.setSabor(txtSabor.getText().toLowerCase());
        
        try {
            pizza = dao.buscaID(pizza);
            
            if(pizza != null) {
                txtDescricao.setText(pizza.getDescricao());
                txtTam.setText(pizza.getTamanho());
                txtValor.setText(String.valueOf(pizza.getValor()));
                
                habilitaAlteracaoExclusao();
            }
            else {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Sabor NÃO encontrado!!!");
                alerta.showAndWait(); //exibe a mensagem

                txtSabor.requestFocus();
            }
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensagem");
            alerta.setHeaderText("Erro");
            alerta.setContentText(ex.getMessage());
            
            alerta.showAndWait(); //exibe a mensagem
            
            txtSabor.requestFocus();
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
        txtSabor.setText("");
        txtDescricao.setText("");
        txtTam.setText("");
        txtValor.setText("");
    }
    
}
