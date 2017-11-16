/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unifacs.ltp2.dao;

import br.unifacs.ltp2.connection.ConnectionFactory;
import br.unifacs.ltp2.model.Produto;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author adson
 */
public class ProdutoDAO {
     
    
    public void create(Produto produto){
        Connection  con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt =con.prepareStatement("INSERT INTO produto (descricao,quantidade,preco) VALUES(?,?,?)");
            stmt.setString(1, produto.getDescricao());
            stmt.setInt(2,produto.getQuantidade());
            stmt.setString(3, produto.getPreco());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Novo produto cadastrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastar novo produto");
            throw new  RuntimeException("Erro ao cadastar novo produto", ex);
        }finally{
            ConnectionFactory.CloseConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
    
    public List<Produto> read(){
        Connection  con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtosList = new ArrayList<>();
        try {
            stmt =con.prepareStatement("select * from produto");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setProduto_id(rs.getInt("produto_id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getString("preco"));
                produtosList.add(produto);
                
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler produtos");
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.CloseConnection((com.mysql.jdbc.Connection) con, stmt);
        }
       
        return produtosList;
    }

}
