package com.niit.collaborationwebsite;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationwebsite.DAO.EventDAO;
import com.niit.collaborationwebsite.model.Event;

public class EventTest {

public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		EventDAO eventDAO = (EventDAO) context.getBean("eventDAO");
		Event event = (Event) context.getBean("event");
		
		
		event.setId("USER1");
		event.setContent("No contents currently");
		event.setEvent_date("27 th december");
		event.setPosted_date(new Date(System.currentTimeMillis()));
		
		
		
		
		
		eventDAO.saveEvent(event);
		
	    
	    if(eventDAO.getEvent("US1")== null)
		{
			System.out.println("Event does not exist");
		}
		else
		{
			System.out.println("Event exists..");
			System.out.println();
		} 
	}

	
}
