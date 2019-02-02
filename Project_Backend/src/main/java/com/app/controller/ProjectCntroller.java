package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Project;
import com.app.service.ProjectService;

@RestController
@RequestMapping(value = "/api/project")
public class ProjectCntroller {

	@Autowired
	private ProjectService projectService;

	@PostMapping("/create")
	public ResponseEntity<?> createProject(@Valid @RequestBody Project project, BindingResult result) {

		if(result.hasErrors()) {
			
			return new ResponseEntity<List<FieldError>>(result.getFieldErrors(),HttpStatus.BAD_REQUEST);
		}
		
		Project project1 = projectService.saveProject(project);

		return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllProjects() {

		Iterable<Project> project1 = projectService.retrieveAllProjects();

		return new ResponseEntity<Iterable<Project>>(project1, HttpStatus.OK);
	}
	
	@GetMapping("/{projId}")
	public ResponseEntity<?> getProjectById(@PathVariable String projId) {

		Project project1 = projectService.retrieveProjectById(projId);

		return new ResponseEntity<Project>(project1, HttpStatus.OK);
	}	
	
}
