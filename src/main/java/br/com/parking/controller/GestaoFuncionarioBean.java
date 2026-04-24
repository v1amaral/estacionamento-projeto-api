
package br.com.parking.controller;

import br.com.parking.dao.FuncionarioDao;
import br.com.parking.model.Funcionario;
import br.com.parking.service.EntityManagerProvider;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import java.io.Serializable;

@Named
@ViewScoped
public class GestaoFuncionarioBean implements Serializable{
    private EntityManager em = EntityManagerProvider.getEm();
    private FuncionarioDao dao = new FuncionarioDao();
    private Funcionario funcionario = new Funcionario();
    
    public void salvar(){
        em.getTransaction().begin();
        dao.cadastrarFuncionario(funcionario);
        em.getTransaction().commit();
        em.close();
    }
    
    public String listarFuncionarios(){
        return "CadastradosGestaoFuncionarios?faces-redirect=true";
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    
    
}
