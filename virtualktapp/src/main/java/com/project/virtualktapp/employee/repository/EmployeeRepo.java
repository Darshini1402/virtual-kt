package com.project.virtualktapp.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.virtualktapp.employee.model.EmployeeModel;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeModel, Integer>{

 

}