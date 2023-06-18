package com.project.virtualktapp.employee.service;

import java.util.List;

import com.project.virtualktapp.employee.model.EmployeeModel;

public interface EmployeeService {

	public EmployeeModel saveEmployee(EmployeeModel employee);

    public List<EmployeeModel> getAllEmployees();

    public EmployeeModel deleteEmployee(int sno);
    
    public EmployeeModel updatePassword(EmployeeModel employee);

	public EmployeeModel assignToTeam(int userid, int teamid);
	
	public EmployeeModel updateEmployeeDetails(EmployeeModel employee);

}
