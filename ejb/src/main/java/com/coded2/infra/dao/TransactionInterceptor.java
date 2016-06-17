package com.coded2.infra.dao;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TransactionInterceptor {

	@Inject
	EntityManager em;
	
	@AroundInvoke
	public Object transactionControl(InvocationContext context)throws Exception{
		Object result = null;
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		result = context.proceed();
		transaction.commit();
		return result;
	}
}
