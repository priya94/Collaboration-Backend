package com.niit.collaborationwebsite.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component


public class Blogg_Comment {

	@Id
	private String bCId;
	private String bCContent;
	private String userId;
	private Date commentedat;
	
	public String getbCId() {
		return bCId;
	}
	public void setbCId(String bCId) {
		this.bCId = bCId;
	}
	public String getbCContent() {
		return bCContent;
	}
	public void setbCContent(String bCContent) {
		this.bCContent = bCContent;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getCommentedat() {
		return commentedat;
	}
	public void setCommentedat(Date commentedat) {
		this.commentedat = commentedat;
	}
	
	
	
	
}
