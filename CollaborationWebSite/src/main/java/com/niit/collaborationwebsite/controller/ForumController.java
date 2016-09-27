package com.niit.collaborationwebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

	
	
}
