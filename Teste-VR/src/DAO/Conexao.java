/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author usr
 */
public class Conexao {
    
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL    = "jdbc:postgresql://localhost:5432/teste-vr";
    private static final String USER   = "postgres";
    private static final String PASS   = "postgres";
 
    
    public static Connection getConnection() throws SQLException{
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão!", ex); 
        }
    }
    
    public static void closeConnection(Connection con) {
        
        if (con != null){     
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro "+ex);
            }
        }
    }

    static void closeConnection(Connection con, PreparedStatement stmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
