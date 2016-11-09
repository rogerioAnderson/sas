package com.coded2.infra.validation.contraintvalidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.coded2.infra.util.Util;
import com.coded2.infra.validation.contraintvalidators.annotation.CPF;

public class ValidadorCPF implements ConstraintValidator<CPF,String>{

	@Override
	public void initialize(CPF anotation) {
		
	}

	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext context) {
		if(Util.isEmpty(cpf)){
			return true;
		}
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
