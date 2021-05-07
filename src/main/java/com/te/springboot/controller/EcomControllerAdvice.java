package com.te.springboot.controller;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.springboot.bean.EcomResponse;
import com.te.springboot.exep.EcomException;

@RestControllerAdvice
public class EcomControllerAdvice {
	
	@ExceptionHandler(EcomException.class)
	public EcomResponse handlingExce(EcomException exception) {
		EcomResponse response=new EcomResponse();
		response.setStatusCode(500);
		response.setMsg(exception.getMessage());
		return response;
	}
	

}


