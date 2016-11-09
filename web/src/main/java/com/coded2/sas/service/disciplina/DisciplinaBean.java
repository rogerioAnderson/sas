package com.coded2.sas.service.disciplina;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import com.coded2.infra.dao.TransactionInterceptor;
import com.coded2.infra.message.Message;
import com.coded2.infra.message.ReturnCode;
import com.coded2.infra.util.TextResrouce;
import com.coded2.sas.dao.DisciplinaDAO;
import com.coded2.sas.entity.Disciplina;

/**
 * Session Bean implementation class DisciplinaBean
 */
@Stateless
public class DisciplinaBean  implements DisciplinaLocal {

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
		message.setText(TextResrouce.M001);
		return message;
	}

	@Override
	public Message search(Disciplina disciplina) throws Exception{
		Message message = new Message();
		List<Disciplina> disciplinas = dao.search(disciplina);
		message.setResult(disciplinas);
		message.setReturnCode(ReturnCode.OK);
		return message;
	}

	@Interceptors({TransactionInterceptor.class})
	@Override
	public Message remove(Disciplina disciplina) {
		Message message = new Message();
		dao.remove(disciplina);
		message.setReturnCode(ReturnCode.OK);
		message.setText(TextResrouce.M001);
		return message;
	}

	@Interceptors({TransactionInterceptor.class})
	@Override
	public Message update(Disciplina disciplina) {
		Message message = new Message();
		dao.update(disciplina);
		message.setReturnCode(ReturnCode.OK);
		message.setText(TextResrouce.M001);
		return message;
	}

	
}