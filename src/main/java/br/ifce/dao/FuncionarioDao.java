package br.ifce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;



import br.ifce.entity.Funcionario;

public class FuncionarioDao extends Crud<Funcionario>{
	
	EntityManager em = null;
	
	public FuncionarioDao() {
		// TODO Auto-generated constructor stub		
		em = PersistenceHibernate.getInstance().getEntityManager();
		
	
	}
	
	public List<Funcionario> readByName(String pesquisa){
		String sql = null;
		List<Funcionario> listaFunc = null;
		//jpql
		if( pesquisa != null ){
			sql = "select f from Funcionario f where f.nome like '%"+pesquisa+"%' order by f.nome asc";
			//sql="select * from pedido;";
		}else
			sql = "select f from Funcionario f order by f.nome asc";
		
		em.clear(); //para limpar a cache para enviar o valor real q tá no BD
		
		Query q = em.createQuery(sql);
		try {
			listaFunc = (List<Funcionario>)q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return listaFunc;
	}
	
	public List<Funcionario> readOnlyName(String pesquisa){
		String sql = null;
		List<Funcionario> listaFunc = null;
		//jpql
		if( pesquisa != null ){
			sql = "select f from Funcionario f where f.nome like '"+pesquisa+"' order by f.nome asc";
			//sql="select * from pedido;";
		}else
			sql = "select f from Funcionario f order by f.nome asc";
		
		em.clear(); //para limpar a cache para enviar o valor real q tá no BD
		
		Query q = em.createQuery(sql);
		try {
			listaFunc = (List<Funcionario>)q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return listaFunc;
	}
	
	
	
	
	/*public boolean delete(Funcionario e){
		
		em.getTransaction().begin();
		
		try{
		em.remove(e);
		
		em.getTransaction().commit();
		return true;
		
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
		return false;
		
	}*/
	
	@Override
	protected void finalize() throws Throwable{
		
		super.finalize();
			
		em.close();
		
	}
}
