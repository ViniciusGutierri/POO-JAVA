/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controllers;

import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.DAO.FuncionarioDAO;
import br.com.fatec.DAO.PedidoDAO;
import br.com.fatec.DAO.PizzaDAO;
import br.com.fatec.model.Cliente;
import br.com.fatec.model.Funcionario;
import br.com.fatec.model.Pedido;
import br.com.fatec.model.Pizza;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Vinicim
 */
public class ViewPedidoController implements Initializable {

    @FXML
    private Label lblFunc;
    @FXML
    private TextField txtId_Func;
    @FXML
    private ComboBox<String> cbFunc;
    @FXML
    private Label lblSabor;
    @FXML
    private ComboBox<String> cbSabor;
    @FXML
    private Label lblValorUnit;
    @FXML
    private TextField txtValorUnit;
    @FXML
    private Label lblDescricao;
    @FXML
    private TextArea txtDescricao;
    @FXML
    private Label lblCpf;
    @FXML
    private TextField txtCpf;
    @FXML
    private Label lblCep;
    @FXML
    private TextField txtCep;
    @FXML
    private Button btnBuscarCpf;
    @FXML
    private Label lblBairro;
    @FXML
    private TextField txtBairro;
    @FXML
    private Label lblRua;
    @FXML
    private TextField txtRua;
    @FXML
    private Label lblNumero;
    @FXML
    private TextField txtNumero;
    @FXML
    private Label lblComp;
    @FXML
    private TextField txtComp;
    @FXML
    private Label lblQtde;
    @FXML
    private TextField txtQtde;
    @FXML
    private Label lblPagamento;
    @FXML
    private Label lblValorTotal;
    @FXML
    private TextField txtValorTotal;
    @FXML
    private Label lblPedido;
    @FXML
    private TextField txtPedido;
    @FXML
    private Button btnBuscarPedido;
    @FXML
    private Button btnCadastrar;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnExcluir;

    private ObservableList<String> funcionarios = FXCollections.observableArrayList();
    private ObservableList<String> pizzas = FXCollections.observableArrayList();

    private Pedido pedido;
    private PedidoDAO dao = new PedidoDAO();

    private Pizza pizza;
    private PizzaDAO daoPizza = new PizzaDAO();
    
    private Cliente cliente;
    private ClienteDAO daoCli = new ClienteDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        habilitaInclusao();

        cbFunc.setItems(funcionarios);
        preencheComboFunc();

        cbSabor.setItems(pizzas);
        preencheComboSabor();

        cbFunc.valueProperty().addListener((values, velho, novo) -> {
            try {
                FuncionarioDAO dao = new FuncionarioDAO();
                Funcionario f = new Funcionario();
                f = dao.buscaNome(novo);
                txtId_Func.setText(Integer.toString(f.getId_func()));
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        });

        txtPedido.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable,
                    Boolean oldValue, Boolean newValue) {
                if (newValue) { //ganhou o FOCO
                    limpaCampos();
                    habilitaInclusao();
                }
            }
        });
        
        txtValorUnit.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable,
                    Boolean oldValue, Boolean newValue) {
                if (newValue) { //ganhou o FOCO
                    pizza = new Pizza();
                    pizza.setSabor(cbSabor.getValue());
                    try {
                        pizza = daoPizza.buscaVal(pizza);

                        if(pizza != null) {
                            txtValorUnit.setText(String.valueOf(pizza.getValor()));
                        }
                        else {
                            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                            alerta.setTitle("Mensagem");
                            alerta.setHeaderText("Atenção");
                            alerta.setContentText("Valor NÃO encontrado!!!");
                            alerta.showAndWait(); //exibe a mensagem
                            
                            txtValorUnit.requestFocus();
                        }
                    } catch (SQLException ex) {
                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                        alerta.setTitle("Mensagem");
                        alerta.setHeaderText("Erro");
                        alerta.setContentText(ex.getMessage());

                        alerta.showAndWait(); //exibe a mensagem

                        txtValorUnit.requestFocus();
                    }
                }
            }
        });
        
        txtValorTotal.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable,
                    Boolean oldValue, Boolean newValue) {
                
                if (newValue) { //ganhou o FOCO
                    
                    try {
                        float res;
                        res = Float.parseFloat(txtValorUnit.getText()) * Float.parseFloat(txtQtde.getText());
                        txtValorTotal.setText(String.valueOf(res));
                        
                    } catch (ArithmeticException ex) {
                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                        alerta.setTitle("Mensagem");
                        alerta.setHeaderText("Erro");
                        alerta.setContentText(ex.getMessage());

                        alerta.showAndWait(); //exibe a mensagem

                        txtQtde.requestFocus();
                    }
                }
            }
        });
    }

    private void preencheComboFunc() {
        FuncionarioDAO dao = new FuncionarioDAO();

        ArrayList<Funcionario> lista;
        try {
            lista = (ArrayList<Funcionario>) dao.lista("");
            for (Funcionario f : lista) {
                funcionarios.add(f.getNome());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void preencheComboSabor() {
        PizzaDAO dao = new PizzaDAO();

        ArrayList<Pizza> lista;
        try {
            lista = (ArrayList<Pizza>) dao.lista("");
            for (Pizza p : lista) {
                pizzas.add(p.getSabor());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
        txtPedido.setText("");
        txtCpf.setText("");
        txtCep.setText("");
        txtBairro.setText("");
        txtRua.setText("");
        txtNumero.setText("");
        txtComp.setText("");
        txtId_Func.setText("");
        txtValorUnit.setText("");
        txtQtde.setText("");
        txtDescricao.setText("");
        txtValorTotal.setText("");
        cbFunc.setValue(null);
        cbSabor.setValue(null);
        cbSabor.setPromptText("");
    }

    @FXML
    private void btnBuscarCpf_Click(ActionEvent event) {
        cliente = new Cliente();
        pedido = new Pedido();
        cliente.setCpf_cli(txtCpf.getText());
        
        try {
            cliente = daoCli.buscaCli(cliente);
            
            if(cliente != null) {
                txtCep.setText(cliente.getCep());
                txtBairro.setText(cliente.getBairro());
                txtRua.setText(cliente.getRua());
                txtNumero.setText(cliente.getNumero());
                txtComp.setText(cliente.getNumero());
            }
            else {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Cliente NÃO encontrado!!!");
                alerta.showAndWait(); //exibe a mensagem

                limpaCampos();
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

    @FXML
    private void btnBuscarPedido_Click(ActionEvent event) {
        pedido = new Pedido();
        pedido.setId_pedido(Integer.parseInt(txtPedido.getText()));

        try {
            pedido = dao.buscaID(pedido);

            if (pedido != null) {
                txtCpf.setText(pedido.getCpf_cli());
                txtCep.setText(pedido.getCep());
                txtBairro.setText(pedido.getBairro());
                txtRua.setText(pedido.getRua());
                txtNumero.setText(pedido.getNumero());
                txtComp.setText(pedido.getComp());
                txtId_Func.setText(String.valueOf(pedido.getId_func()));
                cbSabor.setPromptText(pedido.getSabor());
                txtValorUnit.setText(String.valueOf(pedido.getValorUnit()));
                txtQtde.setText(String.valueOf(pedido.getQtde()));
                txtDescricao.setText(pedido.getDescricao());
                txtValorTotal.setText(String.valueOf(pedido.getValorTotal()));

                habilitaAlteracaoExclusao();

            } else {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Pedido NÃO encontrado!!!");
                alerta.showAndWait(); //exibe a mensagem

                limpaCampos();
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

    @FXML
    private void btnCadastrar_Click(ActionEvent event) {
        pedido = new Pedido();

        pedido.setId_func(Integer.parseInt(txtId_Func.getText()));
        pedido.setSabor(cbSabor.getValue());
        pedido.setValorUnit(Float.parseFloat(txtValorUnit.getText()));
        pedido.setQtde(Integer.parseInt(txtQtde.getText()));
        pedido.setDescricao(txtDescricao.getText());
        pedido.setValorTotal(Float.parseFloat(txtValorTotal.getText()));
        pedido.setCpf_cli(txtCpf.getText());
        pedido.setCep(txtCep.getText());
        pedido.setBairro(txtBairro.getText());
        pedido.setRua(txtRua.getText());
        pedido.setNumero(txtNumero.getText());
        pedido.setComp(txtComp.getText());

        try {
            if (dao.insere(pedido)) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("PEDIDO CADASTRADO COM SUCESSO!!!");
                alerta.showAndWait(); //exibe a mensagem

                limpaCampos();

                txtCpf.requestFocus();
            } else {
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
        pedido = new Pedido();
        pedido.setId_pedido(Integer.parseInt(txtPedido.getText()));
        pedido.setId_func(Integer.parseInt(txtId_Func.getText()));
        pedido.setSabor(cbSabor.getValue());
        pedido.setValorUnit(Float.parseFloat(txtValorUnit.getText()));
        pedido.setQtde(Integer.parseInt(txtQtde.getText()));
        pedido.setDescricao(txtDescricao.getText());
        pedido.setValorTotal(Float.parseFloat(txtValorTotal.getText()));
        pedido.setCpf_cli(txtCpf.getText());
        pedido.setCep(txtCep.getText());
        pedido.setBairro(txtBairro.getText());
        pedido.setRua(txtRua.getText());
        pedido.setNumero(txtNumero.getText());
        pedido.setComp(txtComp.getText());
        
        try {
            if (dao.altera(pedido)) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Dados alterados com sucesso!");
                alerta.showAndWait(); //exibe a mensagem

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
        alerta.setContentText("Deseja remover esse pedido?");

        Optional<ButtonType> resultado = alerta.showAndWait();

        if (resultado.get() == ButtonType.CANCEL) {
            return;
        }

        pedido = new Pedido();
        pedido.setId_pedido(Integer.parseInt(txtPedido.getText()));
        pedido.setId_func(Integer.parseInt(txtId_Func.getText()));
        pedido.setSabor(cbSabor.getPromptText());
        pedido.setValorUnit(Float.parseFloat(txtValorUnit.getText()));
        pedido.setQtde(Integer.parseInt(txtQtde.getText()));
        pedido.setDescricao(txtDescricao.getText());
        pedido.setValorTotal(Float.parseFloat(txtValorTotal.getText()));
        pedido.setCpf_cli(txtCpf.getText());
        pedido.setCep(txtCep.getText());
        pedido.setBairro(txtBairro.getText());
        pedido.setRua(txtRua.getText());
        pedido.setNumero(txtNumero.getText());
        pedido.setComp(txtComp.getText());

        try {
            if (dao.remove(pedido)) {
                alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Pedido removido com sucesso!");
                alerta.showAndWait(); //exibe a mensagem

                //limpa os campos
                limpaCampos();
                txtCpf.requestFocus();
                habilitaInclusao();
            } else {
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
}
