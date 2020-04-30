package com.bridzelabz.fundoonotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.bridzelabz.fundoonotes.model.Label;
@Service
public interface ILabelRepository extends JpaRepository<Label,Long>{
 
	@Query("from Label where user_id=:userId and label_name=:name")
   Label fetchLabel(long userId, String name);
	
	@Query("from Label where user_id=:userId")
	List<Label> fetchAllLabels(long userId);
	
//	@Query("from Label where label_name=:name and user_id=:userId ")
//	List<Label> fetchLabelsByName(long userId , String name);
}
