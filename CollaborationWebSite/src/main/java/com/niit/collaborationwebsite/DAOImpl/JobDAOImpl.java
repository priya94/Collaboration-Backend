package com.niit.collaborationwebsite.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.collaborationwebsite.DAO.JobDAO;
import com.niit.collaborationwebsite.model.Job;

@Repository("jobDAO")
public class JobDAOImpl implements JobDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateJob(Job job) {
		sessionFactory.getCurrentSession().saveOrUpdate(job);

	}
	
	@Transactional
	public void deleteJob(String Id) {
		Job jobToDelete = new Job();
		jobToDelete.setId(Id);
		sessionFactory.getCurrentSession().delete(jobToDelete);

	}
	
	@Transactional
	public Job getJob(String Id) {
		String hql = "from Job where Id=:Id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("Id", Id);
		List<Job> gotJob = query.getResultList();
		if (gotJob != null && !gotJob.isEmpty())
			return gotJob.get(0);
		return null;
}
	
	@Transactional
	public List<Job> listJobs() {
		String hql = "from Job";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Job> listOfJobs = query.getResultList();
		return listOfJobs;
	}
	
}
