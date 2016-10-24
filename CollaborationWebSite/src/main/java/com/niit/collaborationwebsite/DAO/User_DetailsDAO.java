package com.niit.collaborationwebsite.DAO;

import java.util.List;

import com.niit.collaborationwebsite.model.User_Details;

public interface User_DetailsDAO {

	public boolean saveUser_Details(User_Details user_Details);

	public boolean updateUser_Details(User_Details user_Details);
	
	void deleteUser_Details(String Id);
	
	User_Details getUser_Details(String Id);
	
	List<User_Details> listUser_Details();
	
}
