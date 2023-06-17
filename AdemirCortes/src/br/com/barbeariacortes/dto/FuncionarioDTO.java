/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.barbeariacortes.dto;

/**
 *
 * @author user
 */
public class FuncionarioDTO extends Usuario {

    private Float salario;
    private int categoria;

    public FuncionarioDTO( String nome, String email, String cpf, String senha,Float salario, int categoria) {
        super(nome, email, cpf, senha);
        this.salario = salario;
        this.categoria = categoria;
    }

    public FuncionarioDTO(String email, String senha) {
        super(email, senha);
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

}
