package br.com.parking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VagaEstacionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vagaId;
    private Boolean ocupada;

    public VagaEstacionamento() {
    }

    public VagaEstacionamento(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Long getVagaId() {
        return vagaId;
    }
}
