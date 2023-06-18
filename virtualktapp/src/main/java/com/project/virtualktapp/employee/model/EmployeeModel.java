package com.project.virtualktapp.employee.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.project.virtualktapp.team.model.TeamModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 

@Entity
@Table(name="EMPLOYEE_TBL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sNo;
    @Column(unique=true, nullable=false)
    private String employeeid;
    private String employeename;
    private String email;
	private String password;
    private String employeetype;
    
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "EMLOYEE_PROJECT_TBL",
//    joinColumns = @JoinColumn(name = "employeeid"), inverseJoinColumns = @JoinColumn(name = "projectid"))
//    private Set<ProjectModel> assignedProjects = new HashSet();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "EMPLOYEE_TEAM_TBL",
    joinColumns = @JoinColumn(name = "employeeid"), inverseJoinColumns = @JoinColumn(name = "teamid"))
    private Set<TeamModel> assignedToTeams = new HashSet();

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmployeetype() {
		return employeetype;
	}

	public void setEmployeetype(String employeetype) {
		this.employeetype = employeetype;
	}

	public Set<TeamModel> getAssignedToTeams() {
		return assignedToTeams;
	}

	public void setAssignedToTeams(Set<TeamModel> assignedToTeams) {
		this.assignedToTeams = assignedToTeams;
	}

	public EmployeeModel(String employeeid, String employeename, String email, String password, String employeetype,
			Set<TeamModel> assignedToTeams) {
		super();
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.email = email;
		this.password = password;
		this.employeetype = employeetype;
		this.assignedToTeams = assignedToTeams;
	}

	public EmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
