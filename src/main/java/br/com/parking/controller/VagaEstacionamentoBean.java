
package br.com.parking.controller;

import br.com.parking.dao.VagaEstacionamentoDao;
import br.com.parking.model.VagaEstacionamento;
import br.com.parking.service.EntityManagerProvider;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.property.access.spi.Getter;

@Named
@ViewScoped
public class VagaEstacionamentoBean implements Serializable{
    private EntityManager em = EntityManagerProvider.getEm();
    private VagaEstacionamentoDao dao = new VagaEstacionamentoDao();
    private VagaEstacionamento vagaEstacionamento = new VagaEstacionamento();
    private List<VagaEstacionamento> vagas = new ArrayList();
    private VagaEstacionamento vagaSelecionada; 
    private List<VagaEstacionamento> vagasFiltradas;

    public List<VagaEstacionamento> getVagasFiltradas() {
        return vagasFiltradas;
    }

    public void setVagasFiltradas(List<VagaEstacionamento> vagasFiltradas) {
        this.vagasFiltradas = vagasFiltradas;
    }

    public VagaEstacionamento getVagaSelecionada() {
        return vagaSelecionada;
    }

    public void setVagaSelecionada(VagaEstacionamento vagaSelecionada) {
        this.vagaSelecionada = vagaSelecionada;
    }
    
    public void setVagaEstacionamento(VagaEstacionamento VagaEstacionamento) {
        this.vagaEstacionamento = VagaEstacionamento;
    }

    public List<VagaEstacionamento> getVagas() {
        return vagas;
    }
    
    public void todasVagas(){
        this.vagas = dao.listarVagas();
    }
    
    public void visualizar(){
        FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, vagaSelecionada.getCliente().getNomeCompleto(), ""));
    }
    
    
    
}
