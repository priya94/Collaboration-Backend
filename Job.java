package com.niit.collaborationwebsite.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Job {

	@Id
	private String Id;
	private String jobtitle;
	private String description;
	private String qualification;
	private String lastSubmissionDate;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getLastSubmissionDate() {
		return lastSubmissionDate;
	}
	public void setLastSubmissionDate(String lastSubmissionDate) {
		this.lastSubmissionDate = lastSubmissionDate;
	}
	
	
	
}
