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
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import model.Curso;

/**
 *
 * @author usr
 */
public class AlunoDAO {
    
    public void insereAluno (Aluno a, String Curso) throws SQLException {
        int qtdAluno; 
        int qtdCurso;
        String sql;
        ResultSet result = null;
        
        Connection con = Conexao.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
            sql = "SELECT ALN.QTD_CURSO, CUR.QTD_ALUNO FROM ( " +
                     "(SELECT COUNT(A.CURSO) QTD_CURSO " +
                        "FROM PUBLIC.\"ALUNO\" A " +
                       "WHERE A.CURSO = ?) ALN, " +
                     "(SELECT C.CODIGO || ' - ' || C.DESCRICAO CURSO, C.QTD_ALUNO " +
                        "FROM PUBLIC.\"CURSO\" C " +
                       "WHERE C.CODIGO || ' - ' || C.DESCRICAO = ?) CUR) ";
            
            stmt.setString(1, Curso);
            result = stmt.executeQuery();
            
            while (result.next()) {
                qtdAluno = result.getInt("QTD_ALUNO");
                qtdCurso = result.getInt("QTD_CURSO");
                 
                if (qtdAluno >= qtdCurso){
                    JOptionPane.showMessageDialog(null, "Limite do curso atingido!"); 
                    return;
                 }
            }         
              
        } catch (SQLException ex) {
            throw new RuntimeException("Aluno não cadastrado, verifique as informações: ", ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
        
        try {
        sql = "INSERT INTO PUBLIC.\"ALUNO\" (matricula, nome, rg, cpf, curso)values(?,?,?,?,?)";
        stmt =  (PreparedStatement) con.prepareStatement(sql);
        stmt.setString(1, a.getMatricula());
        stmt.setString(2, a.getNome());
        stmt.setString(3, a.getRg());
        stmt.setString(4, a.getCpf());
        stmt.setString(5, a.getCurso());
        stmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null,"Aluno Cadastrado com sucesso!");
        
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao inserir dados", ex);
        } finally {
            
            //Conexao.closeConnection(con, stmt);
        }
        
    }
    
    public void atualizaAluno (Aluno a) throws SQLException{
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("UPDATE PUBLIC.\"ALUNO\" SET MATRICULA = ?, NOME = ?,RG = ?, CPF = ?, CURSO = ? WHERE CODIGO = ?");
            stmt.setString(1, a.getMatricula());
            stmt.setString(2, a.getNome());
            stmt.setString(3, a.getRg());
            stmt.setString(4, a.getCpf());
            stmt.setString(5, a.getCurso());
            stmt.setInt(6, a.getCodigo());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Registro alterado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao atualizar os dados: ", ex);
        } finally {
            //Conexao.closeConnection(con, stmt);
        }
    }
    
    public void deletaAluno (Aluno a) throws SQLException {
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM PUBLIC.\"ALUNO\" WHERE CODIGO = ?");
            stmt.setInt(1, a.getCodigo());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!");
        } catch (SQLException ex) {
            
            throw new RuntimeException("Problemas ao realizar exclusão: ", ex);
        } finally {
            //Conexao.closeConnection(con, stmt);
        }
    }
    
    public List<Aluno> read() throws SQLException {
        
        Connection con = Conexao.getConnection();
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        List<Aluno> alunos = new ArrayList<>();
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM PUBLIC.\"ALUNO\" ORDER BY NOME");
            rs = stmt.executeQuery();
            
            while(rs.next()) {               
                Aluno a = new Aluno(rs.getInt("CODIGO"), rs.getString("MATRICULA"), 
                                    rs.getString("NOME"), rs.getString("CPF"), rs.getString("RG"),
                                    rs.getString("CURSO"));
                alunos.add(a);    
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao listar os dados: ", ex);
        } finally {
            //Conexao.closeConnection(con, stmt);
        }        
        return alunos;
    }
    
}
