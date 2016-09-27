package com.niit.collaborationwebsite.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationwebsite.DAO.BloggDAO;
import com.niit.collaborationwebsite.model.Blogg;
import com.niit.collaborationwebsite.model.Event;




@Repository("bloggDAO")

public class BloggDAOImpl implements BloggDAO{

	@Autowired
	SessionFactory sessionFactory;

	public BloggDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateBlogg(Blogg blogg) {
		sessionFactory.getCurrentSession().saveOrUpdate(blogg);

	}

	@Transactional
	public void deleteBlogg(String Id) {
		Blogg bloggToDelete = new Blogg();
		bloggToDelete.setId(Id);
		sessionFactory.getCurrentSession().delete(bloggToDelete);

	}
	
	@Transactional
	public Blogg getBlogg(String Id) {
		String hql = "from Blogg where Id=:Id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("Id", Id);
		List<Blogg> gotBlogg = query.getResultList();
		if (gotBlogg != null && !gotBlogg.isEmpty())
			return gotBlogg.get(0);
		return null;
	}

	@Transactional
	public List<Blogg> listBlogg() {
		String hql = "from Blogg";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Blogg> listOfBlogg = query.getResultList();
		return listOfBlogg;
	}

	
}
