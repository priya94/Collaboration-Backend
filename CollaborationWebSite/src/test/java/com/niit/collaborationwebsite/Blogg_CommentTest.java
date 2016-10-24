package com.niit.collaborationwebsite;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationwebsite.DAO.Blogg_CommentDAO;
import com.niit.collaborationwebsite.model.Blogg_Comment;

public class Blogg_CommentTest {

public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		Blogg_CommentDAO blogg_CommentDAO = (Blogg_CommentDAO) context.getBean("blogg_CommentDAO");
		Blogg_Comment blogg_Comment = (Blogg_Comment) context.getBean("blogg_Comment");
		
	
		blogg_Comment.setbCId("BC02");
		blogg_Comment.setbCContent("No BloggComments currently");
		blogg_Comment.setUserId("USER1");
		blogg_Comment.setCommentedat(new Date(System.currentTimeMillis()));
		
		blogg_CommentDAO.saveOrUpdateBlogg_Comment(blogg_Comment);
		
		if(blogg_CommentDAO.getBlogg_Comment("BC01")== null)
		{
			System.out.println("blogg comment does not exist");
		}
		else
		{
			System.out.println("blogg comment exists..");
			System.out.println();
		} 

	}
		
}
