package com.chainsys.movieapplication.model;

public class Register {
	private String name;
	private String email;
	private Long phonenumber;
	private String password;
	private int status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Register [name=" + name + ", email=" + email + ", phonenumber="
				+ phonenumber + ", password=" + password + ", status=" + status
				+ "]";
	}
	
}
