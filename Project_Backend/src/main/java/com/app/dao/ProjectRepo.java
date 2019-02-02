package com.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.dto.Project;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long> {

	
	Project findByProjectIdentifier(String projId);
	
	
}
