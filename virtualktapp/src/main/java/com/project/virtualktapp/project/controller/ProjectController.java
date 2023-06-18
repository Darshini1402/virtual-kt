package com.project.virtualktapp.project.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.virtualktapp.project.model.ProjectModel;
import com.project.virtualktapp.project.service.ProjectService;


@RestController
@CrossOrigin("*")
@RequestMapping(value="/project")
public class ProjectController {
	
	@Autowired
    private ProjectService projectService;


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createProject(@RequestBody ProjectModel project)
    {
        ProjectModel projectResponse = projectService.saveProject(project);

        return new ResponseEntity<ProjectModel>(projectResponse, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectModel> getProjects()
    {
        List<ProjectModel> projectResponse = projectService.getAllProjects();

        return new ResponseEntity(projectResponse, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteProject/sno/{sno}")
    public ResponseEntity<?> deleteProject(@PathVariable int sno)
    {
    	ProjectModel projectResponse = projectService.deleteProject(sno);

        return new ResponseEntity<ProjectModel>(projectResponse, HttpStatus.OK);
    }
    
    @PutMapping(value = "/{projectid}/team/{teamid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ProjectModel assignTeam(@PathVariable int projectid, @PathVariable int teamid){
        return projectService.assignTeam(projectid,teamid);

    }

}
