package com.sj.myGomoku.dto;

public class GomokuUserDTO {
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		System.out.println("username("+username+") is set");
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		System.out.println("password("+password+") is set");
		this.password = password;
	}
	
	
}
