package com.bridzelabz.fundoonotes.customexception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
@Getter
public class LabelNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	  private String message;
	  private HttpStatus statusCode;
	public LabelNotFoundException(String message, HttpStatus statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}
}
