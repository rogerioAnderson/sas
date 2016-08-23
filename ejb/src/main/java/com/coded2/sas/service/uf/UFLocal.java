package com.coded2.sas.service.uf;

import javax.ejb.Local;

import com.coded2.infra.message.Message;

@Local
public interface UFLocal {

	Message list() throws Exception;

}
