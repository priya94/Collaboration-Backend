package com.niit.collaborationwebsite.DAO;

import java.util.List;

import com.niit.collaborationwebsite.model.Job;


public interface JobDAO {

    void saveOrUpdateJob(Job job);
	
	void deleteJob(String Id);

	Job getJob(String Id);

	List<Job> listJobs();
	
}
