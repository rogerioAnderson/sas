package com.coded2.infra.util;

import java.util.Collection;
import java.util.Date;

public class Util {

	public static boolean isEmpty(Object objeto){
		if(objeto instanceof String)
			return stringIsEmpty((String)objeto);
		else if (objeto instanceof Collection) 
			return collectionIsEmpty((Collection<?>)objeto);
		else if(objeto instanceof java.util.Date)
			return dateIsEmpty((java.util.Date)objeto);
		else
			return objectIsNull(objeto);
	}
	
	
	private static boolean dateIsEmpty(Date objeto) {
		if(objeto == null)
			return true;
		else 
			return false;
	}

	
	private static boolean collectionIsEmpty(Collection<?> lista){
		if(lista == null)
			return true;
		else if(lista.isEmpty())
			return true;
		else if(lista.size() == 0 )
			return true;
		else 
			return false;
	}
	
	public static boolean stringIsEmpty(String valor){
		if(valor == null)
			return true;
		else if(valor.equals(""))
			return true;
		else 
			return false;
	}
	
	private static boolean objectIsNull(Object objeto){
		if(objeto == null)
			return true;
		else
			return false;
	}
}
