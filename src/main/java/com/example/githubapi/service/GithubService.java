package com.example.githubapi.service;

import com.example.githubapi.client.GithubClient;
import com.example.githubapi.dto.BranchResponse;
import com.example.githubapi.dto.RepositoryResponse;
import com.example.githubapi.dto.github.GithubBranch;
import com.example.githubapi.dto.github.GithubRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GithubService {
	
	private final GithubClient githubClient;
	
	public GithubService(GithubClient githubClient) {
		this.githubClient = githubClient;
	}
	
	public List<RepositoryResponse> getRepositories(String username) {
		List<GithubRepository> repos = githubClient.getRepositories(username);
		return repos.stream()
				.filter(repo -> !repo.isFork())
				.map(repo -> {
					List<GithubBranch> branches = githubClient.getBranches(username, repo.getName());
					List<BranchResponse> branchResponses = branches.stream()
							.map(branch -> new BranchResponse(branch.getName(), branch.getCommit().getSha()))
							.toList();
					return new RepositoryResponse(repo.getName(), repo.getOwner().getLogin(), branchResponses);
				}).toList();
	}
}