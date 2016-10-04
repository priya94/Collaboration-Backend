package com.niit.collaborationwebsite.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationwebsite.DAO.ForumDAO;
import com.niit.collaborationwebsite.DAO.User_DetailsDAO;
import com.niit.collaborationwebsite.model.Event;
import com.niit.collaborationwebsite.model.Forum;
import com.niit.collaborationwebsite.model.User_Details;


@Repository("forumDAO")

public class ForumDAOImpl implements ForumDAO{

	@Autowired
	SessionFactory sessionFactory;

	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveForum(Forum forum) {
		try{
		sessionFactory.getCurrentSession().save(forum);
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Transactional
	public boolean updateForum(Forum forum) {
		try{
			sessionFactory.getCurrentSession().update(forum);
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public void deleteForum(String Id) {
		Forum forumToDelete = new Forum();
		forumToDelete.setId(Id);
		sessionFactory.getCurrentSession().delete(forumToDelete);

	}
	
	@Transactional
	public Forum getForum(String Id) {
		String hql = "from Forum where Id=:Id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("Id", Id);
		List<Forum> gotForum = query.getResultList();
		if (gotForum != null && !gotForum.isEmpty())
			return gotForum.get(0);
		return null;
	}

	@Transactional
	public List<Forum> listForum() {
		String hql = "from Forum";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Forum> listOfForum = query.getResultList();
		return listOfForum;
	}

	private Integer getMaxId()
	{
		String hql = "select max(id) from Forum";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Integer maxID = (Integer) query.uniqueResult();
		return maxID;
		
	}
	
}
