package com.niit.collaborationwebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.niit.collaborationwebsite.DAO.User_DetailsDAO;
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

	
}
