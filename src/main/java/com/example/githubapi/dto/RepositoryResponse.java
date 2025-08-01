package com.example.githubapi.dto;

import java.util.List;

public record RepositoryResponse(
		String repositoryName,
		String ownerLogin,
		List<BranchResponse> branches
) {}