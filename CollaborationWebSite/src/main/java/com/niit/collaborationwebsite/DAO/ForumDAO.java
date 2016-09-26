package com.niit.collaborationwebsite.DAO;

import java.util.List;

import com.niit.collaborationwebsite.model.Forum;

public interface ForumDAO {
	void saveOrUpdateForum(Forum forum);

	void deleteForum(String Id);

	Forum getForum(String Id);

	List<Forum> listForum();
}
