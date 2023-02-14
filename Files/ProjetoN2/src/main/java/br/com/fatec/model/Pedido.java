/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.model;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Vinicim
 */
public class Pedido {
    //private int id_pedido, id_func, qtde;
    //private String sabor, descricao, cpf_cli, pagamento;
    //private String cep, bairro, rua, numero, comp;
    //private float valorUnit, valorTotal;
    private final SimpleIntegerProperty id_pedido, id_func, qtde;
    private final SimpleStringProperty sabor, descricao, cpf_cli;
    private final SimpleStringProperty cep, bairro, rua, numero, comp;
    private final SimpleFloatProperty valorUnit, valorTotal;

    public Pedido() {
        this.id_pedido = new SimpleIntegerProperty(0);
        this.id_func = new SimpleIntegerProperty(0);
        this.qtde = new SimpleIntegerProperty(0);
        this.sabor = new SimpleStringProperty("");
        this.descricao = new SimpleStringProperty("");
        this.cpf_cli = new SimpleStringProperty("");
        this.cep = new SimpleStringProperty("");
        this.bairro = new SimpleStringProperty("");
        this.rua = new SimpleStringProperty("");
        this.numero = new SimpleStringProperty("");
        this.comp = new SimpleStringProperty("");
        this.valorUnit = new SimpleFloatProperty(0);
        this.valorTotal = new SimpleFloatProperty(0);
    }
    
    public Pedido(int id_pedido, int id_func, int qtde, String sabor, String descricao, String cpf_cli,
            String cep, String bairro, String rua, String numero, String comp,
            float valorUnit, float valorTotal) {
        this.id_pedido = new SimpleIntegerProperty(id_pedido);
        this.id_func = new SimpleIntegerProperty(id_func);
        this.qtde = new SimpleIntegerProperty(qtde);
        this.sabor = new SimpleStringProperty(sabor);
        this.descricao = new SimpleStringProperty(descricao);
        this.cpf_cli = new SimpleStringProperty(cpf_cli);
        this.cep = new SimpleStringProperty(cep);
        this.bairro = new SimpleStringProperty(bairro);
        this.rua = new SimpleStringProperty(rua);
        this.numero = new SimpleStringProperty(numero);
        this.comp = new SimpleStringProperty(comp);
        this.valorUnit = new SimpleFloatProperty(valorUnit);
        this.valorTotal = new SimpleFloatProperty(valorTotal);
    }
    
    
    //retorna as propriedades
    public SimpleIntegerProperty id_pedidoProperty() {
        return id_pedido;
    }
    
    public SimpleIntegerProperty id_funcProperty() {
        return id_func;
    }
    
    public SimpleIntegerProperty qtdeProperty() {
        return qtde;
    }
    
    public SimpleStringProperty saborProperty() {
        return sabor;
    }
    
    public SimpleStringProperty descricaoProperty() {
        return descricao;
    }
    
    public SimpleStringProperty cpf_cliProperty() {
        return cpf_cli;
    }
    
    public SimpleStringProperty cepProperty() {
        return cep;
    }
    
    public SimpleStringProperty bairroProperty() {
        return bairro;
    }
    
    public SimpleStringProperty ruaProperty() {
        return rua;
    }
    
    public SimpleStringProperty numeroProperty() {
        return numero;
    }
    
    public SimpleStringProperty compProperty() {
        return comp;
    }
    
    public SimpleFloatProperty valorUnitProperty() {
        return valorUnit;
    }
    
    public SimpleFloatProperty valorTotalProperty() {
        return valorTotal;
    }
    
    
    //getters e setters
    public int getId_pedido() {
        return id_pedido.get();
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido.set(id_pedido);
    }
    
    public int getId_func() {
        return id_func.get();
    }

    public void setId_func(int id_func) {
        this.id_func.set(id_func);
    }
    
    public int getQtde() {
        return qtde.get();
    }

    public void setQtde(int qtde) {
        this.qtde.set(qtde);
    }
    
    public String getSabor() {
        return sabor.get();
    }
    
    public void setSabor(String sabor) {
        this.sabor.set(sabor);
    }
    
    public String getDescricao() {
        return descricao.get();
    }
    
    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }
    
    public String getCpf_cli() {
        return cpf_cli.get();
    }
    
    public void setCpf_cli(String cpf_cli) {
        this.cpf_cli.set(cpf_cli);
    }
    
    public String getCep() {
        return cep.get();
    }
    
    public void setCep(String cep) {
        this.cep.set(cep);
    }
    
    public String getBairro() {
        return bairro.get();
    }
    
    public void setBairro(String bairro) {
        this.bairro.set(bairro);
    }
    
    public String getRua() {
        return rua.get();
    }
    
    public void setRua(String rua) {
        this.rua.set(rua);
    }
    
    public String getNumero() {
        return numero.get();
    }
    
    public void setNumero(String numero) {
        this.numero.set(numero);
    }
    
    public String getComp() {
        return comp.get();
    }
    
    public void setComp(String comp) {
        this.comp.set(comp);
    }
    
    public float getValorUnit() {
        return valorUnit.get();
    }

    public void setValorUnit(float valorUnit) {
        this.valorUnit.set(valorUnit);
    }
    
    public float getValorTotal() {
        return valorTotal.get();
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal.set(valorTotal);
    }
    
    
    
    

    /*public Pedido(int id_pedido, int id_func, int qtde, String sabor, String descricao, String cpf_cli, String pagamento, String cep, String bairro, String rua, String numero, String comp, float valorUnit, float valorTotal) {
        this.id_pedido = id_pedido;
        this.id_func = id_func;
        this.qtde = qtde;
        this.sabor = sabor;
        this.descricao = descricao;
        this.cpf_cli = cpf_cli;
        this.pagamento = pagamento;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.comp = comp;
        this.valorUnit = valorUnit;
        this.valorTotal = valorTotal;
    }*/

    
    
    /*
    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCpf_cli() {
        return cpf_cli;
    }

    public void setCpf_cli(String cpf_cli) {
        this.cpf_cli = cpf_cli;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public float getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(float valorUnit) {
        this.valorUnit = valorUnit;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    */
    
}
