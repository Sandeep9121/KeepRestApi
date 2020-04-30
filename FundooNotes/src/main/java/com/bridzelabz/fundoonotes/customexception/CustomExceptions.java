package com.bridzelabz.fundoonotes.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bridzelabz.fundoonotes.reponse.ErrorResponse;
@ControllerAdvice
public class CustomExceptions extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorResponse> UserExceptions(UserNotFoundException e){
		ErrorResponse ex=new ErrorResponse();
		ex.setMessage(e.getMessage());
		ex.setStatusCode(e.getStatusCode());
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage(),ex.getStatusCode()));
		
	}
	

	@ExceptionHandler(ExitsEmailException.class)
	public final ResponseEntity<ErrorResponse> mailExceptions(ExitsEmailException e){
		ErrorResponse ex=new ErrorResponse();
		ex.setMessage(e.getMessage());
		ex.setStatusCode(e.getStatusCode());
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage(),ex.getStatusCode()));
	
	}
	
	
	
	@ExceptionHandler(LabelExitsException.class)
	public final ResponseEntity<ErrorResponse> labelExceptions(LabelExitsException e){
		ErrorResponse ex=new ErrorResponse();
		ex.setMessage(e.getMessage());
		ex.setStatusCode(e.getStatusCode());
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage(),ex.getStatusCode()));
		
	}
	
	

	@ExceptionHandler(LabelNotFoundException.class)
	public final ResponseEntity<ErrorResponse> labelnotfoundExceptions(LabelNotFoundException e){
		ErrorResponse ex=new ErrorResponse();
		ex.setMessage(e.getMessage());
		ex.setStatusCode(e.getStatusCode());
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage(),ex.getStatusCode()));
		
	}
	


	@ExceptionHandler(MailNotFoundException.class)
	public final ResponseEntity<ErrorResponse> mailNotfoundExceptions(MailNotFoundException e){
		ErrorResponse ex=new ErrorResponse();
		ex.setMessage(e.getMessage());
		ex.setStatusCode(e.getStatusCode());
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage(),ex.getStatusCode()));
		
	}
	

	@ExceptionHandler(NoteNotFoundException.class)
	public final ResponseEntity<ErrorResponse> noteNotfoundExceptions(NoteNotFoundException e){
		ErrorResponse ex=new ErrorResponse();
		ex.setMessage(e.getMessage());
		ex.setStatusCode(e.getStatusCode());
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage(),ex.getStatusCode()));
		
	}
	
	
	@ExceptionHandler(UserNotVerifiedException.class)
	public final ResponseEntity<ErrorResponse> userNotVerifiedExceptions(UserNotVerifiedException e){
		ErrorResponse ex=new ErrorResponse();
		ex.setMessage(e.getMessage());
		ex.setStatusCode(e.getStatusCode());
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage(),ex.getStatusCode()));
		
	}
	

	@ExceptionHandler(CollaboratorNotFoundExcepton.class)
	public final ResponseEntity<ErrorResponse> collaboratorNotFoundExcepton(CollaboratorNotFoundExcepton e){
		ErrorResponse ex=new ErrorResponse();
		ex.setMessage(e.getMessage());
		ex.setStatusCode(e.getStatusCode());
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage(),ex.getStatusCode()));
		
	}
	
	
	
}
