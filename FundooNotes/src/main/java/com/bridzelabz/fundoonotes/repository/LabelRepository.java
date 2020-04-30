package com.bridzelabz.fundoonotes.repository;

import java.util.List;

import javax.persistence.EntityManager;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bridzelabz.fundoonotes.model.Label;
@Component 
public class LabelRepository{
   @Autowired
   private EntityManager entityManager;
	
	
    @Transactional
	public Label saveLabel(Label label) {
    	Session session = entityManager.unwrap(Session.class);
    	session.save(label);
		return label;
	}


    @Transactional
	public Label fetchLabelById(long labelId) {
		Session session = entityManager.unwrap(Session.class);
		Query<?> q=session.createQuery("from Label where label_id=:labelId");
		q.setParameter("labelId", labelId);
		return (Label) q.uniqueResult();
    }

 
    
    
    
}
