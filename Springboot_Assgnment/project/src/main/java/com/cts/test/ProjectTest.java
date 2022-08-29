package com.cts.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.client.RestTemplate;

import com.cts.DTO.ProjectDTO;

public class ProjectTest {

	private static final Log LOGGER = LogFactory.getLog(ProjectTest.class);

	private static final String URL = "http://localhost:8080/project";

	public static void main(String[] args) throws ParseException {

		String date_string = "25-04-2022";
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = formatter.parse(date_string);
		ProjectDTO project = new ProjectDTO(2, "patience app", 30000.00, 10, 60, date, "Jenny");

		addProject(project);
		updateProject(project);
		deleteProject(2);
		getAllProjects();

	}

	private static void addProject(ProjectDTO project) {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject(URL, project, String.class);
		LOGGER.debug(response);
		LOGGER.debug("\n");
	}

	public static void getAllProjects() {
		RestTemplate restTemplate = new RestTemplate();
		List<ProjectDTO> projects = restTemplate.getForObject(URL, ArrayList.class);
		LOGGER.debug(projects);
		LOGGER.debug("\n");
	}

	public static void updateProject(ProjectDTO project) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(URL + "/" + project.getProjectId(), project);
		LOGGER.info("Project updated successfully");
		LOGGER.info("\n");
	}

	public static void deleteProject(Integer projectId) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(URL + "/" + projectId, projectId);
		LOGGER.info("Project deleted successfully");
		LOGGER.info("\n");
	}
}
