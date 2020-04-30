package com.bridzelabz.fundoonotes.reponse;

 import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {
	  private String message;
	  private HttpStatus statusCode;
	public ErrorResponse(String message, HttpStatus statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}
	
	public ErrorResponse() {
	
	}
}
