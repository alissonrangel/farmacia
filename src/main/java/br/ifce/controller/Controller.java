package br.ifce.controller;



import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;

import br.ifce.dao.FuncionarioDao;
import br.ifce.entity.Funcionario;

/**
 *
 * @author Alisson
 */
@ManagedBean  //para conectar com as páginas
@SessionScoped
public class Controller implements Serializable{
    
    private Funcionario funcionario;
    private DataModel listaFuncionarios;

    public Controller() {
        funcionario = new Funcionario();
        
    }
    
    public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public DataModel getListaFuncionarios() {
		
		FuncionarioDao fD = new FuncionarioDao();
		listaFuncionarios = new ListDataModel(fD.readByName(null));
		return listaFuncionarios;
	}
	
	public void setListaFuncionarios(DataModel listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}



/*	public ContatoBean getContatoB() {
        return contatoB; é FUNCIONARIO
    }

    public void setContatoB(ContatoBean contatoB) {
        this.contatoB = contatoB;
    }*/

    /*public DataModel getListaContatos() {
        
        ContatoDAO cD = new ContatoDAO();
        
        listaContatos = new ListDataModel(cD.listarContato());
        
        return listaContatos;
    }*/

   /* public void setListaContatos(DataModel listaContatos) {
        this.listaContatos = listaContatos;
    }
    */
	
    public void novoFuncionario(){
        funcionario = new Funcionario();
        
    }
    
    public void selecionarFuncionario(){
        funcionario = (Funcionario)listaFuncionarios.getRowData();
    }
    
    public String salvaFuncionario(){
        FuncionarioDao fD = new FuncionarioDao();
        
        if(fD.create(funcionario)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso", ""));
            return "ListarFuncionarios";
        }
             
        return "erro";
    }
    
    public String editarFuncionario(){
        FuncionarioDao fD = new FuncionarioDao();
        
        if(fD.update(funcionario)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Editado com sucesso", ""));
            return "ListarFuncionarios";
        }
             
        return "erro";
    }
    
    /*public String excluirFuncionario(){
        FuncionarioDao fD = new FuncionarioDao();
        
        if(fD.delete(funcionario)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Excluido com sucesso", ""));
            return "ListarFuncionarios";
        }
             
        return "erro";
    }*/
    
    public String excluirFuncionario(){
        FuncionarioDao fD = new FuncionarioDao();
        int i = funcionario.getId();
        if(fD.obterPorId(i)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Excluido com sucesso", ""));
            return "ListarFuncionarios";
        }
             
        return "erro";
    }
    
    public String login(){
    	
    	FuncionarioDao fD = new FuncionarioDao();
    	
    	List<Funcionario> lista = fD.readOnlyName(funcionario.getNome());
    	
    	List<Funcionario> lista2 = fD.readOnlyName(funcionario.getNome());
    	
    	for (Funcionario func : lista) {
			if ( func.getNome().equals(funcionario.getNome()) ){
				
				if ( funcionario.getSenha().equals("123")){
					return "pageAdmin";
					
				}
				
			}
		}
    	
    	for (Funcionario func2 : lista2) {
    		if ( func2.getNome().equals(funcionario.getNome()) ){
				
				if ( funcionario.getSenha().equals(func2.getSenha()) ){
					return "pageFunc";
					
				}
				
			}
		}
    	
    	return "index";
    }
 
}
