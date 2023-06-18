package com.project.virtualktapp.team.service;

import java.util.List;

import com.project.virtualktapp.team.model.TeamModel;

public interface TeamService {
	
	public TeamModel saveTeam(TeamModel team);

    public List<TeamModel> getAllTeams();

    public TeamModel deleteTeam(int sno);

}
