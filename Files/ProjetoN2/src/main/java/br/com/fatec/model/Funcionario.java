/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Vinicim
 */
public class Funcionario {
    //private int id_func;
    //private String cpf, nome, cargo, celular, data_nasc;
    private final SimpleIntegerProperty id_func;
    private final SimpleStringProperty cpf, nome, cargo, celular, data_nasc;

    public Funcionario() {
        this.id_func = new SimpleIntegerProperty(0);
        this.cpf = new SimpleStringProperty("");
        this.nome = new SimpleStringProperty("");
        this.cargo = new SimpleStringProperty("");
        this.celular = new SimpleStringProperty("");
        this.data_nasc = new SimpleStringProperty("");
    }
    
    public Funcionario(int id_func, String cpf, String nome, String cargo,
            String celular, String data_nasc) {
        this.id_func = new SimpleIntegerProperty(id_func);
        this.cpf = new SimpleStringProperty(cpf);
        this.nome = new SimpleStringProperty(nome);
        this.cargo = new SimpleStringProperty(cargo);
        this.celular = new SimpleStringProperty(celular);
        this.data_nasc = new SimpleStringProperty(data_nasc);
    }
    
    //retorna as propriedades
    public SimpleIntegerProperty id_funcProperty() {
        return id_func;
    }
    
    public SimpleStringProperty cpfProperty() {
        return cpf;
    }
    
    public SimpleStringProperty nomeProperty() {
        return nome;
    }
    
    public SimpleStringProperty cargoProperty() {
        return cargo;
    }
    
    public SimpleStringProperty celularProperty() {
        return celular;
    }
    
    public SimpleStringProperty data_nascProperty() {
        return data_nasc;
    }
    
    //getters e setters
    public int getId_func() {
        return id_func.get();
    }
    
    public void setId_func(int id_func) {
        this.id_func.set(id_func);
    }
    
    public String getCpf() {
        return cpf.get();
    }
    
    public void setCpf(String cpf) {
        this.cpf.set(cpf);
    }
    
    public String getNome() {
        return nome.get();
    }
    
    public void setNome(String nome) {
        this.nome.set(nome);
    }
    
    public String getCargo() {
        return cargo.get();
    }
    
    public void setCargo(String cargo) {
        this.cargo.set(cargo);
    }
    
    public String getCelular() {
        return celular.get();
    }
    
    public void setCelular(String celular) {
        this.celular.set(celular);
    }
    
    public String getData_nasc() {
        return data_nasc.get();
    }
    
    public void setData_nasc(String data_nasc) {
        this.data_nasc.set(data_nasc);
    }
    
    

    /*public Funcionario(int id_func, String cpf, String nome, String cargo, String celular, String data_nasc) {
        this.id_func = id_func;
        this.cpf = cpf;
        this.nome = nome;
        this.cargo = cargo;
        this.celular = celular;
        this.data_nasc = data_nasc;
    }*/

    @Override
    public String toString() {
        return nome.get();
    }

    
    
    
    /*
    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }
    */
    
    
}
