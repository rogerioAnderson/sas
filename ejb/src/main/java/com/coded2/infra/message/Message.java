package com.coded2.infra.message;

import java.io.Serializable;

public class Message implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private ReturnCode returnCode ;
	private Object result;
	private String text;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ReturnCode getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(ReturnCode returnCode) {
		this.returnCode = returnCode;
	}
	
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
}