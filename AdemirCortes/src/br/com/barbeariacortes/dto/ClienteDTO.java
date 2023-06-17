package br.com.barbeariacortes.dto;

public class ClienteDTO extends Usuario {

    private String nomeUsuario;

    public ClienteDTO(String nomeUsuario, String nome, String email, String cpf, String senha) {
        super(nome, email, cpf, senha);
        this.nomeUsuario = nomeUsuario;
    }

    public ClienteDTO(String email, String senha) {
        super(email, senha);
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

}
