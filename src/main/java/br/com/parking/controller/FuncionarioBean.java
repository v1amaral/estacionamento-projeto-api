
package br.com.parking.controller;

import br.com.parking.dao.FuncionarioDao;
import br.com.parking.model.Funcionario;
import br.com.parking.service.EntityManagerProvider;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import java.io.Serializable;

@Named
@ViewScoped
public class FuncionarioBean implements Serializable{
    private EntityManager em = EntityManagerProvider.getEm();
    private FuncionarioDao dao = new FuncionarioDao();
    private Funcionario funcionario = new Funcionario();
    private String usuario;
    private String senha;
    
    
    public void salvar(){
        em.getTransaction().begin();
        dao.cadastrarFuncionario(funcionario);
        em.getTransaction().commit();
        em.close();
    }
    
    
public String logar() {
    try {
        Funcionario funcionarioBanco = dao.buscarUsuario(usuario, senha);
        
        if (funcionarioBanco != null) {
            if (funcionarioBanco.getUsuario().equalsIgnoreCase(usuario) && funcionarioBanco.getSenha().equals(senha)) {
                return "VagasEstacionamento?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválidos.", ""));
                return null;
            }
        }

        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválidos.", ""));
        return null;
    } catch (NoResultException e) {
        e.printStackTrace();
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválidos.", ""));
        return null;
    } catch (PersistenceException e) {
        e.printStackTrace();
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao conectar ao banco de dados.", ""));
        return null;
    } catch (Exception e){
        e.printStackTrace();
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao conectar ao banco de dados.", ""));
        return null;
    }
}
    
    public String paginaFuncionarios(){
        return "Funcionarios?faces-redirect=true";
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
