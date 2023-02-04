/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.exceptions;

/**
 *
 * @author Aluno
 * se herdar de RuntimeException - NAO VERIFICADA
 * se herdar de IOException - VERIFICADA
 */
public class CPFException  extends RuntimeException {

    public CPFException() {
        super(); //chama o construtor da classe pai
    }

    public CPFException(String message) {
        super(message); //chama o construtor da classe pai
    }
    
}
