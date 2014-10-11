package br.ifce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ifce.entity.Remedio;

public class RemedioDao extends Crud<Remedio>{

	EntityManager em = null;
	
	public RemedioDao(){
		
		em = PersistenceHibernate.getInstance().getEntityManager();
		
	
	}
	
	public List<Remedio> readByName(String pesquisa){
		String sql = null;
		List<Remedio> listaRem = null;
		//jpql
		if( pesquisa != null ){
			sql = "select r from Remedio r where r.nomeRe like '%"+pesquisa+"%' order by r.nomeRe asc";
					 
			// order by r.nome asc";
			//sql="select * from pedido;";
		}else
			sql = "select r from Remedio r order by r.nomeRe asc";
		
		em.clear(); //para limpar a cache para enviar o valor real q tá no BD
		
		Query q = em.createQuery(sql);
		
		try {
			listaRem = (List<Remedio>)q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return listaRem;
	}
	
	
	
	
	@Override
	protected void finalize() throws Throwable{
		
		super.finalize();
			
		em.close();
		
	}
	
}
