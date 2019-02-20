package com.padmini.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	@GeneratedValue
	
	@Column(name = "student_id")
	private int sid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "grade")	
	private String grade;
	
	@ManyToOne
    @JoinColumn(name = "teacher_id")
	private Login login;
	
	public Student() {
		super();
	}


	public Student(String name, String grade) {
		super();
		this.name = name;
		this.grade = grade;
	}

	

	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}

	
	
}
