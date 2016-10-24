package com.niit.collaborationwebsite.test;

import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationwebsite.DAO.Forum_CommentDAO;

public class TestCaseForum_Comment {

	@Autowired
	Forum_CommentDAO forum_CommentDAO;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forum_CommentDAO = (Forum_CommentDAO) context.getBean("forum_CommentDAO");
		
	}
	
	@Test
	public void Forum_CommentTestCase()
	{
		int size = forum_CommentDAO.listForum_Comments().size();
		assertEquals("forum list test case",1,size);
	}
	
	
}
