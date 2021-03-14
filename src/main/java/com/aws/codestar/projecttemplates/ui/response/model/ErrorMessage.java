package com.aws.codestar.projecttemplates.ui.response.model;

import java.util.Date;



public class ErrorMessage {
	private String message;
	private Date timeStamp;
	
	
	
	public ErrorMessage() {
		super();
	}
	
	public ErrorMessage(String message, Date timeStamp) {
		super();
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}
