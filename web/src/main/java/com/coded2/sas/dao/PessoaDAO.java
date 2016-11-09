package com.coded2.sas.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.coded2.infra.dao.GenericDAO;
import com.coded2.infra.util.Util;
import com.coded2.sas.entity.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5627236023115843128L;

	
	@Override
	protected List<Predicate> searchConditions(Pessoa pessoa,CriteriaBuilder builder, Root<Pessoa> root,CriteriaQuery<Pessoa> query) {
	
		List<Predicate> conditions = new ArrayList<Predicate>();
		if (!Util.isEmpty(pessoa.getCoCpf())) {
			Predicate cpf = builder.equal(root.get("coCpf"),
					pessoa.getCoCpf());
			conditions.add(cpf);
		}
		if(!Util.isEmpty(pessoa.getNoPessoa())){
			Predicate predicate = builder.like(root.<String>get("noPessoa"), "%"+pessoa.getNoPessoa()+"%");
			conditions.add(predicate);
		}
		if(!Util.isEmpty(pessoa.getDeEmail())){
			Predicate predicate = builder.like(root.<String>get("deEmail"), "%"+pessoa.getDeEmail()+"%");
			conditions.add(predicate);
		}
		
		if(!Util.isEmpty(pessoa.getIcFuncao())){
			Predicate icFuncao = builder.equal(root.get("icFuncao"), pessoa.getIcFuncao());
			conditions.add(icFuncao);
		}
		return conditions;
	}

}