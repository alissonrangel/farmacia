package br.ifce.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.ifce.entity.Funcionario;
import br.ifce.entity.Remedio;

//import br.edu.ifce.exception.DAOException;

public class Crud<E> {
	
	private EntityManager em = null;
	
	public Crud(){
		em = PersistenceHibernate.getInstance().getEntityManager();
	}
	
	public boolean create(E e){
		
		em.getTransaction().begin();
		try {
			
			
			em.merge(e);
			
			em.getTransaction().commit();
			
			return true;
		} catch (Exception e2) {
			
			e2.printStackTrace();
			em.getTransaction().rollback();
		} 
		
		return false;
	}
	
	/*public List<T> add(List<T> list) throws DAOException{
		EntityManager entityManager = getEMFactory().createEntityManager();
		entityManager.getTransaction().begin();
		try {
			for (T t : list) {
				entityManager.persist(t);
			}
			entityManager.getTransaction().commit();
			return list;
		}catch(PersistenceException e){
			renewEMFactory();
			throw new DAOException("Aguarde um momento, estamos reconectando com o servidor!", e); 
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new DAOException(e);
		}finally{
			entityManager.close();
		}
	 }*/
	
	public boolean update(E e){
		
		em.getTransaction().begin();
		try{
		em.merge(e);
		
		em.getTransaction().commit();
		
		return true;
		}catch (Exception e2){
			em.getTransaction().rollback();
		}
		
		return false;
	}
	
	public boolean delete(E e){
		
		em.getTransaction().begin();
		
		try{
		em.remove(e);
		
		em.getTransaction().commit();
		
		return true;
		
		}catch(Exception e2){
			e2.printStackTrace();
			em.getTransaction().rollback();
		}
		
		return false;
		
	}

	public boolean obterPorId(int id){
		
		
		Funcionario  func = null;
		//emf = Persistence.createEntityManagerFactory("rangel");
		//em = emf.createEntityManager();
		
		em.getTransaction().begin(); //abrir a conexão com o BD
		
		try{
		  func = em.find(Funcionario.class, id);  
		
		  em.remove(func);
		  
		 em.getTransaction().commit(); //para executar isso no BD
		
		return true;
		
		}catch(Exception ee){
			ee.getStackTrace();
			em.getTransaction().rollback();
		}
		
		return false;
		
	}
	
public boolean obterPorIdRem(int id){
		
		
		Remedio  rem = null;
		//emf = Persistence.createEntityManagerFactory("rangel");
		//em = emf.createEntityManager();
		
		em.getTransaction().begin(); //abrir a conexão com o BD
		
		try{
		   rem = em.find(Remedio.class, id);  
		
		  em.remove(rem);
		  
		 em.getTransaction().commit(); //para executar isso no BD
		
		return true;
		
		}catch(Exception ee){
			ee.getStackTrace();
			em.getTransaction().rollback();
		}
		
		return false;
		
	}

}
