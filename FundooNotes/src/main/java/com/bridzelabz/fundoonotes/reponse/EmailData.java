package com.bridzelabz.fundoonotes.reponse;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import lombok.Data;


@Data
@Component
public class EmailData implements Serializable{

	private static final long serialVersionUID = 1L;
	private String email;
	private String subject;
	private String body;

	
	

}
