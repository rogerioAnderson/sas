package com.coded2.sas.dao;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.coded2.infra.dao.GenericDAO;
import com.coded2.sas.entity.UF;

@Singleton
public class UfDAO extends GenericDAO<UF>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected List<Predicate> searchConditions(UF obj, CriteriaBuilder builder,
			Root<UF> root, CriteriaQuery<UF> query) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	


}
