/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.DAO;

import br.com.fatec.model.Cliente;
import br.com.fatec.persistencia.Banco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Vinicim
 */
public class ClienteDAO implements DAO<Cliente> {
    
    //variaveis auxiliares
    //permite o uso de comandos DML (select, insert, delete e update) para
    //acessar nosso SGBD
    private java.sql.PreparedStatement pst;
    
    //permite armazenar um conjunto de dados vindo do SGBD para ser
    //manipulado
    private java.sql.ResultSet rs;
    
    //representar os dados do  meu negócio
    private Cliente cliente; //meu MODEL   
    
    

    @Override
    public boolean insere(Cliente obj) throws SQLException {
        String sql = "INSERT INTO Cliente (cpf_cli, nome, celular, cep, bairro, rua, numero, comp) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando INSERT
        pst.setString(1, obj.getCpf_cli());
        pst.setString(2, obj.getNome());
        pst.setString(3, obj.getCelular());
        pst.setString(4, obj.getCep());
        pst.setString(5, obj.getBairro());
        pst.setString(6, obj.getRua());
        pst.setString(7, obj.getNumero());
        pst.setString(8, obj.getComp());
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionou ou nao
        return res != 0;
    }

    @Override
    public boolean remove(Cliente obj) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE cpf_cli = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando DELETE
        pst.setString(1, obj.getCpf_cli());
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionoou ou nao
        return res != 0;
    }

    @Override
    public boolean altera(Cliente obj) throws SQLException {
        String sql = "UPDATE Cliente SET nome = ?, celular = ?, cep = ?, bairro = ?, rua = ?, numero = ?, comp = ?"
                + "WHERE cpf_cli = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando UPDATE
        pst.setString(8, obj.getCpf_cli());
        pst.setString(1, obj.getNome());
        pst.setString(2, obj.getCelular());
        pst.setString(3, obj.getCep());
        pst.setString(4, obj.getBairro());
        pst.setString(5, obj.getRua());
        pst.setString(6, obj.getNumero());
        pst.setString(7, obj.getComp());
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionoou ou nao
        return res != 0;
    }

    @Override
    public Cliente buscaID(Cliente obj) throws SQLException {
        String sql = "SELECT * FROM Cliente "
                + "WHERE cpf_cli = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando UPDATE
        pst.setString(1, obj.getCpf_cli());
        
        //executar o comando
        rs = pst.executeQuery(); //esse método serve para SELECT
        
        //verificar se trouxe algum registro
        //rs.next() faz a leitura do próximo registro, se existir devolve true
        //se nao devolve false
        if(rs.next()) {
            //mover os dados(campos da tab) do resultSet para o objeto proprietário
            cliente = new Cliente();
            cliente.setCpf_cli(rs.getString("cpf_cli"));
            cliente.setNome(rs.getString("nome"));
            cliente.setCelular(rs.getString("celular"));
            cliente.setCep(rs.getString("cep"));
            cliente.setBairro(rs.getString("bairro"));
            cliente.setRua(rs.getString("rua"));
            cliente.setNumero(rs.getString("numero"));
            cliente.setComp(rs.getString("comp"));
        }
        else {
            //não encontrou o registro solicitado
            cliente = null;
        }
                
        //fecha a conexao
        Banco.desconectar();
        
        //devolve o objeto proprietario
        return cliente;
    }
    
    public Cliente buscaCli(Cliente obj) throws SQLException {
        String sql = "SELECT * FROM Cliente "
                + "WHERE cpf_cli = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando UPDATE
        pst.setString(1, obj.getCpf_cli());
        
        //executar o comando
        rs = pst.executeQuery(); //esse método serve para SELECT
        
        //verificar se trouxe algum registro
        //rs.next() faz a leitura do próximo registro, se existir devolve true
        //se nao devolve false
        if(rs.next()) {
            //mover os dados(campos da tab) do resultSet para o objeto proprietário
            cliente = new Cliente();
            cliente.setCpf_cli(rs.getString("cpf_cli"));
            cliente.setCep(rs.getString("cep"));
            cliente.setBairro(rs.getString("bairro"));
            cliente.setRua(rs.getString("rua"));
            cliente.setNumero(rs.getString("numero"));
            cliente.setComp(rs.getString("comp"));
        }
        else {
            //não encontrou o registro solicitado
            cliente = null;
        }
                
        //fecha a conexao
        Banco.desconectar();
        
        //devolve o objeto proprietario
        return cliente;
    }

    @Override
    public Collection<Cliente> lista(String criterio) throws SQLException {
        //cria uma lista para armazenar os dados vindos do banco
        ArrayList<Cliente> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Cliente ";

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
            cliente = new Cliente();
            
            //mover os dados do resultSet para o objeto proprietário
            cliente.setCpf_cli(rs.getString("cpf_cli"));
            cliente.setNome(rs.getString("nome"));
            cliente.setCelular(rs.getString("celular"));
            cliente.setCep(rs.getString("cep"));
            cliente.setBairro(rs.getString("bairro"));
            cliente.setRua(rs.getString("rua"));
            cliente.setNumero(rs.getString("numero"));
            cliente.setComp(rs.getString("comp"));
            
            //move o objeto para a coleção
            lista.add(cliente);
        }
                
        //fecha a conexao
        Banco.desconectar();
        
        //devolve o objeto proprietario
        return lista;
    }
    
}
