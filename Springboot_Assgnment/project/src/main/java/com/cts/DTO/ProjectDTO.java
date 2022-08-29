package com.cts.DTO;

import java.util.Date;

import com.cts.model.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

	int projectId;

	String titleVar;

	double budget;

	int teamSize;

	int duration;

	Date endDate;

	String managerName;

	public Project toEntity() {
		Project project = new Project();
		project.setProjectId(this.projectId);
		project.setTitleVar(this.titleVar);
		project.setBudget(this.budget);
		project.setTeamSize(this.teamSize);
		project.setDuration(this.duration);
		project.setEndDate(this.endDate);
		project.setManagerName(this.managerName);
		return project;
	}

}
