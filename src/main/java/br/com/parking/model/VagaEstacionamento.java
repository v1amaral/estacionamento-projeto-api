package br.com.parking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
public class VagaEstacionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vagaId;
    private Boolean ocupada;
    @OneToOne
    private Cliente cliente;
    private LocalTime inicioEstacionado;

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalTime getInicioEstacionado() {
        return inicioEstacionado;
    }

    public void setInicioEstacionado(LocalTime inicioEstacionado) {
        this.inicioEstacionado = inicioEstacionado;
    }
    
    public String tempoEstacionado() {
        if (this.inicioEstacionado == null) {
            return "Disponível";
        }

        Duration duracao = Duration.between(this.inicioEstacionado, LocalTime.now());

        long horas = duracao.toHours();
        long minutos = duracao.toMinutesPart();

        return String.format("%02dh%02d", horas, minutos);
    }
    
    
}
