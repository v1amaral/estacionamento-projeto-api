package br.com.parking.controller;

import br.com.parking.model.VagaEstacionamento;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Locale;

@Named
@ViewScoped
public class FiltragemBean implements Serializable {

    public boolean filtroGlobal(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();

        if (filterText == null || filterText.isEmpty()) {
            return true;
        }

        VagaEstacionamento vaga = (VagaEstacionamento) value;

        boolean nomeMatch = false;
        boolean cpfMatch = false;

        if (vaga.getCliente() != null) {
            nomeMatch = vaga.getCliente().getNomeCompleto() != null && 
                        vaga.getCliente().getNomeCompleto().toLowerCase().contains(filterText);

            cpfMatch = vaga.getCliente().getCpfFormatado() != null && 
                       vaga.getCliente().getCpfFormatado().contains(filterText);
        }

        boolean idMatch = String.valueOf(vaga.getVagaId()).contains(filterText);
        boolean ocupadoMatch = vaga.ocupadoStr() != null && 
                               vaga.ocupadoStr().toLowerCase().contains(filterText);

        return nomeMatch || cpfMatch || idMatch || ocupadoMatch;
    }
}