package com.niit.collaborationwebsite.DAO;

import java.util.List;

import com.niit.collaborationwebsite.model.Friend;

public interface FriendDAO {

	public boolean saveFriend(Friend friend);

	public boolean updateFriend(Friend friend);
	
	void deleteFriend(String userid);
	
	Friend getFriend(String userid);
	
	List<Friend> listFriends();
	
}
