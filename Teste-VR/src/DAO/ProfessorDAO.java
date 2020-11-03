/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Professor;

/**
 *
 * @author usr
 */
public class ProfessorDAO {
    
    public void insereProfessor (Professor p) throws SQLException {
        
        Connection con = Conexao.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
        stmt = (PreparedStatement) con.prepareStatement("INSERT INTO PUBLIC.\"PROFESSOR\" (NOME, RG, CPF, TITULO) values (?,?,?,?)");
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getRg());
        stmt.setString(3, p.getCpf());
        stmt.setString(4, p.getTitulo());
        stmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null,"Pofessor Cadastrado com sucesso!");
        
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao inserir dados", ex);
        } finally {
            
            //Conexao.closeConnection(con, stmt);
        }
        
    }
    
    public void atualizaProfessor (Professor p) throws SQLException{
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("UPDATE PUBLIC.\"PROFESSOR\" SET NOME = ?, RG = ?,CPF = ?, TITULO = ? WHERE CODIGO = ?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getRg());
            stmt.setString(3, p.getCpf());
            stmt.setString(4, p.getTitulo());
            stmt.setInt(5, p.getCodigo());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Registro alterado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao atualizar os dados: ", ex);
        } finally {
            //Conexao.closeConnection(con, stmt);
        }
    }
    
    public void deletaProfessor (Professor p) throws SQLException{
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM PUBLIC.\"PROFESSOR\" WHERE CODIGO = ?");
            stmt.setInt(1, p.getCodigo());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!");
        } catch (SQLException ex) {
            
            throw new RuntimeException("Problemas ao realizar exclusão: ", ex);
        } finally {
            //Conexao.closeConnection(con, stmt);
        }
    }
    
    public List<Professor> Listar() throws SQLException{
        
        Connection con = Conexao.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<Professor> professors = new ArrayList<>();
        
        try {
            statement = (PreparedStatement) con.prepareStatement("SELECT * FROM PUBLIC.\"PROFESSOR\" ORDER BY NOME");
            result = statement.executeQuery();
            
            while (result.next()) {
                
                Professor P = new Professor(0);
                
                P.setNome(result.getString("NOME"));
                P.setRg(result.getString("RG"));
                P.setCpf(result.getString("CPF"));
                P.setTitulo(result.getString("TITULO"));
                P.setCodigo(Integer.parseInt(result.getString("CODIGO")));
                
                professors.add(P);
                
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Problema ao listar os dados: ", ex);
        }finally{
            //Conexao.closeConnection(con, statement);
        }
        
        return professors;
    }
    
    public List<Professor> readMestre() throws SQLException{
        String sql;
        Connection con = Conexao.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<Professor> professores = new ArrayList<>();
        
        try {
            sql = "select * "
                 +  "from PUBLIC.\"PROFESSOR\" "
                 + "where (titulo = 'Mestre' or titulo = 'Doutor')";
            
            statement = (PreparedStatement) con.prepareStatement(sql);
            result = statement.executeQuery();
            
            while (result.next()) {
                
                Professor p = new Professor(0);
                
                p.setNome(result.getString("NOME"));
                p.setRg(result.getString("RG"));
                p.setCpf(result.getString("CPF"));
                p.setTitulo(result.getString("TITULO"));
                p.setCodigo(Integer.parseInt(result.getString("CODIGO")));
                
                professores.add(p);
                
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Problema ao listar os dados: ", ex);
        }finally{
            //Conexao.closeConnection(con, statement);
        }
        
        return professores;
    }
    
}
