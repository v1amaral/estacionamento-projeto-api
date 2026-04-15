package br.com.parking.dao;

import br.com.parking.model.VagaEstacionamento;
import br.com.parking.util.EntityManagerProvider;

public class VagaEstacionamentoDao {

    public void cadastrarVaga(VagaEstacionamento vagaEstacionamento){
        EntityManagerProvider.getEm().persist(vagaEstacionamento);
    }

}
