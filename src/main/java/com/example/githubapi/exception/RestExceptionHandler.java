package com.example.githubapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(GithubUserNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleGithubUserNotFound(GithubUserNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				Map.of(
						"status", 404,
						"message", ex.getMessage()
				)
		);
	}
}