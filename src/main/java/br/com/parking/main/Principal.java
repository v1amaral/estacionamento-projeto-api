package br.com.parking.main;

import br.com.parking.dao.FuncionarioDao;
import br.com.parking.model.Funcionario;
import br.com.parking.util.EntityManagerProvider;
import br.com.parking.visual.MenuPrincipal;

public class Principal {
    static void main() {
        MenuPrincipal menu = new MenuPrincipal();

        menu.telaInicial();

        System.out.println("olá");
    }
}
