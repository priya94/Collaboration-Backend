package com.niit.collaborationwebsite.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationwebsite.DAO.Blogg_CommentDAO;
import com.niit.collaborationwebsite.DAO.JobDAO;

public class TestCaseJob {

	@Autowired
	JobDAO jobDAO;
	
AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		jobDAO = (JobDAO) context.getBean("jobDAO");


	}

	@Test
	public void JobTestCase()
	{
		int size = jobDAO.listJobs().size();
		assertEquals("job list test case ", 1, size);
		
	}
	
}
