package com.niit.collaborationwebsite.DAO;

import java.util.List;

import com.niit.collaborationwebsite.model.Forum_Comment;

public interface Forum_CommentDAO {

	public boolean saveForum_Comment(Forum_Comment forum_Comment);
	
	public boolean updateForum_Comment(Forum_Comment forum_Comment);
	
	void deleteForum_Comment(String fCId);
	
	Forum_Comment getForum_Comment(String fCId);
	
	List<Forum_Comment> listForum_Comments();
	
}
