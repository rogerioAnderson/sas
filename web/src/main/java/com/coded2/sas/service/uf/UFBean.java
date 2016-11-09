package com.coded2.sas.service.uf;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.coded2.infra.message.Message;
import com.coded2.infra.message.ReturnCode;
import com.coded2.sas.dao.UfDAO;
import com.coded2.sas.entity.UF;

@Stateless
public class UFBean implements UFLocal{

	@Inject
	UfDAO ufDAO;
	
	@Override
	public Message list() throws Exception {
		Message message = new Message();
		message.setResult(ufDAO.search(new UF()));
		message.setReturnCode(ReturnCode.OK);
		return message;
	}

}