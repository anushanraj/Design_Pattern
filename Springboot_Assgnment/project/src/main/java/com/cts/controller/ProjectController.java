package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.DTO.ProjectDTO;
import com.cts.service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private Environment environment;

	@PostMapping(value = "/project")
	public ResponseEntity<String> addProjectDetails(@RequestBody ProjectDTO projectDTO) {
		Integer projectId = projectService.addProject(projectDTO);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + projectId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

	@PutMapping(value = "/project/{projectId}")
	public ResponseEntity<String> updateProjectDetails(@PathVariable int projectId,
			@RequestBody ProjectDTO projectDTO) {
		projectService.updateProject(projectId, projectDTO);
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

	@DeleteMapping(value = "/project/{projectId}")
	public ResponseEntity<String> deleteProjectDetails(@PathVariable int projectId) {
		projectService.deleteProject(projectId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

	@GetMapping(value = "/project")
	public ResponseEntity<List<ProjectDTO>> listProjectDetails() {
		List<ProjectDTO> projects = projectService.getAllProject();
		return new ResponseEntity<>(projects, HttpStatus.OK);
	}

}
