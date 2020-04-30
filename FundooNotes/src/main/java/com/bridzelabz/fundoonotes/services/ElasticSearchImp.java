package com.bridzelabz.fundoonotes.services;

//import java.io.IOException;
//import java.util.List;
//
//import org.elasticsearch.action.index.IndexRequest;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.action.update.UpdateRequest;
//import org.elasticsearch.action.update.UpdateResponse;
//import org.elasticsearch.client.RequestOptions;
//import org.hibernate.mapping.Map;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.bridzelabz.fundoonotes.configuration.ElasticSearchConfig;
//import com.bridzelabz.fundoonotes.constants.Constants;
//import com.bridzelabz.fundoonotes.model.NotesEntity;
//import com.fasterxml.jackson.databind.ObjectMapper;
//@Service
//public class ElasticSearchImp implements IElasticSearch{
//
//
//@Autowired
// private ElasticSearchConfig  config;
// @Autowired
// private ObjectMapper objMap;
//
//	public String createNote(NotesEntity notes) {
//		Map noteMapper=objMap.convertValue(notes,Map.class);
//		IndexRequest indexRequest=new IndexRequest(Constants.INDEX,Constants.TYPE,
//				String.valueOf(notes.getNotesId()))
//				.source(noteMapper);
//	    IndexResponse indexResponse = null;
//	       try {
//			indexResponse=config.client().index(indexRequest, RequestOptions.DEFAULT);
//		} catch (IOException e) {
//			e.printStackTrace();} 
//		return indexResponse.getResult().name();
//	}
//	
//	
//	
//	
//	
//
//	public String updateNote(NotesEntity notes) {
//		Map noteMapper=objMap.convertValue(notes,Map.class);
//		UpdateRequest updateRequest=new UpdateRequest(Constants.INDEX,Constants.TYPE,
//				String.valueOf(notes.getNotesId()))
//				.doc(noteMapper);
//		UpdateResponse updateResponse=null;
//		try {
//			updateResponse=config.client().update(updateRequest,RequestOptions.DEFAULT);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return updateResponse.getResult().name();
//	}
//
//
//	public String deleteNotes(NotesEntity notes) {
//		Map noteMapper=objMap.convertValue(notes,Map.class);
//		return null;
//	}
//
//	public List<NotesEntity> searchByTitle(String title) {
//
//		return null;
//	}
//
//}
