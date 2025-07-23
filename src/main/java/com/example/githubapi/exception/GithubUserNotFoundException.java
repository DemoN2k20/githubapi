package com.example.githubapi.exception;

public class GithubUserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private final String username;
	
	public GithubUserNotFoundException(String username) {
		super("GitHub user '" + username + "' not found");
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
}