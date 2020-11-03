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
public class Aluno {
    
    private int codigo;
    private String matricula;
    private String nome;
    private String cpf;
    private String rg;
    private String curso;

    public Aluno(String matricula, String nome, String cpf, String rg, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.curso = curso;
    }
    
    public Aluno(int codigo, String matricula, String nome, String cpf, String rg, String curso) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.curso = curso;
    }

    public Aluno(int codigo) {
        this.codigo = codigo;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    
    
    
    
}
