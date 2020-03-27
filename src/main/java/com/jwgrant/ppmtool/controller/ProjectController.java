package com.jwgrant.ppmtool.controller;

import com.jwgrant.ppmtool.model.Project;
import com.jwgrant.ppmtool.service.MapValidationService;
import com.jwgrant.ppmtool.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/project")
public class ProjectController
{
    private final ProjectService projectService;
    private final MapValidationService mapValidationService;

    public ProjectController(ProjectService projectService, MapValidationService mapValidationService)
    {
        this.projectService = projectService;
        this.mapValidationService = mapValidationService;
    }

    @PostMapping("")
    public ResponseEntity<?> createProject(@Valid @RequestBody final Project project, BindingResult result)
    {
        ResponseEntity<?> errors = mapValidationService.checkErrors(result);
        if (errors != null) return errors;
        projectService.save(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId)
    {
        Project project = projectService.findByProjectIdentifier(projectId);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
}
