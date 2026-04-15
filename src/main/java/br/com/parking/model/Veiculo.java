package br.com.parking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Veiculo {
    @Id
    private String placaId;
    private String tipoVeiculo;
    private String modelo;
    @ManyToOne
    @JoinColumn(name = "cliente_cpf")
    private Cliente cliente;

    public Veiculo(String placaId, String tipoVeiculo, String modelo, Cliente cliente) {
        this.placaId = placaId;
        this.tipoVeiculo = tipoVeiculo;
        this.modelo = modelo;
        this.cliente = cliente;
    }

    public String getPlacaId() {
        return placaId;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
