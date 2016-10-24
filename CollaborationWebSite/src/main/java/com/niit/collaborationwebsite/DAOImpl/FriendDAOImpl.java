package com.niit.collaborationwebsite.DAOImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationwebsite.DAO.FriendDAO;
import com.niit.collaborationwebsite.model.Friend;


@Repository("friendDAO")
public class FriendDAOImpl implements FriendDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public FriendDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveFriend(Friend friend) {
		try{
		sessionFactory.getCurrentSession().save(friend);
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Transactional
	public boolean updateFriend(Friend friend) {
		try{
			sessionFactory.getCurrentSession().update(friend);
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	@Transactional
	public void deleteFriend(String userid) {
		Friend friendToDelete = new Friend();
		friendToDelete.setUserid(userid);
		sessionFactory.getCurrentSession().delete(friendToDelete);

	}
	
	@Transactional
	public Friend getFriend(String userid) {
		String hql = "from Friend where userid=:userid";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("userid", userid);
		List<Friend> gotFriend = query.getResultList();
		if (gotFriend != null && !gotFriend.isEmpty())
			return gotFriend.get(0);
		return null;
	}

	@Transactional
	public List<Friend> listFriends() {
		String hql = "from Friend";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> listOfFriends = query.getResultList();
		return listOfFriends;
	}

	
}
	
	

