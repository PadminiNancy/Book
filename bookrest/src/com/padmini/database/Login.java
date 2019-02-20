package com.padmini.database;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Login")
public class Login implements java.io.Serializable{

	@Id
    @GeneratedValue
	
    @Column(name = "teacher_id")
    private int tid;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "Student", cascade = CascadeType.ALL)
    private Set studMarks = new HashSet(0);
	
	public Login()
	{}
	
	public Login(String lastname, String password) {
		super();
		this.lastname = lastname;
		this.password = password;
	}

	
	
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Set getStudMarks() {
		return studMarks;
	}

	public void setStudMarks(Set<Student> studMarks) {
		this.studMarks = studMarks;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
