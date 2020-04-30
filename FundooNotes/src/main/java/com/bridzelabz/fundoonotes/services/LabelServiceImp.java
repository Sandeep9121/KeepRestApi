package com.bridzelabz.fundoonotes.services;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bridzelabz.fundoonotes.customexception.LabelExitsException;
import com.bridzelabz.fundoonotes.customexception.LabelNotFoundException;
import com.bridzelabz.fundoonotes.customexception.NoteNotFoundException;
import com.bridzelabz.fundoonotes.customexception.UserNotFoundException;
import com.bridzelabz.fundoonotes.dto.LabelDto;
import com.bridzelabz.fundoonotes.dto.LabelUpdate;
import com.bridzelabz.fundoonotes.model.Label;
import com.bridzelabz.fundoonotes.model.NotesEntity;
import com.bridzelabz.fundoonotes.model.UsersEntity;
import com.bridzelabz.fundoonotes.repository.ILabelRepository;
import com.bridzelabz.fundoonotes.repository.INoteRepository;
import com.bridzelabz.fundoonotes.repository.LabelRepository;
import com.bridzelabz.fundoonotes.repository.UsersRepository;
import com.bridzelabz.fundoonotes.utility.JWTGenerator;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class LabelServiceImp implements ILabelServices {
	@Autowired
	private JWTGenerator generateToken;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private LabelRepository labelRepository;
    @Autowired
     private ILabelRepository iLabelRepository;
    @Autowired
    private INoteRepository notesRepository;


	public Label createLabel(LabelDto labelDto,String token) {
      Long userId=generateToken.parseJWTToken(token);
      log.info("----------------------------------------------------------token="+token);
        UsersEntity user=usersRepository.getusersByid(userId);
        if(user!=null) {
        	Label label=new Label();
        	Label label1=iLabelRepository.fetchLabel(userId,labelDto.getLabelName());
        	if(label1==null) {
        	BeanUtils.copyProperties(labelDto, label);
        	label.setUserId(user.getUserId());
        	labelRepository.saveLabel(label);
        	return label;
        	}else {
        	throw new LabelExitsException("already label exits",HttpStatus.NOT_ACCEPTABLE);
        	}
        }else {
        	throw new UserNotFoundException("there is no user found",HttpStatus.NOT_FOUND);
        }
	}


	public boolean updateLabel(LabelUpdate labelUpdate, String token) {
		Long userId=generateToken.parseJWTToken(token);
		UsersEntity user=usersRepository.getusersByid(userId);
		  if(user!=null) {
			  Label label=labelRepository.fetchLabelById(labelUpdate.getLabelId());
			  if(label!=null) {
				  label.setLabelName(labelUpdate.getLabelName());
				  labelRepository.saveLabel(label);
				  return true;
			  }else {
			  throw new LabelNotFoundException("there is no label with this user id",HttpStatus.NOT_FOUND);
		  }	}
		  return false;
		  }


	@Override
	public boolean addLabel(Long labelId, long notesId, String token) {
	 NotesEntity notes=notesRepository.findBynotesId(notesId);
	 Label label=labelRepository.fetchLabelById(labelId);
	 if(notes!=null) {
	 if(label!=null) {
	 label.getList().add(notes);
	 labelRepository.saveLabel(label);
	 }else {
		 throw new LabelNotFoundException("there is no label please create Label",HttpStatus.NOT_FOUND);
	 }}else {
		 throw new NoteNotFoundException("unable to  add label create have a note",HttpStatus.NOT_FOUND);
	 }
	return true;
	}


	@Override
	public boolean removeLabel(Long labelId, Long notesId, String token) {
		Long userId=generateToken.parseJWTToken(token);
UsersEntity user=usersRepository.getusersByid(userId);
if(user!=null) {
		NotesEntity note=notesRepository.findBynotesId(notesId);
	
		Label label=labelRepository.fetchLabelById(labelId);
		if(label!=null) {
		note.getList().remove(label);
		labelRepository.saveLabel(label);
		return true;
		}
}else {
	throw new UserNotFoundException("user is not availabe",HttpStatus.NOT_FOUND);
}
return false;
		
	}


	@Override
	public List<Label> getLabels(String token) {
		Long userId=generateToken.parseJWTToken(token);
UsersEntity user=usersRepository.getusersByid(userId);
if(user!=null)
{
	return iLabelRepository.fetchAllLabels(userId);


}
return null;
	}
	

//
//	@Override
//	public List<NotesEntity> getNotesByLabel(long labelId, String token) {
//		Long userId=generateToken.parseJWTToken(token);
//UsersEntity user=usersRepository.getusersByid(userId);
//if(user!=null) {
////	Label label = labelRepository.findById(labelId).orElseThrow(()->new LabelNotFoundException("label not found" , HttpStatus.NOT_FOUND));
//
////	return label.getNotes();
//}		return null;
//	}

}
