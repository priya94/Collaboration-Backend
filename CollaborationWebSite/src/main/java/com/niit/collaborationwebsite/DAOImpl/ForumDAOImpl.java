package com.niit.collaborationwebsite.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationwebsite.DAO.ForumDAO;
import com.niit.collaborationwebsite.DAO.User_DetailsDAO;
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
	public void saveOrUpdateForum(Forum forum) {
		sessionFactory.getCurrentSession().saveOrUpdate(forum);

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

	
	
}
