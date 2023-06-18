package com.project.virtualktapp.employee.controller;

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

import com.project.virtualktapp.employee.model.EmployeeModel;
import com.project.virtualktapp.employee.service.EmployeeService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeModel employee)
    {
        EmployeeModel employeeResponse = employeeService.saveEmployee(employee);

        return new ResponseEntity<EmployeeModel>(employeeResponse, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeModel> getEmployees()
    {
        List<EmployeeModel> employeeResponse = employeeService.getAllEmployees();

        return new ResponseEntity(employeeResponse, HttpStatus.OK);
    }
    
    @PutMapping("/updatePassword")
    public ResponseEntity<?> updatePassword(@RequestBody EmployeeModel employee)
    {
        EmployeeModel employeeResponse = employeeService.updatePassword(employee);

        return new ResponseEntity<EmployeeModel>(employeeResponse, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteEmployee/sno/{sno}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int sno)
    {
        EmployeeModel employeeResponse = employeeService.deleteEmployee(sno);

        return new ResponseEntity<EmployeeModel>(employeeResponse, HttpStatus.OK);
    }
    
    @PutMapping(value = "/{employeeid}/team/{teamid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeModel assignToTeam(@PathVariable int employeeid, @PathVariable int teamid){
        return employeeService.assignToTeam(employeeid,teamid);

    }
    
    @PutMapping("/updateEmployeeDetails")
    public ResponseEntity<?> updateEmployeeDetails(@RequestBody EmployeeModel employee)
    {
        EmployeeModel employeeResponse = employeeService.updateEmployeeDetails(employee);

        return new ResponseEntity<EmployeeModel>(employeeResponse, HttpStatus.OK);
    }

 

}
