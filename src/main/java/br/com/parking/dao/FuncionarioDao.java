package br.com.parking.dao;

import br.com.parking.model.Funcionario;
import br.com.parking.util.EntityManagerProvider;

public class FuncionarioDao {

    public void cadastrarFuncionario(Funcionario funcionario){
        EntityManagerProvider.getEm().persist(funcionario);
    }

    public Funcionario buscarUsuario(String usuario, String senha){
        String jpql = "SELECT f FROM Funcionario f WHERE f.usuario = :usuario AND f.senha = :senha";
        return EntityManagerProvider.getEm().createQuery(jpql, Funcionario.class)
                .setParameter("usuario", usuario)
                .setParameter("senha", senha)
                .getSingleResult();
    }
}
