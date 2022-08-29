package com.cts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.DTO.ProjectDTO;
import com.cts.exception.ProjectNotFoundException;
import com.cts.model.Project;
import com.cts.repository.ProjectRepository;

@Service("projectService")
@Transactional
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project getProject(Integer projectId) {
		Optional<Project> optional = projectRepository.findById(projectId);
		return optional.orElseThrow(() -> new ProjectNotFoundException("Service.PROJECT_NOT_FOUND"));
	}

	public Integer addProject(ProjectDTO dto) {
		Project entity = dto.toEntity();
		Project project = projectRepository.save(entity);
		return project.getProjectId();
	}

	public void updateProject(Integer projectId, ProjectDTO dto) {
		Optional<Project> optional = projectRepository.findById(projectId);
		Project project = optional.orElseThrow(() -> new ProjectNotFoundException("Service.PROJECT_NOT_FOUND"));
		project.setTitleVar(dto.getTitleVar());
		project.setBudget(dto.getBudget());
		project.setTeamSize(dto.getTeamSize());
		project.setDuration(dto.getDuration());
		project.setEndDate(dto.getEndDate());
		project.setManagerName(dto.getManagerName());
		projectRepository.save(project);
	}

	public void deleteProject(Integer projectId) {
		Optional<Project> optional = projectRepository.findById(projectId);
		optional.orElseThrow(() -> new ProjectNotFoundException("Service.PROJECT_NOT_FOUND"));
		projectRepository.deleteById(projectId);
	}

	public List<ProjectDTO> getAllProject() {
		Iterable<Project> projects = projectRepository.findAll();
		List<ProjectDTO> projectDTOs = new ArrayList<>();
		projects.forEach(project -> projectDTOs.add(project.toDTO()));
		if (projectDTOs.isEmpty())
			throw new ProjectNotFoundException("Service.PROJECTS_NOT_FOUND");
		return projectDTOs;
	}

}
