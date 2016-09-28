package com.niit.collaborationwebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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

	@PostMapping("/Forum/")
	public ResponseEntity<Void> createForum(@RequestBody Forum forum,
			UriComponentsBuilder ucBuilder) {
		if (forumDAO.getForum(forum.getId()) != null) {

			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}

		/*
		 * role.setId("ROLE_USER"); role.setName("ROLE_USER");
		 */
		blogDAO.save(blog);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("Blog/{id}/").buildAndExpand(blog.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}
	
	@PutMapping("/Forum/{id}")
	public ResponseEntity<Forum> updateForum(@PathVariable("id") String id,
			@RequestBody Forum forum) {
		
		if (forumDAO.getForum(id) == null) {
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
		forum.setId(id);

		
		forumDAO.saveOrUpdateForum(forum);

		return new ResponseEntity<Forum>(forum, HttpStatus.OK);

	}
	
}
