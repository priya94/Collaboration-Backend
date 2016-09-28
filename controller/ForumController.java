package com.niit.collaborationwebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationwebsite.DAO.ForumDAO;
import com.niit.collaborationwebsite.model.Forum;


@RestController
public class ForumController {

	@Autowired
	Forum forum;
	
	@Autowired
	ForumDAO forumDAO;
	
	@GetMapping("/forums/")
	public ResponseEntity<List<Forum>> listAllForums() {
		List<Forum> listOfForums = forumDAO.listForum();
		if (listOfForums.isEmpty()) {
			return new ResponseEntity <List<Forum>> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity < List < Forum >> (listOfForums, HttpStatus.OK);
	}

	@PutMapping("/Forum/{id}")
	public ResponseEntity<Forum> updateForum(@PathVariable("id") String id,
			@RequestBody Forum forum) {
		
		if (forumDAO.get(id) == null) {
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
		forum.setId(id);

		
		forumDAO.update(forum);

		return new ResponseEntity<Forum>(forum, HttpStatus.OK);

	}
	
}
