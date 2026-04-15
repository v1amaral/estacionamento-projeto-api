package br.com.parking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco_cliente")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String cidade;
    private String uf;
    private String bairro;
    @ManyToOne
    @JoinColumn(name = "cliente_cpf")
    private Cliente cliente;

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", bairro='" + bairro + '\'' +
                '}';
    }

    public void conversorEndereco(CepRecord cepRecord){
        this.cep = cepRecord.cep();
        this.bairro = cepRecord.bairro();
        this.uf = cepRecord.uf();
        this.logradouro = cepRecord.logradouro();
        this.cidade = cepRecord.localidade();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
