package com.niit.collaborationwebsite.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationwebsite.DAO.ForumDAO;
import com.niit.collaborationwebsite.DAO.User_DetailsDAO;


public class TestCaseForum {
	@Autowired
	ForumDAO forumDAO;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forumDAO = (ForumDAO) context.getBean("forumDAO");


	}

	@Test
	public void ForumTestCase()
	{
		int size = forumDAO.listForum().size();
		assertEquals("forum list test case ", 1, size);
		
	}
	
	
	

}
