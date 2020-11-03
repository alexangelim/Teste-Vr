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
import model.Curso;

/**
 *
 * @author usr
 */
public class CursoDAO {
    
    public void insereCurso (Curso c) throws SQLException{
        
        Connection con = Conexao.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
        stmt = (PreparedStatement) con.prepareStatement("INSERT INTO PUBLIC.\"CURSO\" (DESCRICAO,DURACAO,PERIODO,QTD_ALUNO,CARGA_HOR, COD_PROF)values(?,?,?,?,?,?)");
        stmt.setString(1, c.getDescricao());
        stmt.setString(2, c.getDuracao());
        stmt.setString(3, c.getPeriodo());
        stmt.setInt(4, c.getQtdAluno());
        stmt.setInt(5, c.getCargaHoraria());
        stmt.setInt(6, c.getProfessor());
        stmt.executeUpdate();
        
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao inserir dados", ex);
        } finally {
            
            //Conexao.closeConnection(con, stmt);
        }
        
    }
    
    public void atualizaCurso (Curso c) throws SQLException{
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("update PUBLIC.\"CURSO\" set descricao = ?, duracao = ?,periodo = ?, qtd_aluno = ?, carga_hor = ?, professor = ? where codigo = ?");
            stmt.setString(1, c.getDescricao());
            stmt.setString(2, c.getDuracao());
            stmt.setString(3, c.getPeriodo());
            stmt.setInt(4, c.getQtdAluno());
            stmt.setInt(5, c.getCargaHoraria());
            stmt.setInt(6, c.getProfessor());
            stmt.setInt(7, c.getCodigo());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Registro alterado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao atualizar os dados: ", ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void deletaCurso(Curso c) throws SQLException{
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM PUBLIC.\"CURSO\" WHERE CODIGO = ?");
            stmt.setInt(1, c.getCodigo());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!");
        } catch (SQLException ex) {
            
            throw new RuntimeException("Problemas ao realizar exclusão: ", ex);
        } finally {
            //Conexao.closeConnection(con, stmt);
        }
    }
    
    public List<Curso> Listar() throws SQLException {
        
        Connection con = Conexao.getConnection();
        
        PreparedStatement stmt = null;
        String sql;
        
        ResultSet rs = null;
        
        List<Curso> cursos = new ArrayList<>();
        
        try {
            sql = "SELECT C.*, P.NOME " +
                    "FROM PUBLIC.\"CURSO\" C, PUBLIC.\"PROFESSOR\" P " +
                   "WHERE C.COD_PROF = P.CODIGO " +
                   "ORDER BY C.DESCRICAO";
            
            stmt = (PreparedStatement) con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {               
                Curso c = new Curso(rs.getInt("CODIGO"), rs.getString("DESCRICAO"), 
                                    rs.getString("DURACAO"), rs.getString("PERIODO"), rs.getInt("QTD_ALUNO"),
                                    rs.getInt("CARGA_HOR"), rs.getInt("COD_PROF"));
                cursos.add(c);    
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao listar os dados: ", ex);
        } finally {
            //Conexao.closeConnection(con, stmt);
        }        
        return cursos;
    }
    
    public List<Curso> ListarCombo() throws SQLException {
        
        Connection con = Conexao.getConnection();
        
        PreparedStatement stmt = null;
        String sql;
        
        ResultSet rs = null;
        
        List<Curso> cursos = new ArrayList<>();
        
        try {
            sql = "SELECT CODIGO, DESCRICAO FROM PUBLIC.\"CURSO\" ORDER BY DESCRICAO";
            
            stmt = (PreparedStatement) con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {               
                Curso c = new Curso(rs.getInt("CODIGO"), rs.getString("DESCRICAO"));
                cursos.add(c);    
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao listar os dados: ", ex);
        } finally {
            //Conexao.closeConnection(con, stmt);
        }        
        return cursos;
    }
    
}
