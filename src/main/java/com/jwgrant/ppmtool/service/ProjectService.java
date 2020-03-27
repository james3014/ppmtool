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

    public Project findByProjectIdentifier(String projectId)
    {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if (project == null) throw new ProjectIdException("Project ID does not exist");

        return project;
    }

    public Iterable<Project> findAllProjects()
    {
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId)
    {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if (project == null) throw new ProjectIdException("Cannot delete as project ID does not exist");

        projectRepository.delete(project);
    }
}
