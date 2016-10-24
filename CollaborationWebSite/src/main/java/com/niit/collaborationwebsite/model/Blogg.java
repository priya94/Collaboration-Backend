package com.niit.collaborationwebsite.model;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Entity;


import org.springframework.stereotype.Component;

@Entity
@Component

public class Blogg extends BaseDomain{

	@Id
	private String Id;
	private String title;
	private String description;
	private Date createdat;
	private String status;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedat() {
		return createdat;
	}
	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
