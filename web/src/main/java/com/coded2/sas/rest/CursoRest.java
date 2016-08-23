
package com.coded2.sas.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.coded2.infra.message.Message;
import com.coded2.sas.entity.Curso;
import com.coded2.sas.service.curso.CursoLocal;

@Path("/curso")

public class CursoRest {

	
	
	@EJB
	CursoLocal service;
	
	@POST
	@Path("save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(Curso curso){
		Message message = service.save(curso);
		return Response.ok(message).build();
	}
	
	
	@POST
	@Path("search")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response search(Curso curso) throws Exception{
		Message message = service.search(curso);
		return Response.ok(message).build();
	}
	
	@POST
	@Path("remove")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(Curso curso) throws Exception{
		Message message = service.remove(curso);
		return Response.ok(message).build();
	}
	
	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Curso curso) throws Exception{
		Message message = service.update(curso);
		return Response.ok(message).build();
	}
	
	
}
