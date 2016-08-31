package com.obdgp.Models;

public class users {
	public users() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;
	private  long username;
	private long pass;
	private long Email;
	private long fullname;
	public long getFullname() {
		return fullname;
	}
	public void setFullname(long fullname) {
		this.fullname = fullname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getUsername() {
		return username;
	}
	public void setUsername(long username) {
		this.username = username;
	}
	public long getPass() {
		return pass;
	}
	public void setPass(long pass) {
		this.pass = pass;
	}
	public long getEmail() {
		return Email;
	}
	public void setEmail(long email) {
		Email = email;
	}



}
