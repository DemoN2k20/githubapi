package com.example.githubapi.integration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GithubApiIntegrationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void shouldReturnNonForkRepositoriesWithBranches() {
		ResponseEntity<String> response = restTemplate.getForEntity(
				"/api/users/octocat/repositories", 
				String.class
		);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).contains("repositoryName", "ownerLogin", "branches");
	}
}