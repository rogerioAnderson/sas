package com.coded2.infra.validation.contraintvalidators;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.coded2.infra.validation.contraintvalidators.annotation.DateFormat;

public class DateFormatValidatorForString implements ConstraintValidator<DateFormat, String> {

	private String format;

	public void initialize(DateFormat constraintAnnotation) {
		format = constraintAnnotation.pattern();
	}

	public boolean isValid(String date, ConstraintValidatorContext constraintValidatorContext) {

		if (date == null) {
			return true;
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
}
