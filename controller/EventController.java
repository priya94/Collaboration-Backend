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

import com.niit.collaborationwebsite.DAO.EventDAO;
import com.niit.collaborationwebsite.DAO.User_DetailsDAO;
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

	@PutMapping("/Event/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable("id") String id,
			@RequestBody Event event) {
		
		if (eventDAO.get(id) == null) {
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		}

		event.setId(id);
		eventDAO.update(event);

		return new ResponseEntity<Event>(event, HttpStatus.OK);

	}
}
