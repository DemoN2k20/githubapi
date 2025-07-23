package com.example.githubapi.dto.github;

public class GithubRepository {
	private String name;
	private boolean fork;
	private GithubOwner owner;
	
	public String getName() { return name; }
	public boolean isFork() { return fork; }
	public GithubOwner getOwner() { return owner; }
}