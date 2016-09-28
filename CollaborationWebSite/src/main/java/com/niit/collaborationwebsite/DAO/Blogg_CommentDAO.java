package com.niit.collaborationwebsite.DAO;

import java.util.List;
import com.niit.collaborationwebsite.model.Blogg_Comment;

public interface Blogg_CommentDAO {

	void saveOrUpdateBlogg_Comment(Blogg_Comment blogg_Comment);
	
	void deleteBlogg_Comment(String bCId);

	Blogg_Comment getBlogg_Comment(String bCId);

	List<Blogg_Comment> listBlogg_Comments();

	
}
