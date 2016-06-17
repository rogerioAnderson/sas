package com.coded2.infra.dao;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerProvider implements Serializable{
	
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -6409216142359286419L;
	
	@Produces
	@ApplicationScoped
	public EntityManagerFactory createFactory(){
		return Persistence.createEntityManagerFactory("default");
	}
	
	@Produces
	@RequestScoped
	public EntityManager getEntityManagerDefault(EntityManagerFactory factory){
		EntityManager manager = factory.createEntityManager();
		return manager;
	}
	
	public void finaliza(@Disposes EntityManager manager) {
			  manager.close();
		
	      
	   }
}
