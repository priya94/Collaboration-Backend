package com.niit.collaborationwebsite.DAOImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationwebsite.DAO.Forum_CommentDAO;
import com.niit.collaborationwebsite.model.Forum_Comment;

@Repository("forum_CommentDAO")
public class Forum_CommentDAOImpl implements Forum_CommentDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public Forum_CommentDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean saveForum_Comment(Forum_Comment forum_Comment){
		try{
			sessionFactory.getCurrentSession().save(forum_Comment);
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean updateForum_Comment(Forum_Comment forum_Comment){
		try{
			sessionFactory.getCurrentSession().update(forum_Comment);
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
	    }
		return true;
	}
	@Transactional
	public void deleteForum_Comment(String fCId){
		Forum_Comment forum_CommentToDelete= new Forum_Comment();
		forum_CommentToDelete.setfCId(fCId);
		sessionFactory.getCurrentSession().delete(forum_CommentToDelete);
		
	}
	
	@Transactional
	public Forum_Comment getForum_Comment(String fCId){
		String hql = "from Forum_Comment where fCId=:fCId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("fCId", fCId);
		List<Forum_Comment> gotForum_Comment = query.getResultList();
		if(gotForum_Comment != null && !gotForum_Comment.isEmpty())
			return gotForum_Comment.get(0);
		return null;
		
	}
	
	@Transactional
	public List<Forum_Comment> listForum_Comments(){
		String hql = "from Forum_Comment";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Forum_Comment> listOfForum_Comments = query.getResultList();
		return listOfForum_Comments;
		
	}
	
	
	
}
