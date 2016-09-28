package com.niit.collaborationwebsite.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationwebsite.DAO.Blogg_CommentDAO;
import com.niit.collaborationwebsite.DAO.BloggDAO;
import com.niit.collaborationwebsite.model.Blogg_Comment;

@Repository("blogg_CommentDAO")

public class Blogg_CommentDAOImpl implements Blogg_CommentDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public Blogg_CommentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateBlogg_Comment(Blogg_Comment blogg_Comment) {
		sessionFactory.getCurrentSession().saveOrUpdate(blogg_Comment);

	}
	
	@Transactional
	public void deleteBlogg_Comment(String bCId) {
		Blogg_Comment blogg_CommentToDelete = new Blogg_Comment();
		blogg_CommentToDelete.setbCId(bCId);
		sessionFactory.getCurrentSession().delete(blogg_CommentToDelete);

	}
	
	@Transactional
	public Blogg_Comment getBlogg_Comment(String bCId) {
		String hql = "from Blogg_Comment where bCId=:bCId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("bCId", bCId);
		List<Blogg_Comment> gotBlogg_Comment = query.getResultList();
		if (gotBlogg_Comment != null && !gotBlogg_Comment.isEmpty())
			return gotBlogg_Comment.get(0);
		return null;
}
	
	@Transactional
	public List<Blogg_Comment> listBlogg_Comments() {
		String hql = "from Blogg_Comment";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Blogg_Comment> listOfBlogg_Comments = query.getResultList();
		return listOfBlogg_Comments;
	}
}