package br.com.parking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Cliente {
    @Id
    private Integer cpf;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String email;
    private LocalTime inicioEstacionado;

    public Cliente(Integer cpf, String nomeCompleto, String email) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }

    public Integer getCpf() {
        return cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public LocalTime getInicioEstacionado() {
        return inicioEstacionado;
    }

    public void setInicioEstacionado() {
        this.inicioEstacionado = LocalTime.now();
    }
}
