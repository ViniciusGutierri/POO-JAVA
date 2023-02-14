/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.DAO;

import br.com.fatec.model.Pizza;
import br.com.fatec.persistencia.Banco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Vinicim
 */
public class PizzaDAO implements DAO<Pizza> {
    
    //variaveis auxiliares
    //permite o uso de comandos DML (select, insert, delete e update) para
    //acessar nosso SGBD
    private java.sql.PreparedStatement pst;
    
    //permite armazenar um conjunto de dados vindo do SGBD para ser
    //manipulado
    private java.sql.ResultSet rs;
    
    //representar os dados do  meu negócio
    private Pizza pizza;
    
    

    @Override
    public boolean insere(Pizza obj) throws SQLException {
        String sql = "INSERT INTO Pizza (sabor, descricao, tamanho, valor) " +
                " VALUES (?, ?, ?, ?)"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando INSERT
        pst.setString(1, obj.getSabor());
        pst.setString(2, obj.getDescricao());
        pst.setString(3, obj.getTamanho());
        pst.setFloat(4, obj.getValor());
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionou ou nao
        return res != 0;
    }

    @Override
    public boolean remove(Pizza obj) throws SQLException {
        String sql = "DELETE FROM Pizza WHERE sabor = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando DELETE
        pst.setString(1, obj.getSabor());
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionoou ou nao
        return res != 0;
    }

    @Override
    public boolean altera(Pizza obj) throws SQLException {
        String sql = "UPDATE Pizza SET descricao = ?, tamanho = ?, valor = ?"
                + "WHERE sabor = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando UPDATE
        pst.setString(4, obj.getSabor());
        pst.setString(1, obj.getDescricao());
        pst.setString(2, obj.getTamanho());
        pst.setFloat(3, obj.getValor());
        
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionoou ou nao
        return res != 0;
    }

    @Override
    public Pizza buscaID(Pizza obj) throws SQLException {
        String sql = "SELECT * FROM Pizza "
                + "WHERE sabor = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando UPDATE
        pst.setString(1, obj.getSabor());
        
        //executar o comando
        rs = pst.executeQuery(); //esse método serve para SELECT
        
        //verificar se trouxe algum registro
        //rs.next() faz a leitura do próximo registro, se existir devolve true
        //se nao devolve false
        if(rs.next()) {
            //mover os dados(campos da tab) do resultSet para o objeto proprietário
            pizza = new Pizza();
            pizza.setSabor(rs.getString("sabor"));
            pizza.setDescricao(rs.getString("descricao"));
            pizza.setTamanho(rs.getString("tamanho"));
            pizza.setValor(rs.getFloat("valor"));
        }
        else {
            //não encontrou o registro solicitado
            pizza = null;
        }
                
        //fecha a conexao
        Banco.desconectar();
        
        //devolve o objeto proprietario
        return pizza;
    }
    
    public Pizza buscaVal(Pizza obj) throws SQLException {
        String sql = "SELECT valor FROM Pizza "
                + "WHERE sabor = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando UPDATE
        pst.setString(1, obj.getSabor());
        
        //executar o comando
        rs = pst.executeQuery(); //esse método serve para SELECT
        
        //verificar se trouxe algum registro
        //rs.next() faz a leitura do próximo registro, se existir devolve true
        //se nao devolve false
        if(rs.next()) {
            //mover os dados(campos da tab) do resultSet para o objeto proprietário
            pizza = new Pizza();
            pizza.setValor(rs.getFloat("valor"));
        }
        else {
            //não encontrou o registro solicitado
            pizza = null;
        }
                
        //fecha a conexao
        Banco.desconectar();
        
        //devolve o objeto proprietario
        return pizza;
    }

    @Override
    public Collection<Pizza> lista(String criterio) throws SQLException {
        //cria uma lista para armazenar os dados vindos do banco
        ArrayList<Pizza> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Pizza ";

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
            pizza = new Pizza();
            
            //mover os dados do resultSet para o objeto proprietário
            pizza.setId_pizza(rs.getInt("id_pizza"));
            pizza.setSabor(rs.getString("sabor"));
            pizza.setDescricao(rs.getString("descricao"));
            pizza.setTamanho(rs.getString("tamanho"));
            pizza.setValor(rs.getFloat("valor"));
            
            //move o objeto para a coleção
            lista.add(pizza);
        }
                
        //fecha a conexao
        Banco.desconectar();
        
        //devolve o objeto proprietario
        return lista;
    }
    
}
