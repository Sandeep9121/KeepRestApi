package com.bridzelabz.fundoonotes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "profile")

public class ProfileEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long Id;
private String profilePictureName;

@JsonIgnore
@ManyToOne
@JoinColumn(name="userId")
private UsersEntity userlabel;

public ProfileEntity(String profilePictureName, UsersEntity userlabel) {
	super();
	this.profilePictureName = profilePictureName;
	this.userlabel = userlabel;
}
}
