/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.va4_3108_herenca;

/**
 *
 * @author Aluno
 */
public class Gerente extends Funcionario {
    private String secretaria;
    
    //construtor
    public Gerente(String nome){
        super(nome); // chama o contrutor da superclasse
        //super.setNome(nome); nao funciona
    }
    //metodos
    
    @Override
    public void listarDados(){
        //chamando o método  listarDados() de FUNCIONARIO
        super.listarDados();
        System.out.println("Secretaria: " + secretaria);
        
        //getNome(); //ou
        super.getNome();
    }
    //metodos sobrecarregados
    
    //getters e setters
    public String getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(String secretaria) {
        this.secretaria = secretaria;
    }
}
