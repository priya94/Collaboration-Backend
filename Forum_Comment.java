package com.niit.collaborationwebsite.model;

import java.util.Date;

import javax.persistence.Id;

public class Forum_Comment extends BaseDomain{

	@Id
	private String fCId;
	private String fCContent;
	private String userId;
	private Date commentedat;
	public String getfCId() {
		return fCId;
	}
	public void setfCId(String fCId) {
		this.fCId = fCId;
	}
	public String getfCContent() {
		return fCContent;
	}
	public void setfCContent(String fCContent) {
		this.fCContent = fCContent;
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
