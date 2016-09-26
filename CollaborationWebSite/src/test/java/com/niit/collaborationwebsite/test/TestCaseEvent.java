package com.niit.collaborationwebsite.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationwebsite.DAO.EventDAO;

public class TestCaseEvent {

	@Autowired
	EventDAO eventDAO;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		eventDAO = (EventDAO) context.getBean("eventDAO");


	}

	@Test
	public void EventTestCase()
	{
		int size = eventDAO.listEvent().size();
		assertEquals("event list test case ", 1, size);
		
	}
	
	
	
	
}
