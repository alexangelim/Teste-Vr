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
import model.Disciplina;

/**
 *
 * @author usr
 */
public class DisciplinaDAO {
    
    public void insereDisciplina (Disciplina d) throws SQLException{
        
        Connection con = Conexao.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
        stmt = (PreparedStatement) con.prepareStatement("INSERT INTO PUBLIC.\"DISCIPLINA\" (DESCRICAO,EMENTA,LIMITE_VAGA,COD_PROF,"
                    + "dia_semana,carga_hor)values(?,?,?,?,?,?)");
        stmt.setString(1, d.getDescricao());
        stmt.setString(2, d.getEmenta());
        stmt.setInt(3, d.getLimiteVaga());
        stmt.setInt(4, d.getProfessor());
        stmt.setString(5, d.getDiaSemana());
        stmt.setInt(6, d.getCargaHoraria());
        stmt.executeUpdate();
        
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao inserir dados", ex);
        } finally {
            
            //Conexao.closeConnection(con, stmt);
        }
        
    }
    
    public void atualizadisciplina (Disciplina d) throws SQLException{
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("UPDATE PUBLIC.\"DISCIPLINA\" SET DESCRICAO = ?, EMENTA = ?,LIMITE_VAGA = ?, COD_PROF = ?,"
                    + "DIA_SEMANA = ?, CARGA_HOR = ? WHERE CODIGO = ?");
            stmt.setString(1, d.getDescricao());
            stmt.setString(2, d.getEmenta());
            stmt.setInt(3, d.getLimiteVaga());
            stmt.setInt(4, d.getProfessor());
            stmt.setString(5, d.getDiaSemana());
            stmt.setInt(6, d.getCargaHoraria());
            stmt.setInt(7, d.getCodigo());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Registro alterado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao atualizar os dados: ", ex);
        } finally {
           // Conexao.closeConnection(con, stmt);
        }
    }
    
    public void deletadisciplina(Disciplina d) throws SQLException{
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM PUBLIC.\"DISCIPLINA\" WHERE CODIGO = ?");
            stmt.setInt(1, d.getCodigo());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!");
        } catch (SQLException ex) {
            
            throw new RuntimeException("Problemas ao realizar exclusão: ", ex);
        } finally {
            //Conexao.closeConnection(con, stmt);
        }
    }
    
    public List<Disciplina> Listar() throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<Disciplina> diciplinas = new ArrayList<>();
        
        try {
            statement = (PreparedStatement) conexao.prepareStatement("select * from PUBLIC.\"DISCIPLINA\"");
            result = statement.executeQuery();
            
            while (result.next()) {
                
                Disciplina d = new Disciplina(0);
                
                d.setDescricao(result.getString("descricao"));
                d.setEmenta(result.getString("ementa"));
                d.setLimiteVaga(Integer.parseInt(result.getString("limite_vaga")));
                d.setProfessor(Integer.parseInt(result.getString("cod_prof")));
                d.setDiaSemana(result.getString("dia_semana"));
                d.setCargaHoraria(Integer.parseInt(result.getString("carga_hor")));
                d.setCodigo(Integer.parseInt(result.getString("codigo")));
                
                diciplinas.add(d);
                
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Problema ao listar os dados: ", ex);
        }finally{
            //Conexao.closeConnection(conexao, statement);
        }
        
        return diciplinas;
    }
    
}
