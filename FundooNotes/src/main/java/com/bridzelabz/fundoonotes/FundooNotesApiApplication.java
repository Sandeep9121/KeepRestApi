package com.bridzelabz.fundoonotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@EnableSwagger2
public class FundooNotesApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FundooNotesApiApplication.class, args);
	}

}
