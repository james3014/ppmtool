package com.jwgrant.ppmtool.controller;

import com.jwgrant.ppmtool.model.Project;
import com.jwgrant.ppmtool.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<?> createProject(@Valid @RequestBody final Project project, BindingResult result)
    {
        if (result.hasErrors())
        {
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : result.getFieldErrors())
            {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }

        projectService.save(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }
}
