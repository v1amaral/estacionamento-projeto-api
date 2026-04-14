package br.com.parking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Cliente {
    @Id
    private String cpf;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private LocalTime inicioEstacionado;
}
