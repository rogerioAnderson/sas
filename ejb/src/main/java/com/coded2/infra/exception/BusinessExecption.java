package com.coded2.infra.exception;

public class BusinessExecption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public BusinessExecption() {
		super();
	}
	
	public BusinessExecption(String message){
		super(message);
	}
}
