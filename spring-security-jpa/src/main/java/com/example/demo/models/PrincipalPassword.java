package com.example.demo.models;

import java.security.Principal;

public class PrincipalPassword {
	private Principal principal;
	private String password;

	public Principal getPrincipal() {
		return principal;
	}
	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
