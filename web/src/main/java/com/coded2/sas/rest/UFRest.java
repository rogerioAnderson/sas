package com.coded2.sas.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.coded2.infra.message.Message;
import com.coded2.sas.service.uf.UFLocal;

@Path("uf")
public class UFRest {

	
	@EJB
	UFLocal service;
	
	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() throws Exception{
		Message message = service.list();
		return Response.ok(message).build();
	}
}