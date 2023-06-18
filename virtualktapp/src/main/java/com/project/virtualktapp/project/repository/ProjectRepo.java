package com.project.virtualktapp.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.virtualktapp.project.model.ProjectModel;

@Repository
public interface ProjectRepo extends JpaRepository<ProjectModel, Integer>{

}
