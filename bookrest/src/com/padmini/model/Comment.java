package com.padmini.model;

import java.util.Date;

public class Comment {
	
	private long id;
	private String message;
	private Date cretaed;
	private String author;
	
	public Comment()
	{
		
	}
	public Comment(long id, String message, String author)
	{
		this.id = id;
		this.message=message;
		this.author=author;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCretaed() {
		return cretaed;
	}
	public void setCretaed(Date cretaed) {
		this.cretaed = cretaed;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	

}
