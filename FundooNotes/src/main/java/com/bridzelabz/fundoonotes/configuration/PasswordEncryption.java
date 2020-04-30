package com.bridzelabz.fundoonotes.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncryption {
	@Bean
	public BCryptPasswordEncoder passwordBcrypt() {
		return new BCryptPasswordEncoder();
	}
}
