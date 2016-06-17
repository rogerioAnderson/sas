package com.coded2.sas.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.coded2.infra.message.Message;
import com.coded2.sas.entity.Disciplina;
import com.coded2.sas.service.disciplina.DisciplinaService;

@Path("/disciplina")

public class DisciplinaRest {

	
	
	@EJB
	DisciplinaService service;
	
	@POST
	@Path("save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(Disciplina disciplina){
		Message message = service.save(disciplina);
		return Response.ok(message).build();
	}
}
