package com.coded2.sas.service.pessoa;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;

import com.coded2.infra.dao.TransactionInterceptor;
import com.coded2.infra.exception.BusinessExecption;
import com.coded2.infra.message.Message;
import com.coded2.infra.message.ReturnCode;
import com.coded2.infra.util.TextResrouce;
import com.coded2.infra.util.Util;
import com.coded2.infra.validation.ValidatorUtil;
import com.coded2.sas.dao.PessoaDAO;
import com.coded2.sas.entity.Pessoa;

/**
 * Session Bean implementation class PessoaBean
 */
@Stateless
public class PessoaBean  implements PessoaLocal {

	private static final long serialVersionUID = 1L;
	
	@Inject
	PessoaDAO dao;
	
	@Inject
	EntityManager em;
	
	@Interceptors({TransactionInterceptor.class})
	@Override
	public Message save(Pessoa pessoa) throws Exception {
		new ValidatorUtil().validate(pessoa);
		Message message = new Message();
		//valida se ja existe alguem com o mesmo cpf cadastro no sistema
		Pessoa consulta = new Pessoa();
		consulta.setCoCpf(pessoa.getCoCpf());
		List<Pessoa> search = dao.search(consulta);
		if(!Util.isEmpty(search)){
			throw new BusinessExecption(TextResrouce.ERR001);
		}
		dao.save(pessoa);
		message.setReturnCode(ReturnCode.OK);
		message.setText(TextResrouce.M001);
		return message;
	}

	@Override
	public Message search(Pessoa pessoa) throws Exception{
		Message message = new Message();
		List<Pessoa> pessoas = dao.search(pessoa);
		
		message.setResult(pessoas);
		message.setReturnCode(ReturnCode.OK);
		return message;
	}

	@Interceptors({TransactionInterceptor.class})
	@Override
	public Message remove(Pessoa pessoa) {
		Message message = new Message();
		dao.remove(pessoa);
		message.setReturnCode(ReturnCode.OK);
		message.setText(TextResrouce.M001);
		return message;
	}

	@Interceptors({TransactionInterceptor.class})
	@Override
	public Message update(Pessoa pessoa) {
		Message message = new Message();
		dao.update(pessoa);
		message.setReturnCode(ReturnCode.OK);
		message.setText(TextResrouce.M001);
		return message;
	}

}