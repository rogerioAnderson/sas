package com.coded2.sas.service.disciplina;

import java.io.Serializable;

import javax.ejb.Local;

import com.coded2.infra.message.Message;
import com.coded2.sas.entity.Disciplina;

@Local
public interface DisciplinaLocal extends Serializable{

	public Message save(Disciplina disciplina);

	public Message search(Disciplina disciplina) throws Exception;

	public Message remove(Disciplina disciplina);

	public Message update(Disciplina disciplina);
	
}