package com.bridzelabz.fundoonotes.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
@Data
@Embeddable
public class FullName {
	@NotNull
	@Size(max = 40)
	private String firstName;
	@Size(max = 40)
	private String middleName;
	@Size(max = 40)
	private String lastName;
	 public FullName(String firstName, String middleName, String lastName) {
	        this.firstName = firstName;
	        this.middleName = middleName;
	        this.lastName = lastName;
	    }

}
