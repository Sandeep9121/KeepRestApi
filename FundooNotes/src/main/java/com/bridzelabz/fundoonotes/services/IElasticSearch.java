package com.bridzelabz.fundoonotes.services;

import java.util.List;

import com.bridzelabz.fundoonotes.model.NotesEntity;

public interface IElasticSearch {
	String createNote(NotesEntity notes);
	String updateNote(NotesEntity notes);
	String deleteNotes(NotesEntity notes);
	List<NotesEntity> searchByTitle(String title);

}
