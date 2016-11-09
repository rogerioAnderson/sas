package com.coded2.infra.entity;

import java.io.Serializable;

public abstract class Model implements Serializable{

	private static final long serialVersionUID = 1L;

	public abstract Object getId();
	
}
