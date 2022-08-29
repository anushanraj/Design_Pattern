package com.cts.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cts.DTO.ProjectDTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Project_Details")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int projectId;

	String titleVar;

	double budget;

	int teamSize;

	int duration;

	Date endDate;

	String managerName;

	public ProjectDTO toDTO() {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectId(this.projectId);
		projectDTO.setTitleVar(this.titleVar);
		projectDTO.setBudget(this.budget);
		projectDTO.setTeamSize(this.teamSize);
		projectDTO.setDuration(this.duration);
		projectDTO.setEndDate(this.endDate);
		projectDTO.setManagerName(this.managerName);
		return projectDTO;
	}

}
