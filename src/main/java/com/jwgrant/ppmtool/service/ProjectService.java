package com.jwgrant.ppmtool.service;

import com.jwgrant.ppmtool.model.Project;
import com.jwgrant.ppmtool.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService
{
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository)
    {
        this.projectRepository = projectRepository;
    }

    public void save(Project project)
    {
        projectRepository.save(project);
    }

}
