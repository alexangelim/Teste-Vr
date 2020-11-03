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
public class Disciplina {
    
    private int codigo;
    private String descricao;
    private String ementa;
    private int limiteVaga;
    private int professor;
    private String diaSemana;
    private int cargaHoraria;

    public Disciplina(String descricao, String ementa, int limiteVaga, int professor, String diaSemana, int cargaHoraria) {
        this.descricao = descricao;
        this.ementa = ementa;
        this.limiteVaga = limiteVaga;
        this.professor = professor;
        this.diaSemana = diaSemana;
        this.cargaHoraria = cargaHoraria;
    }

    public Disciplina(int codigo) {
        this.codigo = codigo;
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

    public void setDescricao(String descicao) {
        this.descricao = descicao;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public int getLimiteVaga() {
        return limiteVaga;
    }

    public void setLimiteVaga(int limiteVaga) {
        this.limiteVaga = limiteVaga;
    }

    public int getProfessor() {
        return professor;
    }

    public void setProfessor(int professor) {
        this.professor = professor;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    
    
}
