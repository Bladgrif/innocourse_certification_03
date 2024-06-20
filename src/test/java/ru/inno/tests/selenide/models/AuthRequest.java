package ru.inno.tests.selenide.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthRequest{

	@JsonProperty("password")
	private String password;

	@JsonProperty("userName")
	private String userName;

	public String getPassword(){
		return password;
	}

	public String getUserName(){
		return userName;
	}

	public AuthRequest setPassword(String password) {
		this.password = password;
		return this;
	}

	public AuthRequest setUserName(String userName) {
		this.userName = userName;
		return this;
	}
}