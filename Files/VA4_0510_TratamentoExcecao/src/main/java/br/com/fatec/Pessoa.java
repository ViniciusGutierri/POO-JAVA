/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec;

import br.com.fatec.exceptions.CPFException;
import java.io.IOException;

/**
 *
 * @author Aluno
 */
public class Pessoa 
{
    private String nome, cpf;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws CPFException {
        if(cpf.length() != 11) {
            throw new CPFException("Tamanho inválido, deve ter 11 números...");
        }
        
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) throws IOException{
        if(idade < 0) {
            //lança uma exceção, para ser:
            //Verificada se usa IOException
            //NÃO verificada se usa RuntimeException
            throw new IOException("Idade inválida...");
        }
        this.idade = idade;
    }
    
    
}
