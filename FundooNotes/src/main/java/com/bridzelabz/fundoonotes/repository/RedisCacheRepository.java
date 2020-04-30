//package com.bridzelabz.fundoonotes.repository;
//
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.bridzelabz.fundoonotes.constants.Constants;
//import com.bridzelabz.fundoonotes.model.NotesEntity;
//import com.bridzelabz.fundoonotes.model.UsersEntity;
//
//import lombok.Getter;
//@Repository
//@Getter
//public class RedisCacheRepository {
//   //private String key=Constants.KEY;
//	private RedisTemplate<String, Object> redisTemplate;
//	private HashOperations<String, Long, Object> hashOperation;
//
//	public RedisCacheRepository(RedisTemplate<String, Object> redisTemplate) {
//		super();
//		this.redisTemplate = redisTemplate;
//		hashOperation = this.redisTemplate.opsForHash();
//	}
//     
//	public void save(NotesEntity notes) {
//		 //hashOperation.put(Constants.KEY, notes.getNotesId(),notes );
//	}
//	 
//	
//	public void save(UsersEntity userId) {
//		//hashOperation.put("userId",userId.getUserId(), userId);
//	}
//	public UsersEntity findByuserId(String token) {
//		return  (UsersEntity) hashOperation.get("user", token);
//		 
//	 }
//}
