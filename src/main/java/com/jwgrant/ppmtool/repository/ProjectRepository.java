package com.jwgrant.ppmtool.repository;

import com.jwgrant.ppmtool.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>
{
    Project findByProjectIdentifier(String project);
}
