/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unifacs.ltp2.connection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author adson
 */
public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL   = "jdbc:mysql://127.0.0.1:3306/crud_java";
    private static final String USER  = "root";
    private static final String PASSWORD  = "root";
    
    /**
    *
    * classe que realiza a conexão com o banco
    */
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return  (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão");
            throw new  RuntimeException("Erro na conexão", ex);
        }   
    }
    
    public static void CloseConnection(Connection con){
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void CloseConnection(Connection con, PreparedStatement stmt){
        CloseConnection(con);
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
        
    public static void CloseConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        CloseConnection(con);
        CloseConnection(con, stmt);
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
