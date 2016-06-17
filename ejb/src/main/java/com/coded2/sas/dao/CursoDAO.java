package com.coded2.sas.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.coded2.infra.dao.GenericDAO;
import com.coded2.infra.util.Util;
import com.coded2.sas.entity.Curso;

public class CursoDAO extends GenericDAO<Curso> {

	
	private static final long serialVersionUID = 5123610291508561470L;

	@Override
	protected List<Predicate> searchConditions(Curso obj,
			CriteriaBuilder builder, Root<Curso> root,
			CriteriaQuery<Curso> query) throws Exception {
		
		List<Predicate> conditions = new ArrayList<Predicate>();
		
		
		
		Predicate dtFim = builder.isNull(root.get("dtFim"));
		conditions.add(dtFim);
		
		query.orderBy(builder.asc(root.get("noCurso")));
		
		if(!Util.isEmpty(obj.getNoCurso())){
			Predicate noCurso = builder.equal(root.get("noCurso"), obj.getNoCurso());
			conditions.add(noCurso);
		}
		
		return conditions;
	}

}
