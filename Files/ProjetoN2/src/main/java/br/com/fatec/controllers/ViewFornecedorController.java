/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controllers;

import br.com.fatec.DAO.FornecedorDAO;
import br.com.fatec.model.Fornecedor;
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
public class ViewFornecedorController implements Initializable {

    @FXML
    private Label lblCnpj;
    @FXML
    private TextField txtCnpj;
    @FXML
    private Label lblNome;
    @FXML
    private TextField txtNome;
    @FXML
    private Label lblSede;
    @FXML
    private TextField txtSede;
    @FXML
    private Label lblProdutos;
    @FXML
    private TextArea txtProdutos;
    @FXML
    private Button btnCadastrar;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnPesquisar;
    
    private Fornecedor fornecedor;
    private FornecedorDAO dao = new FornecedorDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        habilitaInclusao();
        
        txtCnpj.focusedProperty().addListener(new ChangeListener<Boolean>() {
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
        fornecedor = new Fornecedor();
        fornecedor.setCnpj(txtCnpj.getText());
        fornecedor.setNome(txtNome.getText());
        fornecedor.setSede(txtSede.getText());
        fornecedor.setProdutos(txtProdutos.getText());
        
        try {
            if(dao.insere(fornecedor)) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("FORNECEDOR CADASTRADO COM SUCESSO!!!");
                alerta.showAndWait(); //exibe a mensagem
                
                limpaCampos();
                
                txtCnpj.requestFocus();
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
            
            txtCnpj.requestFocus();
        }
    }

    @FXML
    private void btnAlterar_Click(ActionEvent event) {
        fornecedor = new Fornecedor();
        fornecedor.setCnpj(txtCnpj.getText());
        fornecedor.setNome(txtNome.getText());
        fornecedor.setSede(txtSede.getText());
        fornecedor.setProdutos(txtProdutos.getText());
        
        try {
            if(dao.altera(fornecedor)) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Dados alterados com sucesso!");
                alerta.showAndWait(); //exibe a mensagem
                
                limpaCampos();
                
                txtCnpj.requestFocus();
                
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
            
            txtCnpj.requestFocus();
        }
    }

    @FXML
    private void btnExcluir_Click(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText("Atenção");
        alerta.setContentText("Deseja remover esse fornecedor?");
        
        Optional<ButtonType> resultado = alerta.showAndWait();
        
        if(resultado.get() == ButtonType.CANCEL) {
            return;
        }
        
        fornecedor = new Fornecedor();
        fornecedor.setCnpj(txtCnpj.getText());
        fornecedor.setNome(txtNome.getText());
        fornecedor.setSede(txtSede.getText());
        fornecedor.setProdutos(txtProdutos.getText());
        
        try {
            if(dao.remove(fornecedor)) {
                alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Fornecedor removido com sucesso!");
                alerta.showAndWait(); //exibe a mensagem
                
                //limpa os campos
                limpaCampos();
                txtCnpj.requestFocus();
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
            
            txtCnpj.requestFocus();
        }
    }

    @FXML
    private void btnPesquisar_Click(ActionEvent event) {
        fornecedor = new Fornecedor();
        fornecedor.setCnpj(txtCnpj.getText());
        
        try {
            fornecedor = dao.buscaID(fornecedor);
            
            if(fornecedor != null) {
                txtNome.setText(fornecedor.getNome());
                txtSede.setText(fornecedor.getSede());
                txtProdutos.setText(fornecedor.getProdutos());
                
                habilitaAlteracaoExclusao();
            }
            else {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Fornecedor NÃO encontrado!!!");
                alerta.showAndWait(); //exibe a mensagem

                txtCnpj.requestFocus();
            }
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensagem");
            alerta.setHeaderText("Erro");
            alerta.setContentText(ex.getMessage());
            
            alerta.showAndWait(); //exibe a mensagem
            
            txtCnpj.requestFocus();
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
        txtCnpj.setText("");
        txtNome.setText("");
        txtSede.setText("");
        txtProdutos.setText("");
    }
}
