package com.coded2.infra.validation.contraintvalidators.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.coded2.infra.validation.contraintvalidators.ValidadorCPF;

@Constraint(validatedBy=ValidadorCPF.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface CPF {
	String message() default "CPF Inválido";

	  Class<?>[] groups() default {};
	  Class<? extends Payload>[] payload() default {};
	
}
