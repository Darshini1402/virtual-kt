package com.project.virtualktapp.project.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.virtualktapp.project.model.ProjectModel;
import com.project.virtualktapp.project.repository.ProjectRepo;
import com.project.virtualktapp.project.service.ProjectService;
import com.project.virtualktapp.team.model.TeamModel;
import com.project.virtualktapp.team.repository.TeamRepo;

@Service
public class ProjectImpl implements ProjectService{

	@Autowired
	ProjectRepo projectRepo;
	@Autowired
	TeamRepo teamRepo;
	
	public ProjectModel saveProject(ProjectModel project) {
		// TODO Auto-generated method stub
		return projectRepo.save(project);
	}

	public List<ProjectModel> getAllProjects() {
		// TODO Auto-generated method stub
		return projectRepo.findAll();
	}

	public ProjectModel deleteProject(int sno) {
		// TODO Auto-generated method stub
		try
		{
			Optional<ProjectModel> op = projectRepo.findById(sno);
			
			projectRepo.deleteById(sno);
			
			return op.get();
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public ProjectModel assignTeam(int projectid, int teamid) {
		// TODO Auto-generated method stub
		List<TeamModel> teamlist = null;
        ProjectModel projectmodel = projectRepo.findById(projectid).get();
        TeamModel teammodel = teamRepo.findById(teamid).get();

        teamlist = projectmodel.getAssignedTeams();

        teamlist.add(teammodel);

        projectmodel.setAssignedTeams(teamlist);

        return projectRepo.save(projectmodel);
	}

}
