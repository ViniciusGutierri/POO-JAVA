/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.model;

import java.util.Objects;

/**
 *
 * @author ilson
 */
public class Estoque {
    
    private String produto, marca,cod_prod;

    @Override
    public String toString() {
        return produto;
    }


    
  
    //construtor
    public Estoque(){
        
    }

    public Estoque(String produto, String marca, String cod_prod) {
        this.produto = produto;
        this.marca = marca;
        this.cod_prod = cod_prod;
    }

    
    // hash e equal
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.cod_prod);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estoque other = (Estoque) obj;
        return Objects.equals(this.cod_prod, other.cod_prod);
    }

    
    
    
    
    
    
    // getter and setter
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(String cod_prod) {
        this.cod_prod = cod_prod;
    }
    
    
    
    
}