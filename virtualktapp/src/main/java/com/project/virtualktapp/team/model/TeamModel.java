package com.project.virtualktapp.team.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.virtualktapp.employee.model.EmployeeModel;
import com.project.virtualktapp.project.model.ProjectModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TEAM_TBL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamModel {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sNo;
    private String teamid;
    private String teamname;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "assignedToTeams")
    private Set<EmployeeModel> employeeteams = new HashSet();
    
    @JsonIgnore
    @ManyToMany(mappedBy = "assignedTeams")
    private List<ProjectModel> teams = new ArrayList();
    
    
    
	public Set<EmployeeModel> getEmployeeteams() {
		return employeeteams;
	}
	public void setEmployeeteams(Set<EmployeeModel> employeeteams) {
		this.employeeteams = employeeteams;
	}
	public List<ProjectModel> getTeams() {
		return teams;
	}
	public void setTeams(List<ProjectModel> teams) {
		this.teams = teams;
	}
	public int getsNo() {
		return sNo;
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	public String getTeamid() {
		return teamid;
	}
	public void setTeamid(String teamid) {
		this.teamid = teamid;
	}
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

}
