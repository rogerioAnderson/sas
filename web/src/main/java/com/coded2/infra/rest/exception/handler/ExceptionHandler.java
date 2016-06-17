package com.coded2.infra.rest.exception.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.coded2.infra.message.Message;
import com.coded2.infra.message.ReturnCode;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception>{

	@Override
	public Response toResponse(Exception ex) {
		ex.printStackTrace();
		Message message = new Message();
		message.setReturnCode(ReturnCode.ERROR);
		message.setText("Houve um erro em sua solicitação");
		return Response.ok(message).build();
	}

}
