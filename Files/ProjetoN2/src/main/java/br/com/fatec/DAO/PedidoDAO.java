/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.DAO;

import br.com.fatec.model.Cliente;
import br.com.fatec.model.Funcionario;
import br.com.fatec.model.Pedido;
import br.com.fatec.persistencia.Banco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Vinicim
 */
public class PedidoDAO implements DAO<Pedido> {
    
    //variaveis auxiliares
    //permite o uso de comandos DML (select, insert, delete e update) para
    //acessar nosso SGBD
    private java.sql.PreparedStatement pst;
    
    //permite armazenar um conjunto de dados vindo do SGBD para ser
    //manipulado
    private java.sql.ResultSet rs;
    
    //representar os dados do  meu negócio
    private Pedido pedido;
    private Funcionario funcionario;
    private Cliente cliente;

    @Override
    public boolean insere(Pedido obj) throws SQLException {
        String sql = "INSERT INTO Pedido (id_func, sabor, valorUnit, qtde, descricao, valorTotal, cpf_cli, cep, bairro, rua, numero, comp) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando INSERT
        pst.setInt(1, obj.getId_func());
        pst.setString(2, obj.getSabor());
        pst.setFloat(3, obj.getValorUnit());
        pst.setInt(4, obj.getQtde());
        pst.setString(5, obj.getDescricao());
        pst.setFloat(6, obj.getValorTotal());
        pst.setString(7, obj.getCpf_cli());
        pst.setString(8, obj.getCep());
        pst.setString(9, obj.getBairro());
        pst.setString(10, obj.getRua());
        pst.setString(11, obj.getNumero());
        pst.setString(12, obj.getComp());
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionou ou nao
        return res != 0;
    }

    @Override
    public boolean remove(Pedido obj) throws SQLException {
        String sql = "DELETE FROM Pedido WHERE id_pedido = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando DELETE
        pst.setInt(1, obj.getId_pedido());
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionoou ou nao
        return res != 0;
    }

    @Override
    public boolean altera(Pedido obj) throws SQLException {
        String sql = "UPDATE Pedido SET id_func = ?, sabor = ?, valorUnit = ?, qtde = ?, descricao = ?, valorTotal = ?, cpf_cli = ?, cep = ?, bairro = ?, rua = ?, numero = ?, comp = ?"
                + "WHERE id_pedido = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando UPDATE
        pst.setInt(13, obj.getId_pedido());
        pst.setInt(1, obj.getId_func());
        pst.setString(2, obj.getSabor());
        pst.setFloat(3, obj.getValorUnit());
        pst.setInt(4, obj.getQtde());
        pst.setString(5, obj.getDescricao());
        pst.setFloat(6, obj.getValorTotal());
        pst.setString(7, obj.getCpf_cli());
        pst.setString(8, obj.getCep());
        pst.setString(9, obj.getBairro());
        pst.setString(10, obj.getRua());
        pst.setString(11, obj.getNumero());
        pst.setString(12, obj.getComp());
        
        
        //executar o comando
        int res = pst.executeUpdate(); //esse método serve para Insert, delete e update
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve se funcionoou ou nao
        return res != 0;
    }

    @Override
    public Pedido buscaID(Pedido obj) throws SQLException {
        String sql = "SELECT * FROM Pedido "
                + "WHERE id_pedido = ?"; //a ? indica parametros
        
        //abre a conexao com o banco
        Banco.conectar();
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Proprietario com o comando UPDATE
        pst.setInt(1, obj.getId_pedido());
        
        //executar o comando
        rs = pst.executeQuery(); //esse método serve para SELECT
        
        //verificar se trouxe algum registro
        //rs.next() faz a leitura do próximo registro, se existir devolve true
        //se nao devolve false
        if(rs.next()) {
            pedido = new Pedido();
            pedido.setCpf_cli(rs.getString("cpf_cli"));
            pedido.setCep(rs.getString("cep"));
            pedido.setBairro(rs.getString("bairro"));
            pedido.setRua(rs.getString("rua"));
            pedido.setNumero(rs.getString("numero"));
            pedido.setComp(rs.getString("comp"));
            pedido.setId_func(rs.getInt("id_func"));
            pedido.setSabor(rs.getString("sabor"));
            pedido.setValorUnit(rs.getFloat("valorUnit"));
            pedido.setQtde(rs.getInt("qtde"));
            pedido.setDescricao(rs.getString("descricao"));
            pedido.setValorTotal(rs.getFloat("valorTotal"));
        }
        else {
            pedido = null;
        }
        
        //fecha a conexao
        Banco.desconectar();
        
        //devolve o objeto proprietario
        return pedido;
    }

    @Override
    public Collection<Pedido> lista(String criterio) throws SQLException {
        //cria uma lista para armazenar os dados vindos do banco
        ArrayList<Pedido> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Pedido";

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
            pedido = new Pedido();
            
            //mover os dados do resultSet para o objeto proprietário
            pedido.setId_pedido(rs.getInt("id_pedido"));
            pedido.setCpf_cli(rs.getString("cpf_cli"));
            pedido.setCep(rs.getString("cep"));
            pedido.setNumero(rs.getString("numero"));
            pedido.setComp(rs.getString("comp"));
            pedido.setId_func(rs.getInt("id_func"));
            pedido.setSabor(rs.getString("sabor"));
            pedido.setDescricao(rs.getString("descricao"));
            pedido.setValorUnit(rs.getFloat("valorUnit"));
            pedido.setQtde(rs.getInt("qtde"));
            pedido.setValorTotal(rs.getFloat("valorTotal"));
            
            //move o objeto para a coleção
            lista.add(pedido);
        }
                
        //fecha a conexao
        Banco.desconectar();
        
        //devolve o objeto proprietario
        return lista;
    }
    
}
