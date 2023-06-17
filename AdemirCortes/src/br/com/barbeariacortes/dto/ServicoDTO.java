package br.com.barbeariacortes.dto;

public class ServicoDTO {

    private static Long id = 0L;
    private String nome;
    private String descricao;
    private float preco;

    public ServicoDTO( String nome, String descricao, float preco) {
        this.id = id + 1;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

}
