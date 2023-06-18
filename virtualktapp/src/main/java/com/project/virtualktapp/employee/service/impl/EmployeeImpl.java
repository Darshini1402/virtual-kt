package com.project.virtualktapp.employee.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

//import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.virtualktapp.employee.model.EmployeeModel;
import com.project.virtualktapp.employee.repository.EmployeeRepo;
import com.project.virtualktapp.employee.service.EmployeeService;
import com.project.virtualktapp.team.model.TeamModel;
import com.project.virtualktapp.team.repository.TeamRepo;

@Service
public class EmployeeImpl implements EmployeeService{
	
	  @Autowired
	    private EmployeeRepo employeeRepo;
	    @Autowired
	    private TeamRepo teamRepo;
 
	  public EmployeeModel saveEmployee(EmployeeModel employee) {
			// TODO Auto-generated method stub
		  	String password = "VirtualKT@123";
		  	employee.setPassword(password);
		  	return employeeRepo.save(employee);
		}

		public List<EmployeeModel> getAllEmployees() {
			// TODO Auto-generated method stub
			return employeeRepo.findAll();
		}

		public EmployeeModel deleteEmployee(int sno) {
			// TODO Auto-generated method stub
			try
			{
				Optional<EmployeeModel> op = employeeRepo.findById(sno);
				employeeRepo.deleteById(sno);
				return op.get();
			}
			catch(Exception e)
			{
				return null;
			}
		}

		public EmployeeModel updatePassword(EmployeeModel employee) {
			// TODO Auto-generated method stub
			try
			{
				Optional<EmployeeModel> op = employeeRepo.findById(employee.getsNo());
				
				if(op.get() == null)
				{
					return null;
				}
				else
				{
					EmployeeModel employee1 = op.get();
					employee1.setPassword(employee.getPassword());
					return employeeRepo.save(employee1);
				}
			}
			catch(Exception e)
			{
				return null;
			}
		}

		public EmployeeModel assignToTeam(int employeeid, int teamid) {
			Set<TeamModel> teamSet = null;
	        EmployeeModel employeeModel = employeeRepo.findById(employeeid).get();
	        TeamModel teamModel = teamRepo.findById(teamid).get();

	        teamSet = employeeModel.getAssignedToTeams();

	        teamSet.add(teamModel);

	        employeeModel.setAssignedToTeams(teamSet);

	        return employeeRepo.save(employeeModel);
		}

		public EmployeeModel updateEmployeeDetails(EmployeeModel employee) {
			// TODO Auto-generated method stub
			try
			{
				Optional<EmployeeModel> op = employeeRepo.findById(employee.getsNo());
				
				if(op.get() == null)
				{
					return null;
				}
				else
				{
					EmployeeModel employee1 = op.get();
					employee1.setEmployeename(employee.getEmployeename());
					employee1.setEmail(employee.getEmail());
					employee1.setEmployeetype(employee.getEmployeetype());
					return employeeRepo.save(employee1);
				}
			}
			catch(Exception e)
			{
				return null;
			}
		}

		

}
