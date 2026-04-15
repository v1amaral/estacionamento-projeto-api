package br.com.parking.main;

import br.com.parking.dao.ClienteDao;
import br.com.parking.dao.VagaEstacionamentoDao;
import br.com.parking.model.Cliente;
import br.com.parking.model.VagaEstacionamento;
import br.com.parking.util.EntityManagerProvider;

public class Principal {
    static void main() {
        var em = EntityManagerProvider.getEm();

        VagaEstacionamento vagaEstacionamento = new VagaEstacionamento(false);
        Cliente cliente = new Cliente(2112412, "vitor amaral", "vitor@linkedby.us");
        ClienteDao vagaDao = new ClienteDao();

        em.getTransaction().begin();
        vagaDao.cadastrarCliente(cliente);
        em.getTransaction().commit();
        em.close();
    }
}
