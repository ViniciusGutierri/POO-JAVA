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
public class Fornecedor {
    //private int id_forn;
    //private String cnpj, nome;
    //private String sede, produtos;
    private final SimpleIntegerProperty id_forn;
    private final SimpleStringProperty cnpj, nome, sede, produtos;

    public Fornecedor() {
        this.id_forn = new SimpleIntegerProperty(0);
        this.cnpj = new SimpleStringProperty("");
        this.nome = new SimpleStringProperty("");
        this.sede = new SimpleStringProperty("");
        this.produtos = new SimpleStringProperty("");
    }
    
    public Fornecedor(int id_forn, String cnpj, String nome, String sede, String produtos) {
        this.id_forn = new SimpleIntegerProperty(id_forn);
        this.cnpj = new SimpleStringProperty(cnpj);
        this.nome = new SimpleStringProperty(nome);
        this.sede = new SimpleStringProperty(sede);
        this.produtos = new SimpleStringProperty(produtos);
    }
    
    //retorna as propriedades
    public SimpleIntegerProperty id_fornProperty() {
        return id_forn;
    }
    
    public SimpleStringProperty cnpjProperty() {
        return cnpj;
    }
    
    public SimpleStringProperty nomeProperty() {
        return nome;
    }
    
    public SimpleStringProperty sedeProperty() {
        return sede;
    }
    
    public SimpleStringProperty produtosProperty() {
        return produtos;
    }
    
    
    //getters e setters
    public int getId_forn() {
        return id_forn.get();
    }
    
    public void setId_forn(int id_forn) {
        this.id_forn.set(id_forn);
    }
    
    public String getCnpj() {
        return cnpj.get();
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj.set(cnpj);
    }
    
    public String getNome() {
        return nome.get();
    }
    
    public void setNome(String nome) {
        this.nome.set(nome);
    }
    
    public String getSede() {
        return sede.get();
    }
    
    public void setSede(String sede) {
        this.sede.set(sede);
    }
    
    public String getProdutos() {
        return produtos.get();
    }
    
    public void setProdutos(String produtos) {
        this.produtos.set(produtos);
    }
    

    /*public Fornecedor(int id_forn, String cnpj, String nome, String sede, String produtos) {
        this.id_forn = id_forn;
        this.cnpj = cnpj;
        this.nome = nome;
        this.sede = sede;
        this.produtos = produtos;
    }*/

    
    
    /*
    public int getId_forn() {
        return id_forn;
    }

    public void setId_forn(int id_forn) {
        this.id_forn = id_forn;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }*/
    
    
    
}
