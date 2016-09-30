package com.niit.collaborationwebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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

	@PostMapping("/Blogg/")
	public ResponseEntity<Blogg> createBlogg(@RequestBody Blogg blogg,
			UriComponentsBuilder ucBuilder) {
		if (bloggDAO.getBlogg(blogg.getId()) != null) {
			
			return new ResponseEntity<Blogg>(HttpStatus.CONFLICT);
		}
		bloggDAO.saveBlogg(blogg);
		return new ResponseEntity<Blogg>(blogg, HttpStatus.OK);
			
		}

		/*
		 * role.setId("ROLE_USER"); role.setName("ROLE_USER");
		 */
		
//		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(ucBuilder.path("Blogg/{id}/").buildAndExpand(blogg.getId()).toUri());
//		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	
	@PutMapping("/Blogg/{id}")
	public ResponseEntity<Blogg> updateBlogg(@PathVariable("id") String id,
			@RequestBody Blogg blogg) {
		
		if (bloggDAO.getBlogg(id) == null) {
			return new ResponseEntity<Blogg>(HttpStatus.NOT_FOUND);
		}
		//blogg.setId(id);

		
		bloggDAO.updateBlogg(blogg);

		return new ResponseEntity<Blogg>(blogg, HttpStatus.OK);

	}
}
