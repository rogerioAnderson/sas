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
	
	public static String retirarCaracteresNaoNumericos(String duration) {
		String tmp = "";
		if (duration != null && !duration.equals("")) {
			char[] arrCaracter = duration.toCharArray();
			for (int i = 0; i < arrCaracter.length; i++) {
				if (Character.isDigit(arrCaracter[i])) {
					tmp += arrCaracter[i];
				}
			}
		}
		return tmp;
	}
	
	public static boolean validarCpf(String cpf){
		cpf = retirarCaracteresNaoNumericos(cpf);
		int soma = 0;
		try {
			Long.parseLong(cpf);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		if (cpf.length() == 11) {
			if(   cpf.equals("00000000000")
			   || cpf.equals("11111111111")
			   || cpf.equals("22222222222")
			   || cpf.equals("33333333333")
			   || cpf.equals("44444444444")
			   || cpf.equals("55555555555")
			   || cpf.equals("66666666666")
			   || cpf.equals("77777777777")
			   || cpf.equals("88888888888")
			   || cpf.equals("99999999999")){
				return false;
			}
			for (int i = 0; i < 9; i++)
			soma += (10 - i) * (cpf.charAt(i) - '0');
			soma = 11 - (soma % 11);
			if (soma > 9)
				soma = 0;
			if (soma == (cpf.charAt(9) - '0')) {
				soma = 0;
				for (int i = 0; i < 10; i++)
					soma += (11 - i) * (cpf.charAt(i) - '0');
				soma = 11 - (soma % 11);
				if (soma > 9)
					soma = 0;
				if (soma == (cpf.charAt(10) - '0')) {
					return true;
				}
			}
		}
		return false;
	}
}
