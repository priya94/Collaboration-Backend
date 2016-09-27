package com.niit.collaborationwebsite.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationwebsite.DAO.BloggDAO;

public class TestCaseBlogg {

	@Autowired
	BloggDAO bloggDAO;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		bloggDAO = (BloggDAO) context.getBean("bloggDAO");


	}

	@Test
	public void BloggTestCase()
	{
		int size = bloggDAO.listBlogg().size();
		assertEquals("blogg list test case ", 1, size);
		
	}
	
	
	
}
