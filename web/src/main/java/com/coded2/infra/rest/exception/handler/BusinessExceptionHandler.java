package com.coded2.infra.rest.exception.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.coded2.infra.exception.BusinessExecption;
import com.coded2.infra.message.Message;
import com.coded2.infra.message.ReturnCode;

@Provider
public class BusinessExceptionHandler implements ExceptionMapper<BusinessExecption>{

	@Override
	public Response toResponse(BusinessExecption ex) {
		Message message = new Message();
		message.setReturnCode(ReturnCode.ERROR);
		message.setText(ex.getMessage());
		return Response.ok(message).build();
	}
}
