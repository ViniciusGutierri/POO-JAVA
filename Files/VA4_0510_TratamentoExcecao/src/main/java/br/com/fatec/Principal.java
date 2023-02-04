/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec;

import br.com.fatec.exceptions.CPFException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class Principal {
    public static void main(String[] args) {
       trataExcecaoDeClasses();
    }
    
    private static void trataExcecao() {
        Scanner teclado = new Scanner(System.in);
        int numero = 0, outroNumero;
        boolean erro = true;
        
        
        
        while(erro) {
            try {
                System.out.println("Digite um Número: ");
                numero = teclado.nextInt();
                
                System.out.println("Digite outro Número: ");
                outroNumero = teclado.nextInt();
                
                                
                //mostra a divisao
                System.out.println("Divisão: " + (numero / outroNumero));
            
                erro = false;
                
                FileReader f = new FileReader("c:\\teste.zip");
            } 
            catch(InputMismatchException ex) {
                System.out.println("Digite somente numero...");
                System.out.println("Erro: " + ex.getMessage());
                //limpa buffer
                teclado.nextLine();
            }
            catch(ArithmeticException ex) {
                System.out.println("Erro: Você digitou o numero 0 para o outro numero!!");
                System.out.println("Erro: " + ex.getMessage());
            }
            catch(Exception ex) {
                System.out.println("Erro geral: " + ex.getMessage());
            }
        }
        System.out.println("Numero digitado: " + numero);
    }
    
    private static void trataExcecaoDeClasses() {
        Pessoa p = new Pessoa();
        
        //atribuindo dados
        p.setNome("Alfredo de Oliveira");
        
        try {
            p.setIdade(44);
            p.setCpf("1234567890");
        } catch (IOException ex) {
            System.out.println("Erro de IO: " + ex.getMessage());
        } catch (CPFException ex) {
            System.out.println("Erro CPF: " + ex.getMessage());
        }
                
    }
        
}
