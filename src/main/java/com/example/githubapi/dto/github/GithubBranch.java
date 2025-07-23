package com.example.githubapi.dto.github;

public class GithubBranch {
	private String name;
	private GithubCommit commit;
	
	public String getName() { return name; }
	public GithubCommit getCommit() { return commit; }
}