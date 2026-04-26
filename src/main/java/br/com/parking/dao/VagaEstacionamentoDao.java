package br.com.parking.dao;

import br.com.parking.model.VagaEstacionamento;
import br.com.parking.service.EntityManagerProvider;
import java.util.List;

public class VagaEstacionamentoDao {

    public void cadastrarVaga(VagaEstacionamento vagaEstacionamento){
        EntityManagerProvider.getEm().persist(vagaEstacionamento);
    }
    
    public List<VagaEstacionamento> listarVagas(){
        String jpql = "SELECT v FROM VagaEstacionamento v";
        return EntityManagerProvider.getEm().createQuery(jpql, VagaEstacionamento.class)
                    .getResultList();
    }
}
