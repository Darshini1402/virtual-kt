package com.project.virtualktapp.team.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.virtualktapp.team.model.TeamModel;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/team")
public class TeamController {
	
	@Autowired
    private com.project.virtualktapp.team.service.TeamService teamService;


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTeam(@RequestBody TeamModel team)
    {
        com.project.virtualktapp.team.model.TeamModel teamResponse = teamService.saveTeam(team);

        return new ResponseEntity<TeamModel>(teamResponse, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeamModel> getTeams()
    {
        List<TeamModel> teamResponse = teamService.getAllTeams();

        return new ResponseEntity(teamResponse, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteTeam/sno/{sno}")
    public ResponseEntity<?> deleteTeam(@PathVariable int sno)
    {
        TeamModel teamResponse = teamService.deleteTeam(sno);

        return new ResponseEntity<TeamModel>(teamResponse, HttpStatus.OK);
    }

}
