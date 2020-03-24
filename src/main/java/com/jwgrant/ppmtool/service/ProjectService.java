package com.jwgrant.ppmtool.service;

import com.jwgrant.ppmtool.exception.ProjectIdException;
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
        try
        {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            projectRepository.save(project);
        }
        catch (Exception e)
        {
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase()
                    + " ' already exists");
        }
    }
}
