package com.niit.collaborationwebsite.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationwebsite.DAO.BloggDAO;
import com.niit.collaborationwebsite.DAO.Blogg_CommentDAO;

public class TestCaseBlogg_Comment {

	@Autowired
	Blogg_CommentDAO blogg_CommentDAO;
	
AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blogg_CommentDAO = (Blogg_CommentDAO) context.getBean("blogg_CommentDAO");


	}

	@Test
	public void Blogg_CommentTestCase()
	{
		int size = blogg_CommentDAO.listBlogg_Comments().size();
		assertEquals("blogg list test case ", 1, size);
		
	}
	
	
}
