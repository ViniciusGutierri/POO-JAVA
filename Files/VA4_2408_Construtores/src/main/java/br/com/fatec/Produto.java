/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec;

/**
 *
 * @author Aluno
 */
public class Produto {
    private int codigo;
    private String descricao, fornecedor;
    
    //construtores
    public Produto() {
        this.fornecedor = "SEM INFORMAÇÃO";
    }

    public Produto(int codigo, String descricao) {
        this(); //chama um construtor
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    
    
    
    

    //getter e setter
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
}
