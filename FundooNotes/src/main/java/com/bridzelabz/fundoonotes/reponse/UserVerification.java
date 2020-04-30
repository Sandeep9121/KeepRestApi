package com.bridzelabz.fundoonotes.reponse;

import lombok.Getter;

@Getter
public class UserVerification {
	private String token;  
	private String message;
	private  Object obj;
	public UserVerification(String token, String message, Object obj) {
		super();
		this.token = token;
		this.message=message;
		
		this.obj = obj;
	}


}
