package com.bridzelabz.fundoonotes.utility;



import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JWTGenerator {
	public static final String SECRETE="9121837953";
	
	
	public String generateWebToken(long  l) {
	
			return JWT.create().withClaim("userId",l).sign(Algorithm.HMAC512(SECRETE));
					
	}
	public long parseJWTToken(String jwtToken) {
		log.info("token"+jwtToken);
		int userId=0;
		if(jwtToken !=null) { 
			log.info("id:"+JWT.require(Algorithm.HMAC512(SECRETE)).build().verify(jwtToken).getClaim("userId").asLong());
			try {
				userId = JWT.require(Algorithm.HMAC512(SECRETE)).build().verify(jwtToken).getClaim("userId").asInt();
				return userId;
				
			} catch (JWTVerificationException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} 
//			  return JWT.require(Algorithm.HMAC512(SECRETE)).build().verify(jwtToken).getClaim("id").asLong();
		}
		return 0 ;	
		
	
	
	}

}
