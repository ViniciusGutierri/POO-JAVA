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
public class Diretor extends Funcionario{    
    private double bonusSalarial ;

    public Diretor(String nome) {
        super(nome);
    }

    public double getBonusSalarial() {
        return bonusSalarial;
    }

    public void setBonusSalarial(double bonusSalarial) {
        this.bonusSalarial = bonusSalarial;
    }
}
