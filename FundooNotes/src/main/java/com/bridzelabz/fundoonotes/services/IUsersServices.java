package com.bridzelabz.fundoonotes.services;

import java.util.List;

import com.bridzelabz.fundoonotes.dto.LoginDto;
import com.bridzelabz.fundoonotes.dto.UpdatePassword;
import com.bridzelabz.fundoonotes.dto.UsersDto;
import com.bridzelabz.fundoonotes.model.UsersEntity;

public interface IUsersServices {
	
	public boolean addUsers(UsersDto userdto) throws Exception;
	
	public boolean isUserAlreadyRegistered(String email);
	
	
	public UsersEntity updatePassword(String token,UpdatePassword password);

	public UsersEntity getuserById(String token);
	
	public boolean verify(String token);
	
	public UsersEntity login(LoginDto loginData);

	public List<UsersEntity> getUserDetails();
	
	
	
	
	
}
