package com.niit.collaborationwebsite;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationwebsite.DAO.Forum_CommentDAO;
import com.niit.collaborationwebsite.model.Forum_Comment;

public class Forum_CommentTest {

	public static void main(String[] args){
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		Forum_CommentDAO forum_CommentDAO = (Forum_CommentDAO) context.getBean("forum_CommentDAO");
		Forum_Comment forum_Comment = (Forum_Comment) context.getBean("forum_Comment");
		
		
		forum_Comment.setfCId("FC01");
		forum_Comment.setfCContent("No contents currently");
		forum_Comment.setUserId("USER1");
		forum_Comment.setCommentedat(new Date (System.currentTimeMillis()));
		
		forum_CommentDAO.saveForum_Comment(forum_Comment);
		if(forum_CommentDAO.getForum_Comment("BC01")== null){
			System.out.println("Forum Comment does not exists");
		}
		else{
			System.out.println("Forum Comment exists");
			System.out.println();
		}
		
		
		
	}
	
}
