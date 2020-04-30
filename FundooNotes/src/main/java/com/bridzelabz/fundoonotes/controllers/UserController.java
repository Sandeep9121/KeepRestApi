/*********************************************************************
 * 
 * @author Mr Sandeep
 * 
 *@since March1
 * 
 * Notes Controller having api Crud apis trash ,archive,user list..
 * 
 **********************************/


package com.bridzelabz.fundoonotes.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridzelabz.fundoonotes.dto.Forgotpassword;
import com.bridzelabz.fundoonotes.dto.LoginDto;
import com.bridzelabz.fundoonotes.dto.UpdatePassword;
import com.bridzelabz.fundoonotes.dto.UsersDto;
import com.bridzelabz.fundoonotes.model.NotesEntity;
import com.bridzelabz.fundoonotes.model.UsersEntity;
import com.bridzelabz.fundoonotes.reponse.Response;
import com.bridzelabz.fundoonotes.reponse.UserVerification;
import com.bridzelabz.fundoonotes.services.ICollaboratorServices;
import com.bridzelabz.fundoonotes.services.IUsersServices;
import com.bridzelabz.fundoonotes.utility.JWTGenerator;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UsersEntity user;
	
	@Autowired
	private ICollaboratorServices serviceCollaborator;
    
	
	@Autowired
	private JWTGenerator generateToken;

	@Autowired
	private IUsersServices usersService;
	
//	@Autowired
//	private ProfileServiceImp profileService;

	@PostMapping("/users/register")
	// @RequestMapping(method = RequestMethod.POST,value = "users/register")
	public ResponseEntity<Response> userRegistration(@RequestBody UsersDto userdto) {
		try {
			if (usersService.addUsers(userdto)) {
				return ResponseEntity.status(HttpStatus.CREATED)
						.body(new Response("U have been Registered Successfully",userdto));
			} else {
				return ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
						.body(new Response("U are already Registered"));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@PostMapping(value = "/users")
	public List<UsersEntity> getUsers() {
		return usersService.getUserDetails();
	}

	@PutMapping("/users/verify/{token}")
	public ResponseEntity<Response> userVerification(@PathVariable("token") String token) {
		
		

		if (usersService.verify(token)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("U have verified Successfully", 200));
		}

		else {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("not verified", 400));

		}
	}

	@GetMapping(value = "/users/{token}")
	public ResponseEntity<Response> getUserById(@PathVariable("token") String token) {
		UsersEntity user=usersService.getuserById(token);
		if(user!=null) {
		return ResponseEntity.status(HttpStatus.OK).body(new Response("User is fetched",user));
	}
		return ResponseEntity.status(HttpStatus.OK).body(new Response("Unable to  fetch",user));
		}

	@PostMapping("/users/login")
	public ResponseEntity<UserVerification> login(@RequestBody LoginDto loginData) {
		UsersEntity userLogin = usersService.login(loginData);
		String token = generateToken.generateWebToken(userLogin.getUserId());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new UserVerification(token,"u have been Successfully Login",userLogin));
	}

	@PutMapping("/users/updatePassword/{token}")
	public ResponseEntity<Response> updatePassword(@Valid @PathVariable("token") String token,
			@RequestBody UpdatePassword password) {
		
		log.info("token"+token);
		log.info("pass"+password.getNewPassword());
		log.info("pass"+password.getChangepassword());
		user = usersService.updatePassword(token, password);
		if (user != null)
			return ResponseEntity.status(HttpStatus.OK).body(new Response(token,"password is updated Succesfully"));
		else
		{
			log.info("helooooo");
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED)
					.body(new Response("password and confirm password is not matched"));
		}
	}
	
	
	@PostMapping("/users/forgotPassword")
	public ResponseEntity<Response> forgotPassword(@RequestBody Forgotpassword forgotPassword){
		boolean result =usersService.isUserAlreadyRegistered(forgotPassword.getEmail());
		if(result) {
			return ResponseEntity.status(HttpStatus.OK).body(new Response("user exits",200,forgotPassword.getEmail()));
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("user does not exist with given email id", 400, forgotPassword.getEmail()));
		
	}
	
	@PostMapping("/users/addCollaborator")
	public ResponseEntity<Response> addsCollaborator(@RequestParam("notesId") Long notesId,
			@RequestParam("email") String email, @RequestHeader("token") String token){
		NotesEntity note=serviceCollaborator.addCollaborator(notesId, email, token);
		 if(note!=null) {
			 return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Collaborator is Added"));
		 }
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response("Collaborator is not added"));
		
	}
	

	@DeleteMapping("/users/removeCollaborator")
	public ResponseEntity<Response> removeCollaborator(@RequestParam("notesId") Long notesId,
			@RequestParam("email") String email, @RequestHeader("token") String token){
		      serviceCollaborator.removeCollaborator(notesId, email, token);
			 return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Collaborator is deleted"));
	
			
	}
	
	@GetMapping("/users/getAllCollaborators")
	public ResponseEntity<Response> getAllCollaborators(@RequestHeader("token") String token,@RequestParam long notesId){
		List<UsersEntity> collabNotes=serviceCollaborator.getCollaborators(token, notesId);
		if(collabNotes!=null) {
			return  ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("list of your Collaborated  notes", collabNotes));
		}
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("No collaborator notes", collabNotes));
		
	}
	

}