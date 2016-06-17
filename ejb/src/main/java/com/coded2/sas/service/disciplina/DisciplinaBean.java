package com.coded2.sas.service.disciplina;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import com.coded2.infra.dao.TransactionInterceptor;
import com.coded2.infra.message.Message;
import com.coded2.infra.message.ReturnCode;
import com.coded2.sas.dao.DisciplinaDAO;
import com.coded2.sas.entity.Disciplina;

/**
 * Session Bean implementation class DisciplinaBean
 */
@Stateless
public class DisciplinaBean  implements DisciplinaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	DisciplinaDAO dao;
	
	@Interceptors({TransactionInterceptor.class})
	@Override
	public Message save(Disciplina disciplina) {
		Message message = new Message();
		dao.save(disciplina);
		message.setReturnCode(ReturnCode.OK);
		message.setText("saved!!");
		
		
		return message;
	}

	
}