package com.bridzelabz.fundoonotes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridzelabz.fundoonotes.model.NotesEntity;
import com.bridzelabz.fundoonotes.model.UsersEntity;
@Service
public interface ICollaboratorServices {
	NotesEntity addCollaborator(Long notesId,String email,String token);
	
	NotesEntity removeCollaborator(Long notesId,String email,String token);
	
	 public List<UsersEntity> getCollaborators(String token, long notesId);
	
	List<NotesEntity> getAllNotesCollaborators(String token);
}
