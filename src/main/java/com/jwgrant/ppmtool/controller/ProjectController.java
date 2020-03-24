package com.jwgrant.ppmtool.controller;

import com.jwgrant.ppmtool.model.Project;
import com.jwgrant.ppmtool.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController
{
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService)
    {
        this.projectService = projectService;
    }

    @PostMapping("")
    public ResponseEntity<Project> createProject(@RequestBody Project project)
    {
        projectService.save(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }
}
