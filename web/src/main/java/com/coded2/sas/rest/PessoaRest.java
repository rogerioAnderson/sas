
package com.coded2.sas.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.coded2.infra.message.Message;
import com.coded2.sas.entity.Pessoa;
import com.coded2.sas.service.pessoa.PessoaLocal;

@Path("/pessoa")

public class PessoaRest {

	
	
	@EJB
	PessoaLocal service;
	
	@POST
	@Path("save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(Pessoa pessoa) throws Exception{
		Message message = service.save(pessoa);
		return Response.ok(message).build();
	}
	
	
	@POST
	@Path("search")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response search(Pessoa pessoa) throws Exception{
		Message message = service.search(pessoa);
		return Response.ok(message).build();
	}
	
	@POST
	@Path("remove")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(Pessoa pessoa) throws Exception{
		Message message = service.remove(pessoa);
		return Response.ok(message).build();
	}
	
	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Pessoa pessoa) throws Exception{
		Message message = service.update(pessoa);
		return Response.ok(message).build();
	}
	
	
}
