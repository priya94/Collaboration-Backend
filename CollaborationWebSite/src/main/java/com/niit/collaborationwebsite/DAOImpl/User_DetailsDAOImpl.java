package com.niit.collaborationwebsite.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationwebsite.DAO.User_DetailsDAO;
import com.niit.collaborationwebsite.model.User_Details;


@Repository("user_DetailsDAO")

public class User_DetailsDAOImpl implements User_DetailsDAO{

	@Autowired
	SessionFactory sessionFactory;

	public User_DetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveUser_Details(User_Details user_Details) {
		try{
		sessionFactory.getCurrentSession().save(user_Details);
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Transactional
	public boolean updateUser_Details(User_Details user_Details) {
		try{
			sessionFactory.getCurrentSession().update(user_Details);
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	@Transactional
	public void deleteUser_Details(String Id) {
		User_Details user_DetailsToDelete = new User_Details();
		user_DetailsToDelete.setId(Id);
		sessionFactory.getCurrentSession().delete(user_DetailsToDelete);

	}
	
	@Transactional
	public User_Details getUser_Details(String Id) {
		String hql = "from User_Details where Id=:Id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("Id", Id);
		List<User_Details> gotUser_Details = query.getResultList();
		if (gotUser_Details != null && !gotUser_Details.isEmpty())
			return gotUser_Details.get(0);
		return null;
	}

	@Transactional
	public List<User_Details> listUser_Details() {
		String hql = "from User_Details";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User_Details> listOfUser_Details = query.getResultList();
		return listOfUser_Details;
	}

	
}
