package com.coded2.sas.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.coded2.infra.dao.GenericDAO;
import com.coded2.infra.util.Util;
import com.coded2.sas.entity.Disciplina;

public class DisciplinaDAO extends GenericDAO<Disciplina> {

	private static final long serialVersionUID = 1L;

	@Override
	protected List<Predicate> searchConditions(Disciplina obj,
			CriteriaBuilder builder, Root<Disciplina> root,
			CriteriaQuery<Disciplina> query) throws Exception {
		
		List<Predicate> predicates = new ArrayList<Predicate>();

		//para buscar apenas as disciplinas ativas 
		//deve ser buscar as disciplinas que nao possui a data fim preenchida
		Predicate dtFim = builder.isNull(root.get("dtFim"));
		predicates.add(dtFim);
		
		
		if(!Util.isEmpty(obj.getNoDisciplina())){
			Predicate noDisciplina = builder.equal(root.get("noDisciplina"), obj.getNoDisciplina());
			predicates.add(noDisciplina);
		}

		
		query.orderBy(builder.asc(root.get("noDisciplina")));
		
		return predicates;
	}

}