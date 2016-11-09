package com.coded2.sas.service.curso;

import java.io.Serializable;

import javax.ejb.Local;

import com.coded2.infra.message.Message;
import com.coded2.sas.entity.Curso;

@Local
public interface CursoLocal extends Serializable{

	public Message save(Curso curso);

	public Message search(Curso curso) throws Exception;

	public Message remove(Curso curso);

	public Message update(Curso curso);
	
}