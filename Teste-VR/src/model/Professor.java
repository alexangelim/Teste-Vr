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
public class Professor {
    
    private int codigo;
    private String nome;
    private String rg;
    private String cpf;
    private String titulo;

    public Professor(String nome, String rg, String cpf, String titulo) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.titulo = titulo;
    }

    public Professor(int codigo) {
        this.codigo = codigo;
    }

    public Professor(int codigo, String nome, String rg, String cpf, String titulo) {
        this.codigo = codigo;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.titulo = titulo;
    }
    
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}
