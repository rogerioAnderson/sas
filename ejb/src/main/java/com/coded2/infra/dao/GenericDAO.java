package com.coded2.infra.dao;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.coded2.infra.entity.Model;
import com.coded2.infra.util.Util;




public abstract class GenericDAO<MODEL extends Model> implements Serializable{

	
	private static final long serialVersionUID = 6817095545153300271L;


	@Inject
	protected EntityManager em;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<MODEL> search(MODEL obj)throws Exception{
		
		Class clazz = obj.getClass();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery query = builder.createQuery(clazz);
		Root<MODEL> root = query.from(clazz);
		query.select(root);
		
		
		List<Predicate> conditions = searchConditions(obj,builder,root,query);
		if (!Util.isEmpty(conditions)) {
			Predicate[] predicates = new Predicate[conditions.size()];
			conditions.toArray(predicates);
			query.where(predicates);
		}
		
		List<MODEL> retorno = em.createQuery(query).getResultList();
			
		return retorno;
	}

	
	
	@SuppressWarnings("unchecked")
	public MODEL searchById(MODEL obj){
		return (MODEL) em.find(obj.getClass(), obj.getId());
	}
	
	protected abstract List<Predicate> searchConditions(MODEL obj, CriteriaBuilder builder, Root<MODEL> root, CriteriaQuery<MODEL> query) throws Exception;

	public void save(MODEL obj){
		em.persist(obj);
	}
	
	@SuppressWarnings("unchecked")
	public void remove(MODEL model){
		model = (MODEL) em.getReference(model.getClass(), model.getId());
		em.remove(model);
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	public void update(MODEL model){
		em.merge(model);
	}
}
