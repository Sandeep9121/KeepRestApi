package com.bridzelabz.fundoonotes.repository;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bridzelabz.fundoonotes.model.NotesEntity;
import com.bridzelabz.fundoonotes.model.UsersEntity;


@Component
public class UsersRepository  {
	@Autowired
	private EntityManager entityManager;
@Transactional
	public UsersEntity getusersByid(Long userId) {
		Session session = entityManager.unwrap(Session.class);
		Query<?> q = session.createQuery("from UsersEntity where user_id=:userId");
		q.setParameter("userId",userId);
		return (UsersEntity) q.uniqueResult();
		
	}

@Transactional
public void save(UsersEntity user) {
	Session session = entityManager.unwrap(Session.class);
	session.saveOrUpdate(user);
}  



@Transactional
public UsersEntity getusersByemail(String email) {
	Session session = entityManager.unwrap(Session.class);
	Query<?> q = session.createQuery("from UsersEntity where email=:email");
	q.setParameter("email",email);
	System.out.println("------------------ "+(UsersEntity)q.uniqueResult());
	return (UsersEntity) q.uniqueResult();
}
}
