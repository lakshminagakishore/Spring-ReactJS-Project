package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ProjectRepo;
import com.app.dto.Project;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepo projectRepo;

	public Project saveProject(Project project) {

		Project project1 = projectRepo.save(project);

		return project1;
	}

	public Iterable<Project> retrieveAllProjects() {

		Iterable<Project> project1 = projectRepo.findAll();

		return project1;
	}

	public Project retrieveProjectById(String projId) {

		Project project1 = projectRepo.findByProjectIdentifier(projId);
				
		return project1;
	}

}
