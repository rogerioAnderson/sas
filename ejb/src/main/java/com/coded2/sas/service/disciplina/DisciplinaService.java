package com.coded2.sas.service.disciplina;

import java.io.Serializable;

import javax.ejb.Local;

import com.coded2.infra.message.Message;
import com.coded2.sas.entity.Disciplina;

@Local
public interface DisciplinaService extends Serializable{

	public Message save(Disciplina disciplina);
	
}