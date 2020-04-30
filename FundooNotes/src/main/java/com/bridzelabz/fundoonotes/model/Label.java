

package com.bridzelabz.fundoonotes.model;

import java.util.List;

import javax.persistence.CascadeType;
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

@Data
@Entity
@Component
public class Label {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int labelId;
	private String labelName;
	private long userId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name ="Label_note",joinColumns = { @JoinColumn(name="labelId")},inverseJoinColumns = {
    		@JoinColumn(name="notesId")})
    
   @JsonBackReference
   @JsonIgnore
	private List<NotesEntity> list;
    
   
}
