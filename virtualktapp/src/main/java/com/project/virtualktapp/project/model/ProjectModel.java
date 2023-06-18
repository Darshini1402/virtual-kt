package com.project.virtualktapp.project.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.virtualktapp.team.model.TeamModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PROJECT_TBL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectModel {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sNo;
    private String projectid;
    private String projectname;
    
//    @JsonIgnore
//    @ManyToMany(mappedBy = "assignedProjects")
//    private Set<EmployeeModel> projects = new HashSet();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PROJECT_TEAMS_TBL",
    joinColumns = @JoinColumn(name = "projectid"), inverseJoinColumns = @JoinColumn(name = "teamid"))
    private List<TeamModel> assignedTeams = new ArrayList();
    
	public List<TeamModel> getAssignedTeams() {
		return assignedTeams;
	}
	public void setAssignedTeams(List<TeamModel> assignedTeams) {
		this.assignedTeams = assignedTeams;
	}
	public int getsNo() {
		return sNo;
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

}
