package com.niit.collaborationwebsite.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.collaborationwebsite.DAO.FriendDAO;

public class TestCaseFriend {

	@Autowired
	FriendDAO friendDAO;
	
AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		friendDAO = (FriendDAO) context.getBean("friendDAO");


	}

	@Test
	public void Blogg_CommentTestCase()
	{
		int size = friendDAO.listFriends().size();
		assertEquals("friend list test case ", 2, size);
		
	}
	
}
