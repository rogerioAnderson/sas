package com.coded2.sas.service.curso;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;		
import javax.interceptor.Interceptors;

import com.coded2.infra.dao.TransactionInterceptor;
import com.coded2.infra.message.Message;
import com.coded2.infra.message.ReturnCode;
import com.coded2.infra.util.TextResrouce;
import com.coded2.sas.dao.CursoDAO;
import com.coded2.sas.entity.Curso;

/**
 * Session Bean implementation class CursoBean
 */
@Stateless
public class CursoBean  implements CursoLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	CursoDAO dao;
	
	@Interceptors({TransactionInterceptor.class})
	@Override
	public Message save(Curso curso) {
		Message message = new Message();
		dao.save(curso);
		message.setReturnCode(ReturnCode.OK);
		message.setText(TextResrouce.M001);
		return message;
	}

	@Override
	public Message search(Curso curso) throws Exception{
		Message message = new Message();
		List<Curso> cursos = dao.search(curso);
		message.setResult(cursos);
		message.setReturnCode(ReturnCode.OK);
		return message;
	}

	@Interceptors({TransactionInterceptor.class})
	@Override
	public Message remove(Curso curso) {
		Message message = new Message();
		dao.remove(curso);
		message.setReturnCode(ReturnCode.OK);
		message.setText(TextResrouce.M001);
		return message;
	}

	@Interceptors({TransactionInterceptor.class})
	@Override
	public Message update(Curso curso) {
		Message message = new Message();
		dao.update(curso);
		message.setReturnCode(ReturnCode.OK);
		message.setText(TextResrouce.M001);
		return message;
	}

	
}