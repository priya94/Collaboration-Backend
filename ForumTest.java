package com.niit.collaborationwebsite;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationwebsite.DAO.ForumDAO;
import com.niit.collaborationwebsite.model.Forum;


public class ForumTest {

public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		ForumDAO forumDAO = (ForumDAO) context.getBean("forumDAO");
		Forum forum = (Forum) context.getBean("forum");
		
		
		forum.setId("FRM1");
		forum.setName("ENV");
		forum.setTitle("ENVIRONMENT");
		forum.setDescription("Enivronment Pollution");
		forum.setCreatedat(new Date(System.currentTimeMillis()));
		forum.setModifiedat(new Date(System.currentTimeMillis()));
		forum.setStatus("A");
		
		
		
		
		forumDAO.saveForum(forum);
		
	    
	    if(forumDAO.getForum("US1")== null)
		{
			System.out.println("Forum does not exist");
		}
		else
		{
			System.out.println("Forum exists..");
			System.out.println();
		} 
	}

}
