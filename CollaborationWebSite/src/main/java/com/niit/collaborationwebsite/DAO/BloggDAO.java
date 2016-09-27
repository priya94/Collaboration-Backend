package com.niit.collaborationwebsite.DAO;

import java.util.List;

import com.niit.collaborationwebsite.model.Blogg;


public interface BloggDAO {

	void saveOrUpdateBlogg(Blogg blogg);

	void deleteBlogg(String Id);

	Blogg getBlogg(String Id);

	List<Blogg> listBlogg();
	
	
}
