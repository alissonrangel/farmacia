package br.ifce.dao;

import java.util.HashMap;

import javax.management.InstanceAlreadyExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceHibernate {
	
	public static PersistenceHibernate instance = null;
	
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	
	public PersistenceHibernate() {
		
		emf = Persistence.createEntityManagerFactory("Farmacia");
		
	}
	
	
	public static PersistenceHibernate getInstance(){
		if(instance == null){
			instance = new PersistenceHibernate();
		}
		
		return instance;
	}
	
	public EntityManager getEntityManager(){
		em = emf.createEntityManager();
		return em;
	}
	
	@Override
	protected void finalize() throws Throwable{
		
		super.finalize();
		
		if(em != null)
			em.close();
		
		emf.close();
	}
}
