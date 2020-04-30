package com.bridzelabz.fundoonotes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridzelabz.fundoonotes.dto.LabelDto;
import com.bridzelabz.fundoonotes.dto.LabelUpdate;
import com.bridzelabz.fundoonotes.model.Label;
import com.bridzelabz.fundoonotes.model.NotesEntity;
@Service
public interface ILabelServices {
	 Label createLabel(LabelDto labelDto,String token);
	 boolean updateLabel(LabelUpdate labelUpdate,String token);
	 boolean addLabel(Long labelId, long notesId, String token);
	 boolean removeLabel(Long labelId,Long notesId,String token);
	 List<Label> getLabels(String token);
	// List<NotesEntity> getNotesByLabel(long labelId, String token);
	 
}
