
package br.com.parking.controller;

import br.com.parking.model.Funcionario;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class GestaoFuncionarioBean implements Serializable{
    
    private Funcionario funcionario = new Funcionario();
    
    public void salvar(){
        System.out.println("Nome completo: " + funcionario.getNomeCompleto() + " - CPF: " + funcionario.getCpf() + " - Usuario: " + funcionario.getUsuario() + " - Senha: " + funcionario.getSenha());
    }
    
    public String listarFuncionarios(){
        return "CadastradosGestaoFuncionarios?faces-redirect=true";
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    
    
}
