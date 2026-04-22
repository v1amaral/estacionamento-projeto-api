package br.com.parking.model;

import jakarta.persistence.*;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funcionarioId;
    @Column(unique = true, nullable = false)
    private Long cpf;
    private String nomeCompleto;
    @Column(unique = true, nullable = false)
    private String usuario;
    private String senha;

    public Funcionario() {
    }

    public Funcionario(Long cpf, String nomeCompleto, String usuario, String senha) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
}
