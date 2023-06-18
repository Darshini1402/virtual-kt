package com.project.virtualktapp.team.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.virtualktapp.team.model.TeamModel;
import com.project.virtualktapp.team.repository.TeamRepo;
import com.project.virtualktapp.team.service.TeamService;

@Service
public class TeamImpl implements TeamService{
	
	@Autowired
    private TeamRepo teamRepo;

	public TeamModel saveTeam(TeamModel team) {
		// TODO Auto-generated method stub
		return teamRepo.save(team);
	}

	public List<TeamModel> getAllTeams() {
		// TODO Auto-generated method stub
		return teamRepo.findAll();
	}

	public TeamModel deleteTeam(int sno) {
		// TODO Auto-generated method stub
		try
		{
			Optional<TeamModel> op = teamRepo.findById(sno);
			
			teamRepo.deleteById(sno);
			
			return op.get();
		}
		catch(Exception e)
		{
			return null;
		}
	}




}
