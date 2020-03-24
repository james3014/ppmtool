package com.jwgrant.ppmtool.service;

import com.jwgrant.ppmtool.model.Project;
import com.jwgrant.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService
{
    @Autowired
    private ProjectRepository projectRepository;

    public Project save(Project project)
    {
        return projectRepository.save(project);
    }

}
