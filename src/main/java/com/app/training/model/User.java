package com.app.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/*
 * This is the table representation, but in spring Boot;
 * */
@Entity
@Table(name ="users")
public class User {
	/*
	 * this
	 * */
	@Id /* this is  reference, that id is this ID*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)/* this is the same that auto increment in sql*/
	private long id;
	
	@Column(name ="full_name") /* THIS  is to say that private full name, is the same that colum full name in sql*/
	private String fullname;
	

	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	private String email;
	private String password;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
