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
public class Principal {
    public static void main(String[] args) {
        //criar gerente
        Gerente g = new Gerente("Pedro Antonio");
        
        g.setCpf("123456789-11");//classe pai
        g.setNome("Pedro Antonio");//classe pai
        g.setSalario(5000); //classe pai
        g.setSecretaria("Elisa Soares"); //gerente
        
        //exibir dados
        g.listarDados(); // só chama o metodo da classe GERENTE
                         // nao da para chamar a classe FUNCIONARIO
    }
}
