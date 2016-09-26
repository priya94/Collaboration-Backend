package com.niit.collaborationwebsite.model;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Entity;


import org.springframework.stereotype.Component;

@Entity
@Component
public class Forum {

	@Id
	private String Id;
	private String name;
	private String title;
	private String description;
	private Date createdat;
	private Date modifiedat;
	private String status;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Date getModifiedat() {
		return modifiedat;
	}
	public void setModifiedat(Date modifiedat) {
		this.modifiedat = modifiedat;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}

