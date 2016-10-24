package com.niit.collaborationwebsite.model;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Entity;


import org.springframework.stereotype.Component;

@Entity
@Component

public class Event extends BaseDomain{

	@Id
	private String Id;
	private String content;
	private String event_date;
	private Date posted_date;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getEvent_date() {
		return event_date;
	}
	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}
	public Date getPosted_date() {
		return posted_date;
	}
	public void setPosted_date(Date posted_date) {
		this.posted_date = posted_date;
	}
	
	
	
}
