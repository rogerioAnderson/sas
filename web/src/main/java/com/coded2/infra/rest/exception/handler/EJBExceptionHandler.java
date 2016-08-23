package com.coded2.infra.rest.exception.handler;
       
import java.util.ArrayList;
import java.util.Set;

import javax.ejb.EJBException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.coded2.infra.exception.BusinessExecption;
import com.coded2.infra.message.Message;
import com.coded2.infra.message.ReturnCode;

@Provider
public class EJBExceptionHandler implements ExceptionMapper<EJBException>{

	@Override
	public Response toResponse(EJBException ex) {
		if(ex.getCause() instanceof BusinessExecption){
			BusinessExceptionHandler handler = new BusinessExceptionHandler();
			return handler.toResponse((BusinessExecption) ex.getCause());
		}
		
		String[] textMessage = getMessage(ex);
		Message message = new Message();
		message.setReturnCode(ReturnCode.ERROR);
		message.setText(textMessage);
		return Response.ok(message).build();
	}

	private String[] getMessage(EJBException ex) {
		ArrayList<String> text = new ArrayList<String>();
		if(ex.getCause() instanceof ConstraintViolationException){
			ConstraintViolationException cause = (ConstraintViolationException) ex.getCause();
			Set<ConstraintViolation<?>> constraintViolations = cause.getConstraintViolations();
			for (ConstraintViolation<?> constraintViolation : constraintViolations) {
				text.add(constraintViolation.getMessage());
			}
		}else{
			text.add("Houve um erro na sua Solicitação");
		}
	
		return text.toArray(new String[text.size()]);
	}

}
