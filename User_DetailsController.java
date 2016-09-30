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

import com.niit.collaborationwebsite.DAO.User_DetailsDAO;
import com.niit.collaborationwebsite.model.Forum;
import com.niit.collaborationwebsite.model.User_Details;


@RestController

public class User_DetailsController {

	@Autowired
	User_Details user_Details;
	
	@Autowired
	User_DetailsDAO user_DetailsDAO;
	
	@GetMapping("/users/")
	public ResponseEntity<List<User_Details>> listAllUsers() {
		List<User_Details> listOfUsers = user_DetailsDAO.listUser_Details();
		if (listOfUsers.isEmpty()) {
			return new ResponseEntity <List<User_Details>> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity < List < User_Details >> (listOfUsers, HttpStatus.OK);
	}

	@PostMapping("/User_Details/")
	public ResponseEntity<User_Details> createForum(@RequestBody User_Details user_Details,
			UriComponentsBuilder ucBuilder) {
		if (user_DetailsDAO.getUser_Details(user_Details.getId()) != null) {
			
			return new ResponseEntity<User_Details>(HttpStatus.CONFLICT);
		}
		user_DetailsDAO.saveUser_Details(user_Details);
		return new ResponseEntity<User_Details>(user_Details, HttpStatus.OK);
		/*
		 * role.setId("ROLE_USER"); role.setName("ROLE_USER");
		 */
		

		//HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("User_Details/{id}/").buildAndExpand(user_Details.getId()).toUri());
		

	}
	
	@PutMapping("/UserDetails/{id}")
	public ResponseEntity<User_Details> updateUser_Details(@PathVariable("id")String id,@RequestBody User_Details user_Details) {
		
		if(user_DetailsDAO.getUser_Details(id) == null) {
			return new ResponseEntity<User_Details>(HttpStatus.NOT_FOUND);
		}
		
	
		user_Details.setId(id);
		user_DetailsDAO.updateUser_Details(user_Details);
		
		return new ResponseEntity<User_Details>(user_Details, HttpStatus.OK);
		
	}
	
}
