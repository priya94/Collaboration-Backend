package com.niit.collaborationwebsite;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationwebsite.DAO.FriendDAO;
import com.niit.collaborationwebsite.model.Friend;


public class FriendTest {

public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		FriendDAO friendDAO = (FriendDAO) context.getBean("friendDAO");
		Friend friend = (Friend) context.getBean("friend");
		
		
		friend.setUserid("USER2");
		friend.setFriendid("FRND2");
		friend.setStatus("R");
		
		
		
		
		
		friendDAO.saveFriend(friend);
		
	    
	    if(friendDAO.getFriend("USER1")== null)
		{
			System.out.println("USER1 does not exist");
		}
		else
		{
			System.out.println("USER1 exists..");
			System.out.println();
		} 
	}

	
}
