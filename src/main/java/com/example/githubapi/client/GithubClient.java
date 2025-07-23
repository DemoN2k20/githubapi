package com.example.githubapi.client;

import com.example.githubapi.dto.github.GithubBranch;
import com.example.githubapi.dto.github.GithubRepository;
import com.example.githubapi.exception.GithubUserNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

import java.util.List;

@Component
public class GithubClient {
	
	private final RestClient restClient;
	
	public GithubClient() {
		this.restClient = RestClient.create();
	}
	
	public List<GithubRepository> getRepositories(String username) {
		try {
			return List.of(restClient.get()
					.uri("https://api.github.com/users/{username}/repos", username)
					.retrieve()
					.body(GithubRepository[].class));
		} catch (RestClientResponseException e) {
			if (HttpStatusCode.valueOf(e.getStatusCode().value()).is4xxClientError()) {
				throw new GithubUserNotFoundException(username);
			}
			throw e;
		}
	}
	
	public List<GithubBranch> getBranches(String username, String repoName) {
		return List.of(restClient.get()
				.uri("https://api.github.com/repos/{username}/{repo}/branches", username, repoName)
				.retrieve()
				.body(GithubBranch[].class));
	}
}