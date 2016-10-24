package com.niit.collaborationwebsite;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.collaborationwebsite.DAO.RoleDAO;
import com.niit.collaborationwebsite.model.Role;

public class RoleTest {

public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		RoleDAO roleDAO = (RoleDAO) context.getBean("roleDAO");
		Role role = (Role) context.getBean("role");
		
	
		role.setId("ROLE2");
		role.setName("Student");
		
		
		roleDAO.saveOrUpdateRole(role);
		
		if(roleDAO.getRole("ROLE1")== null)
		{
			System.out.println("role does not exist");
		}
		else
		{
			System.out.println("role exists..");
			System.out.println();
		} 

	}
	
}
