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
public class Pizza {
    //private int id_pizza;
    //private String sabor, descricao, tamanho;
    //private float valor;
    private final SimpleIntegerProperty id_pizza;
    private final SimpleStringProperty sabor, descricao, tamanho;
    private final SimpleFloatProperty valor;
    

    public Pizza() {
        this.id_pizza = new SimpleIntegerProperty(0);
        this.sabor = new SimpleStringProperty("");
        this.descricao = new SimpleStringProperty("");
        this.tamanho = new SimpleStringProperty("");
        this.valor = new SimpleFloatProperty(0);
    }
    
    public Pizza(int id_pizza, String sabor, String descricao, String tamanho,
            float valor) {
        this.id_pizza = new SimpleIntegerProperty(id_pizza);
        this.sabor = new SimpleStringProperty(sabor);
        this.descricao = new SimpleStringProperty(descricao);
        this.tamanho = new SimpleStringProperty(tamanho);
        this.valor = new SimpleFloatProperty(valor);
    }
    
    //retorna as propriedades
    public SimpleIntegerProperty id_pizzaProperty() {
        return id_pizza;
    }
    
    public SimpleStringProperty saborProperty() {
        return sabor;
    }
    
    public SimpleStringProperty descricaoProperty() {
        return descricao;
    }
    
    public SimpleStringProperty tamanhoProperty() {
        return tamanho;
    }
    
    public SimpleFloatProperty valorProperty() {
        return valor;
    }
    
    
    //getters e setters
    public int getId_pizza() {
        return id_pizza.get();
    }
    
    public void setId_pizza(int id_pizza) {
        this.id_pizza.set(id_pizza);
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
    
    public String getTamanho() {
        return tamanho.get();
    }
    
    public void setTamanho(String tamanho) {
        this.tamanho.set(tamanho);
    }
    
    public float getValor() {
        return valor.get();
    }
    
    public void setValor(float valor) {
        this.valor.set(valor);
    }

    /*public Pizza(int id_pizza, String sabor, String descricao, String tamanho, float valor) {
        this.id_pizza = id_pizza;
        this.sabor = sabor;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.valor = valor;
    }*/

    @Override
    public String toString() {
        return sabor + " - " + tamanho;
    }

    
    
    
    /*
    public int getId_pizza() {
        return id_pizza;
    }

    public void setId_pizza(int id_pizza) {
        this.id_pizza = id_pizza;
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

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    */
    
}
