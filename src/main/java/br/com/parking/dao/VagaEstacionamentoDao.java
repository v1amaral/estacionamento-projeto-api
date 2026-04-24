package br.com.parking.dao;

import br.com.parking.model.VagaEstacionamento;
import br.com.parking.service.EntityManagerProvider;

public class VagaEstacionamentoDao {

    public void cadastrarVaga(VagaEstacionamento vagaEstacionamento){
        EntityManagerProvider.getEm().persist(vagaEstacionamento);
    }

}
