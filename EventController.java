package com.niit.collaborationwebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.collaborationwebsite.DAO.EventDAO;
import com.niit.collaborationwebsite.DAO.User_DetailsDAO;
import com.niit.collaborationwebsite.model.Blogg;
import com.niit.collaborationwebsite.model.Event;
import com.niit.collaborationwebsite.model.User_Details;

@RestController
public class EventController {

	@Autowired
	Event event;
	
	@Autowired
	EventDAO eventDAO;
	
	@GetMapping("/events/")
	public ResponseEntity<List<Event>> listAllEvents() {
		List<Event> listOfEvents = eventDAO.listEvent();
		if (listOfEvents.isEmpty()) {
			return new ResponseEntity <List<Event>> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity < List < Event >> (listOfEvents, HttpStatus.OK);
	}
	
	@GetMapping("/event/{id}")
	public ResponseEntity<Event> getEvent(@PathVariable("id") String id) {
		event = eventDAO.getEvent(id);
		if (event == null) {
			return new ResponseEntity<Event>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Event>(event, HttpStatus.OK);

	}
	
	@PostMapping("/Event/")
	public ResponseEntity<Event> createEvent(@RequestBody Event event,
			UriComponentsBuilder ucBuilder) {
		if (eventDAO.getEvent(event.getId()) != null) 
		{
			return new ResponseEntity<Event>(HttpStatus.CONFLICT);
		}
		eventDAO.saveEvent(event);
		return new ResponseEntity<Event>(event, HttpStatus.OK);	
		
		}

		/*
		 * role.setId("ROLE_USER"); role.setName("ROLE_USER");
		 */
		
//		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(ucBuilder.path("Event/{id}/").buildAndExpand(event.getId()).toUri());
//		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	
	
	@PutMapping("/Event/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable("id") String id,
			@RequestBody Event event) {
		
		if (eventDAO.getEvent(id) == null) {
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		}

		//event.setId(id);
		eventDAO.updateEvent(event);

		return new ResponseEntity<Event>(event, HttpStatus.OK);

	}
	
	@DeleteMapping("/Event/{id}")
	public ResponseEntity<Event> deleteEvent(@PathVariable("id") String id) {

		event = eventDAO.getEvent(id);
		if (event == null) {

			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		}

		eventDAO.deleteEvent(id);
		return new ResponseEntity<Event>(HttpStatus.NO_CONTENT);
	}
	
}
