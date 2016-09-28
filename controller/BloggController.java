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

import com.niit.collaborationwebsite.DAO.BloggDAO;
import com.niit.collaborationwebsite.model.Blogg;


@RestController
public class BloggController {

	@Autowired
	Blogg blogg;
	
	@Autowired
	BloggDAO bloggDAO;
	
	@GetMapping("/bloggs/")
	public ResponseEntity<List<Blogg>> listAllBloggs() {
		List<Blogg> listOfBloggs = bloggDAO.listBlogg();
		if (listOfBloggs.isEmpty()) {
			return new ResponseEntity <List<Blogg>> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity < List < Blogg >> (listOfBloggs, HttpStatus.OK);
	}

	@PutMapping("/Blogg/{id}")
	public ResponseEntity<Blogg> updateBlogg(@PathVariable("id") String id,
			@RequestBody Blogg blogg) {
		
		if (bloggDAO.get(id) == null) {
			return new ResponseEntity<Blogg>(HttpStatus.NOT_FOUND);
		}
		blogg.setId(id);

		
		bloggDAO.update(blogg);

		return new ResponseEntity<Blogg>(blogg, HttpStatus.OK);

	}
}
