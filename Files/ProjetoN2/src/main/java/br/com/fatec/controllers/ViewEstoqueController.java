/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controllers;

import br.com.fatec.model.Estoque;
import java.net.URL;
import java.util.HashSet;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ilson
 */
public class ViewEstoqueController implements Initializable {

    @FXML
    private Label lblCodigo;
    @FXML
    private Label lblMarca;
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtMarca;
    @FXML
    private Button btnInserir;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnExcluir;
    @FXML
    private ComboBox<Estoque> cmbEstoque;
    @FXML
    private Button btnPesquisar;
    
    private ObservableList<Estoque> estoque =
            FXCollections.observableArrayList();
    @FXML
    private Label lblProduto;
    @FXML
    private TextField txtProduto;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        cmbEstoque.setItems(estoque);
        
        txtCodigo.focusedProperty().addListener(new ChangeListener<Boolean>(){
              @Override
              public void changed(ObservableValue<? extends Boolean> observable,
                                  Boolean oldValue, Boolean newValue) {
                  if(newValue) {
                      limparCampos();
                      habilitaInclusao();
                  }
              }
    });
    }    

    @FXML
    private void btnInserir_Click(ActionEvent event) {
        Estoque e = new Estoque();
        e.setCod_prod(txtCodigo.getText());
        
        if(estoque.contains(e)) {
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Produto já cadastrado!!", ButtonType.OK);
            alerta.showAndWait();
            
            return;
        }
        
        try {
            
            estoque.add(moveTelaObjeto());
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION, "Produto cadastrado com sucesso", ButtonType.OK);
            alerta.showAndWait();
            
            limparCampos();
            
            txtCodigo.requestFocus();
        } catch (Exception ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensagem");
            alerta.setHeaderText("Erro!!");
            alerta.setContentText(ex.getMessage());
            alerta.showAndWait();
            
        }
        
    }

    @FXML
    private void btnAlterar_Click(ActionEvent event) {
        Estoque e = new Estoque();
        
        e.setCod_prod(txtCodigo.getText());
        e.setMarca(txtMarca.getText());
        e.setProduto(txtProduto.getText());
        
        e.hashCode();
        
        for(Estoque a: estoque) {
            if(a.hashCode() == e.hashCode()) {
                a.setCod_prod(txtCodigo.getText());
                a.setMarca(txtMarca.getText());
                a.setProduto(txtProduto.getText());
                
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Informações alteradas com sucesso");
                alerta.showAndWait();
                
                limparCampos();
                
                txtCodigo.requestFocus();
                
                habilitaInclusao();
            }
            else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Um erro foi apresentado");
                alerta.showAndWait();
            }
        }
        
    }

    @FXML
    private void btnExcluir_Click(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText("Atenção");
        alerta.setContentText("Deseja remover o produto?");
        
        Optional<ButtonType> confirm = alerta.showAndWait();
        
        if(confirm.get() == ButtonType.CANCEL) {
            return;
        }
        
        Estoque e = new Estoque();
        
        e.setCod_prod(txtCodigo.getText());
        e.setMarca(txtMarca.getText());
        e.setProduto(txtProduto.getText());
        
        e.hashCode();
        
        if(estoque.remove(e)) {
            alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Mensagem");
            alerta.setHeaderText("Atenção");
            alerta.setContentText("Produto removido!");
            alerta.showAndWait();
            
            limparCampos();
            habilitaInclusao();
         }
        else {
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensagem");
            alerta.setHeaderText("Atenção");
            alerta.setContentText("Ocoreu um erro");
            alerta.showAndWait();
        }
    }

    @FXML
    private void btnPesquisar_Click(ActionEvent event) {
        
        Estoque e = cmbEstoque.getValue();
        
        if(e == null) {
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Insire um codigo de produto para pesquisar.", ButtonType.OK);
            alerta.showAndWait();
        }
        else {
            moveObjetoTela(e);
            habilitaAltExc();
        }
        
    }
    
    private void limparCampos() {
        txtCodigo.setText("");
        txtProduto.setText("");
        txtMarca.setText("");
        cmbEstoque.setValue(null);
    }
    
    private void habilitaInclusao() {
        btnInserir.setDisable(false);
        btnExcluir.setDisable(true);
        btnAlterar.setDisable(true);
    }
    
    
    private Estoque moveTelaObjeto() {
        
        Estoque e = new Estoque();
        
        e.setMarca(txtMarca.getText());
        e.setCod_prod(txtCodigo.getText());
        e.setProduto(txtProduto.getText());
        
        return e;
    }
    
    private void moveObjetoTela (Estoque e){
        
        txtCodigo.setText(e.getCod_prod());
        txtMarca.setText(e.getMarca());
        txtProduto.setText(e.getProduto());
    }
   
    private void habilitaAltExc () {
        btnInserir.setDisable(true);
        btnExcluir.setDisable(false);
        btnAlterar.setDisable(false);
   
    }

    @FXML
    private void cmb_Estoque(ActionEvent event) {
    }


}
