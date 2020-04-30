package com.bridzelabz.fundoonotes.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bridzelabz.fundoonotes.model.UsersEntity;

@Repository
public interface IUsersRepository extends CrudRepository<UsersEntity,Long>{

	Optional<UsersEntity> findOneByEmail(String email);

	
}
