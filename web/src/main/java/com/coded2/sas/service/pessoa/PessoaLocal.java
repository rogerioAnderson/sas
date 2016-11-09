package com.coded2.sas.service.pessoa;

import java.io.Serializable;

import javax.ejb.Local;

import com.coded2.infra.message.Message;
import com.coded2.sas.entity.Pessoa;

@Local
public interface PessoaLocal extends Serializable{

	public Message save(Pessoa pessoa) throws Exception;

	public Message search(Pessoa pessoa) throws Exception;

	public Message remove(Pessoa pessoa) throws Exception;

	public Message update(Pessoa pessoa) throws Exception;
	

}
