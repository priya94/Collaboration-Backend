package com.niit.collaborationwebsite.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationwebsite.DAO.User_DetailsDAO;

public class TestCaseUser_Details {

	@Autowired
	User_DetailsDAO user_DetailsDAO;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		user_DetailsDAO = (User_DetailsDAO) context.getBean("user_DetailsDAO");


	}

	@Test
	public void User_DetailsTestCase()
	{
		int size = user_DetailsDAO.listUser_Details().size();
		assertEquals("user_Details list test case ", 1, size);
		
	}
	
	
	

	
}
