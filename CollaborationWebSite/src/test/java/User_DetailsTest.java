

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationwebsite.DAO.User_DetailsDAO;
import com.niit.collaborationwebsite.model.User_Details;

public class User_DetailsTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		User_DetailsDAO user_DetailsDAO = (User_DetailsDAO) context.getBean("user_DetailsDAO");
		User_Details user_Details = (User_Details) context.getBean("user_Details");
		
		
		user_Details.setId("US2");
		user_Details.setName("user");
		user_Details.setPassword("password");
		user_Details.setEmail("u@a.com");
		user_Details.setMobile("9446029241");
		user_Details.setGender("M");
		user_Details.setStatus("A");
		
		
		
		
		user_DetailsDAO.saveOrUpdateUser_Details(user_Details);
		
	    
	    if(user_DetailsDAO.getUser_Details("US1")== null)
		{
			System.out.println("USER does not exist");
		}
		else
		{
			System.out.println("USER exists..");
			System.out.println();
		} 
	}

}