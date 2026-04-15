package br.com.parking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Funcionario {
    @Id
    private Long funcionarioId;
    private Byte cpf;
    private String nomeCompleto;
    private String usuario;
    private String senha;
}
