package com.coded2.sas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/seguranca")
public class Seguranca {

	
	@GET
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login() throws Exception{
		throw new Exception("MERDA TRATADA");
	}
}