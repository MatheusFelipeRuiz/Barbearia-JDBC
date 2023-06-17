package br.com.barbeariacortes.dto;

public class AgendamentoDTO {

    private static Long id;
    private String dataHora;
    private ClienteDTO cliente;
    private boolean status;
    private float preco;

    public AgendamentoDTO(String dataHora, ClienteDTO cliente, boolean status, float preco) {
        this.id += 1;
        this.dataHora = dataHora;
        this.cliente = cliente;
        this.status = status;
        this.preco = preco;
    }

    public static Long getId() {
        return id;
    }

    public static void setId(Long id) {
        AgendamentoDTO.id = id;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

}
