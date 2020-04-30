package com.bridzelabz.fundoonotes.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Component
@Data
@Entity
public class NotesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long notesId;

	private String title;

	private String description;

	private String color;

	private boolean isArchieved;

	private boolean isPinned;

	private boolean isTrashed;

	private LocalDateTime notesCreatedDate;

	private LocalDateTime updateDate;

	private LocalDateTime reminder;

//	@Embedded
//	private ImageModel Img;
	
	
	@Column(name = "image", length = 1000)
	private String image;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Label_note", joinColumns = { @JoinColumn(name = "notesId") }, inverseJoinColumns = {
			@JoinColumn(name = "labelId") })
	@JsonBackReference
	@JsonIgnore
	private List<Label> list;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Collaborator", joinColumns = { @JoinColumn(name = "notesId") }, inverseJoinColumns = {
			@JoinColumn(name = "userId") })
	@JsonBackReference
	@JsonIgnore
	private List<UsersEntity> collaborateUser;

}
