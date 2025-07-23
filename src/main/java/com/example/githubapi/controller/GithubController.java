package com.example.githubapi.controller;

import com.example.githubapi.dto.RepositoryResponse;
import com.example.githubapi.service.GithubService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class GithubController {
	
	private final GithubService githubService;
	
	public GithubController(GithubService githubService) {
		this.githubService = githubService;
	}
	
	@GetMapping("/{username}/repositories")
	public List<RepositoryResponse> geyUserRepositories(@PathVariable String username) {
		return githubService.getRepositories(username);
	}
}