package br.com.parking.view;

import br.com.parking.dao.FuncionarioDao;
import br.com.parking.model.Funcionario;
import br.com.parking.service.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.util.Scanner;

public class MenuPrincipal {
    EntityManager em = EntityManagerProvider.getEm();
    FuncionarioDao funcionarioDao = new FuncionarioDao();
    Scanner scan = new Scanner(System.in);

    public void telaInicial(){
        System.out.println("Bem-vindo ao sistema");
        while (true) {
            System.out.println("Digite seu usuário:");
            var usuario = scan.nextLine();
            System.out.println("Digite sua senha:");
            var senha = scan.nextLine();

            try {
                Funcionario f = funcionarioDao.buscarUsuario(usuario, senha);
                if (f.getSenha().equals(senha)) {
                    System.out.println("Acessando o sistema.");
                } else {
                    System.out.println("Usuário ou senha inválidos");
                }
            } catch (NoResultException e) {
                System.out.println("Usuário ou senha inválidos");
            }
        }
    }
}
