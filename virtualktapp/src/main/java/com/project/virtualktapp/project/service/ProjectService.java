package com.project.virtualktapp.project.service;

import java.util.List;

import com.project.virtualktapp.project.model.ProjectModel;


public interface ProjectService {
	
	public ProjectModel saveProject(ProjectModel project);

    public List<ProjectModel> getAllProjects();

    public ProjectModel deleteProject(int sno);
    
    public ProjectModel assignTeam(int projectid, int teamid);


}
