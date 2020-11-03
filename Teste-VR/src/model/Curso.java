/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author usr
 */
public class Curso {
    
    private int codigo;
    private String descricao;
    private String duracao;
    private String periodo;
    private int qtdAluno;
    private int cargaHoraria;
    private int professor;

    public Curso(int codigo, String descricao, String duracao, String periodo, int qtdAluno, int cargaHoraria, int professor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.duracao = duracao;
        this.periodo = periodo;
        this.qtdAluno = qtdAluno;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    public Curso(String descricao, String duracao, String periodo, int qtdAluno, int cargaHoraria, int professor) {
        this.descricao = descricao;
        this.duracao = duracao;
        this.periodo = periodo;
        this.qtdAluno = qtdAluno;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    public Curso(int codigo) {
        this.codigo = codigo;
    }

    public Curso(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getQtdAluno() {
        return qtdAluno;
    }

    public void setQtdAluno(int qtdAluno) {
        this.qtdAluno = qtdAluno;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    public int getProfessor() {
        return professor;
    }

    public void setProfessor(int professor) {
        this.cargaHoraria = professor;
    }
      
}
