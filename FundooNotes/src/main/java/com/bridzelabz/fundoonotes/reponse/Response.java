package com.bridzelabz.fundoonotes.reponse;

import com.bridzelabz.fundoonotes.dto.UsersDto;

import lombok.Data;

@Data
public class Response {
	private String message;
	private int statusCode;
	private Object obj;
	public Response(String message, int statusCode, Object obj) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.obj = obj;
	}
	public Response(String message, int statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}
	public Response(String message, UsersDto userdto) {
		super();
		this.message = message;
	}
	
	public Response(String message) {
		super();
		this.message = message;
	}
	public Response(String message,Object object) {
		super();
		this.message = message;
		this.obj=object;
	}
	
	
}
