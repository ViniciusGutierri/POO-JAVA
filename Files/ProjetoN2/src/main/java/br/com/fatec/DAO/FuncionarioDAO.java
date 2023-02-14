/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.DAO;

import br.com.fatec.model.Funcionario;
import br.com.fatec.persistencia.Banco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Vinicim
 */
public class FuncionarioDAO implements DAO<Funcionario> {
    
    //variaveis auxiliares
    //permite o uso de comandos DML (select, insert, delete e update) para
    //acessar nosso SGBD
    private java.sql.PreparedStatement pst;
    
    //permite armazenar um conjunto de dados vindo do SGBD para ser
    //manipulado
    private java.sql.ResultSet rs;
    
    //representar os dados do  meu negócio
    private Funcionario funcionario; //meu MODEL   

    
    
    @Override
    public boolean insere(Funcionario obj) throws SQLException {
        String sql = "INSERT INTO Funcionario (cpf, nome, cargo, celular, data_nasc) " +
                " VALUES (?, ?, ?, ?, ?)"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando INSERT
        pst.setString(1, obj.getCpf());
        pst.setString(2, obj.getNome());
        pst.setString(3, obj.getCargo());
        pst.setString(4, obj.getCelular());
        pst.setString(5, obj.getData_nasc());
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionou ou nao
        return res != 0;
    }

    @Override
    public boolean remove(Funcionario obj) throws SQLException {
        String sql = "DELETE FROM Funcionario WHERE cpf = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando DELETE
        pst.setString(1, obj.getCpf());
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionoou ou nao
        return res != 0;
    }

    @Override
    public boolean altera(Funcionario obj) throws SQLException {
        String sql = "UPDATE Funcionario SET nome = ?, cargo = ?, celular = ?, data_nasc = ?"
                + "WHERE cpf = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando UPDATE
        pst.setString(5, obj.getCpf());
        pst.setString(1, obj.getNome());
        pst.setString(2, obj.getCargo());
        pst.setString(3, obj.getCelular());
        pst.setString(4, obj.getData_nasc());
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionoou ou nao
        return res != 0;
    }

    @Override
    public Funcionario buscaID(Funcionario obj) throws SQLException {
        String sql = "SELECT * FROM Funcionario "
                + "WHERE cpf = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando UPDATE
        pst.setString(1, obj.getCpf());
        
        //executar o comando
        rs = pst.executeQuery(); //esse método serve para SELECT
        
        //verificar se trouxe algum registro
        //rs.next() faz a leitura do próximo registro, se existir devolve true
        //se nao devolve false
        if(rs.next()) {
            //mover os dados(campos da tab) do resultSet para o objeto proprietário
            funcionario = new Funcionario();
            funcionario.setCpf(rs.getString("cpf"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setCargo(rs.getString("cargo"));
            funcionario.setCelular(rs.getString("celular"));
            funcionario.setData_nasc(rs.getString("data_nasc"));
        }
        else {
            //não encontrou o registro solicitado
            funcionario = null;
        }
                
        //fecha a conexao
        Banco.desconectar();
        
        //devolve o objeto proprietario
        return funcionario;
    }

        public Funcionario buscaNome(String nome) throws SQLException {
        String sql = "SELECT * FROM Funcionario "
                + "WHERE nome = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando UPDATE
        pst.setString(1, nome);
        
        //executar o comando
        rs = pst.executeQuery(); //esse método serve para SELECT
        
        //verificar se trouxe algum registro
        //rs.next() faz a leitura do próximo registro, se existir devolve true
        //se nao devolve false
        if(rs.next()) {
            //mover os dados(campos da tab) do resultSet para o objeto proprietário
            funcionario = new Funcionario();
            funcionario.setId_func(rs.getInt("id_func"));
            funcionario.setCpf(rs.getString("cpf"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setCargo(rs.getString("cargo"));
            funcionario.setCelular(rs.getString("celular"));
            funcionario.setData_nasc(rs.getString("data_nasc"));
        }
        else {
            //não encontrou o registro solicitado
            funcionario = null;
        }
                
        //fecha a conexao
        Banco.desconectar();
        
        //devolve o objeto proprietario
        return funcionario;
    }
        
    @Override
    public Collection<Funcionario> lista(String criterio) throws SQLException {
        //cria uma lista para armazenar os dados vindos do banco
        ArrayList<Funcionario> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Funcionario ";

        //precisa fazer filtro para listagem
        if(criterio != null && criterio.length() > 0) {
            sql += " WHERE " + criterio;
        }
        
        //abre a conexao com o banco
        Banco.conectar();
        
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //executar o comando
        rs = pst.executeQuery(); //esse método serve para SELECT
        
        //Varre todo o resultado da consulta e coloca cada registro dentro
        //de um objeto e coloca o objeto dentro da coleção
        while(rs.next()) {
            //criar o objeto
            funcionario = new Funcionario();
            
            //mover os dados do resultSet para o objeto proprietário
            funcionario.setId_func(rs.getInt("id_func"));
            funcionario.setCpf(rs.getString("cpf"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setCargo(rs.getString("cargo"));
            funcionario.setCelular(rs.getString("celular"));
            funcionario.setData_nasc(rs.getString("data_nasc"));
            
            //move o objeto para a coleção
            lista.add(funcionario);
        }
                
        //fecha a conexao
        Banco.desconectar();
        
        //devolve o objeto proprietario
        return lista;
    }
    
}
