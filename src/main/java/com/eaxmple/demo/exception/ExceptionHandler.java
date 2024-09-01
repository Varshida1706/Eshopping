package com.eaxmple.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler{
	
	public String NameNotEmptyException(IllegalStateException e)
	{
		return e.getMessage();
	}

}
