package com.niit.collaborationwebsite;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.collaborationwebsite.DAO.JobDAO;
import com.niit.collaborationwebsite.model.Job;

public class JobTest {

public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		JobDAO jobDAO = (JobDAO) context.getBean("jobDAO");
		Job job = (Job) context.getBean("job");
		
	
		job.setId("JOB2");
		job.setJobtitle("Assistant Officer Systems");
		job.setDescription("No description");
		job.setQualification("BTech $ MCA");
		job.setLastSubmissionDate("02 th December");
		
		jobDAO.saveOrUpdateJob(job);
		
		if(jobDAO.getJob("JOB1")== null)
		{
			System.out.println("job does not exist");
		}
		else
		{
			System.out.println("job exists..");
			System.out.println();
		} 

	}
	
}
