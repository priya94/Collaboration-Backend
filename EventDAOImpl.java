package com.niit.collaborationwebsite.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationwebsite.DAO.EventDAO;
import com.niit.collaborationwebsite.model.Blogg;
import com.niit.collaborationwebsite.model.Event;




@Repository("eventDAO")

public class EventDAOImpl implements EventDAO{

	@Autowired
	SessionFactory sessionFactory;

	public EventDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean saveEvent(Event event) {
		try{
		sessionFactory.getCurrentSession().save(event);
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Transactional
	public boolean updateEvent(Event event) {
		try{
			sessionFactory.getCurrentSession().update(event);
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public void deleteEvent(String Id) {
		Event eventToDelete = new Event();
		eventToDelete.setId(Id);
		sessionFactory.getCurrentSession().delete(eventToDelete);

	}
	
	@Transactional
	public Event getEvent(String Id) {
		String hql = "from Event where Id=:Id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("Id", Id);
		List<Event> gotEvent = query.getResultList();
		if (gotEvent != null && !gotEvent.isEmpty())
			return gotEvent.get(0);
		return null;
	}

	@Transactional
	public List<Event> listEvent() {
		String hql = "from Event";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Event> listOfEvent = query.getResultList();
		return listOfEvent;
	}

	
}
