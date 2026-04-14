package br.com.parking.DAO;

import br.com.parking.model.VagaEstacionamento;
import br.com.parking.util.EntityManagerProvider;
import jakarta.persistence.EntityManager;

public class VagaEstacionamentoDao {

    public void cadastrarVaga(VagaEstacionamento vagaEstacionamento){
        EntityManagerProvider.getEm().persist(vagaEstacionamento);
    }

}
