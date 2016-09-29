package com.niit.collaborationwebsite.DAO;

import java.util.List;

import com.niit.collaborationwebsite.model.Blogg;


public interface BloggDAO {

	public boolean saveBlogg(Blogg blogg);
	
	public boolean updateBlogg(Blogg blogg);

	void deleteBlogg(String Id);

	Blogg getBlogg(String Id);

	List<Blogg> listBlogg();
	
	
}
