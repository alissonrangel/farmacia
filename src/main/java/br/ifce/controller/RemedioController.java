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


import br.ifce.dao.RemedioDao;

import br.ifce.entity.Remedio;

/**
 *
 * @author Alisson
 */
@ManagedBean  //para conectar com as páginas
@SessionScoped
public class RemedioController implements Serializable{
    
    private Remedio remedio;
    private DataModel listaRemedios;
    
    private DataModel listaPesquisaNomeRem;
    
    public RemedioController() {
        remedio = new Remedio();
        
    }
    
    
	public Remedio getRemedio() {
		return remedio;
	}


	public void setRemedio(Remedio remedio) {
		this.remedio = remedio;
	}


	public DataModel getListaRemedios() {
		
		RemedioDao rD = new RemedioDao();
		listaRemedios = new ListDataModel(rD.readByName(null));
		return listaRemedios;
	}
	
	public void setListaRemedios(DataModel listaRemedios) {
		this.listaRemedios = listaRemedios;
	}
	
	public DataModel getListaPesquisaNomeRem() {
		String pesquisa = null;
		if(!remedio.getNomeRe().equals(null))
			pesquisa = remedio.getNomeRe();
		
		RemedioDao rD = new RemedioDao();
		listaPesquisaNomeRem = new ListDataModel(rD.readByName(pesquisa));
		
		return listaPesquisaNomeRem;
	}
	
	public String listarPesquisaNomeRem() {
		String pesquisa = null;
		if(!remedio.getNomeRe().equals(null))
			pesquisa = remedio.getNomeRe();
		
		RemedioDao rD = new RemedioDao();
		listaPesquisaNomeRem = new ListDataModel(rD.readByName(pesquisa));
		
		return "PesquisarRemedios";
	}

	public void setListaPesquisaNomeRem(DataModel listaPesquisaNomeRem) {
		this.listaPesquisaNomeRem = listaPesquisaNomeRem;
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
	


	public void novoRemedio(){
        remedio = new Remedio();
        
    }
    
    public void selecionarRemedio(){
        remedio = (Remedio)listaRemedios.getRowData();
    }
    
    public String salvaRemedio(){
        RemedioDao rD = new RemedioDao();
        
        if(rD.create(remedio)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso", ""));
            return "ListarRemedios";
        }
             
        return "erro";
    }
    
    public String editarRemedio(){
        RemedioDao rD = new RemedioDao();
        
        if(rD.update(remedio)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Editado com sucesso", ""));
            return "ListarRemedios";
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
    
    public String excluirRemedio(){
    	RemedioDao rD = new RemedioDao();
        int i = remedio.getId();
        if(rD.obterPorIdRem(i)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Excluido com sucesso", ""));
            return "ListarRemedios";
        }
             
        return "erro";
    }
    
    /*public String login(){
    	
    	FuncionarioDao fD = new FuncionarioDao();
    	
    	List<Funcionario> lista = fD.readOnlyName(funcionario.getNome());
    	
    	for (Funcionario func : lista) {
			if ( func.getNome().equals(funcionario.getNome()) ){
				
				if ( funcionario.getSenha().equals("123")){
					return "pageAdmin";
					
				}
				
			}
		}
    	
    	return "index";
    }*/
 
}
