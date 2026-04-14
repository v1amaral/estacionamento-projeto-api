package br.com.parking.dao;

import br.com.parking.model.Cliente;
import br.com.parking.util.EntityManagerProvider;

public class ClienteDao {

    public void cadastrarCliente(Cliente cliente){
        EntityManagerProvider.getEm().persist(cliente);
    }

}
