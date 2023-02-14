/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.model;

import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author Vinicim
 */
public class Cliente {
    //private String cpf_cli, nome, celular;
    //private String cep, bairro, rua, numero, comp;
    private final SimpleStringProperty cpf_cli, nome, celular;
    private final SimpleStringProperty cep, bairro, rua, numero, comp;

    //construtor
    public Cliente() {
        this.cpf_cli = new SimpleStringProperty("");
        this.nome = new SimpleStringProperty("");
        this.celular = new SimpleStringProperty("");
        this.cep = new SimpleStringProperty("");
        this.bairro = new SimpleStringProperty("");
        this.rua = new SimpleStringProperty("");
        this.numero = new SimpleStringProperty("");
        this.comp = new SimpleStringProperty("");
    }
    
    public Cliente(String cpf_cli, String nome, String celular, String cep, String bairro,
            String rua, String numero, String comp) {
        this.cpf_cli = new SimpleStringProperty(cpf_cli);
        this.nome = new SimpleStringProperty(nome);
        this.celular = new SimpleStringProperty(celular);
        this.cep = new SimpleStringProperty(cep);
        this.bairro = new SimpleStringProperty(bairro);
        this.rua = new SimpleStringProperty(rua);
        this.numero = new SimpleStringProperty(numero);
        this.comp = new SimpleStringProperty(comp);
    }
    
    //retorna as propriedades
    public SimpleStringProperty cpf_cliProperty() {
        return cpf_cli;
    }
    
    public SimpleStringProperty nomeProperty() {
        return nome;
    }
    
    public SimpleStringProperty celularProperty() {
        return celular;
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
    
    
    
    //getters e setters
    public String getCpf_cli() {
        return cpf_cli.get();
    }
    
    public void setCpf_cli(String cpf_cli) {
        this.cpf_cli.set(cpf_cli);
    }
    
    public String getNome() {
        return nome.get();
    }
    
    public void setNome(String nome) {
        this.nome.set(nome);
    }
    
    public String getCelular() {
        return celular.get();
    }
    
    public void setCelular(String celular) {
        this.celular.set(celular);
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
    
    
    
    

    /*public Cliente(String cpf_cli, String nome, String celular, String cep, String bairro, String rua, String numero, String comp) {
        this.cpf_cli = cpf_cli;
        this.nome = nome;
        this.celular = celular;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.comp = comp;
    }*/
    
    

    
    
    /*public String getCpf_cli() {
        return cpf_cli;
    }

    public void setCpf_cli(String cpf_cli) {
        this.cpf_cli = cpf_cli;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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
    }*/


    
    
}
