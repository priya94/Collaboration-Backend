package com.niit.collaborationwebsite;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationwebsite.DAO.BloggDAO;
import com.niit.collaborationwebsite.model.Blogg;


public class BloggTest {

public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		BloggDAO bloggDAO = (BloggDAO) context.getBean("bloggDAO");
		Blogg blogg = (Blogg) context.getBean("blogg");
		
		blogg.setId("BLOG2");
		blogg.setTitle("collaboration2");
		blogg.setDescription("No Blogg Currently");
		blogg.setCreatedat(new Date(System.currentTimeMillis()));
		blogg.setStatus("A");
		bloggDAO.saveBlogg(blogg);
		
		if(bloggDAO.getBlogg("BLG1")== null)
		{
			System.out.println("Blogg does not exist");
		}
		else
		{
			System.out.println("Blogg exists..");
			System.out.println();
		} 
	}

	
}
