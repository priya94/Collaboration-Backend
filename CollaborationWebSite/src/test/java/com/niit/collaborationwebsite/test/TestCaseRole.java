package com.niit.collaborationwebsite.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationwebsite.DAO.RoleDAO;

public class TestCaseRole {

	@Autowired
	RoleDAO roleDAO;
	
AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		roleDAO = (RoleDAO) context.getBean("roleDAO");


	}

	@Test
	public void RoleTestCase()
	{
		int size = roleDAO.listRoles().size();
		assertEquals("role list test case ", 2, size);
		
	}
	
}
