package com.coded2.sas.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.coded2.infra.dao.GenericDAO;
import com.coded2.infra.util.Util;
import com.coded2.sas.entity.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario> {

		private static final long serialVersionUID = 2460548426759409601L;

		public Usuario getUserToLogin(Usuario user) {
		
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);
		Root<Usuario> root = query.from(Usuario.class);
		query.select(root);
		
		Predicate email = builder.equal(root.get("deEmail"), user.getDeEmail());
		Predicate senha = builder.equal(root.get("coSenha"), user.getCoSenha());
		query.where(email,senha);
		
		List<Usuario> retorno = em.createQuery(query).getResultList();
		
		if(retorno.size()==1)
			return retorno.get(0);
		
		return null;
		
	}

	@Override
		protected List<Predicate> searchConditions(Usuario obj,
			CriteriaBuilder builder, Root<Usuario> root,
			CriteriaQuery<Usuario> query) throws Exception {
		List<Predicate> conditions = new ArrayList<Predicate>();
		
		if(!Util.isEmpty(obj.getDeEmail())){
			Predicate deEmail = builder.equal(root.get("deEmail"),obj.getDeEmail());
			conditions.add(deEmail);
		}
		return conditions;
	}

}
