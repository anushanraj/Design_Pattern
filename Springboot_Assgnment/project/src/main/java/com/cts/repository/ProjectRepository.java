package com.cts.repository;

import org.springframework.data.repository.CrudRepository;

import com.cts.model.Project;

public interface ProjectRepository extends CrudRepository<Project,Integer> {

}
