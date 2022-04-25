package com.perficient.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.employee.dto.ProcessInstanceResponse;
import com.perficient.employee.model.Employee;
import com.perficient.employee.service.EmployeeService;



@RestController
public class EmployeeController {
	
	 @Autowired
	    private EmployeeService employeeService;
	 
	 @PostMapping("/deploy")
	 public void deployWorkflow() {
	 employeeService.deployProcessDefinition();
	 }

    @PostMapping(value="/create")
    public ProcessInstanceResponse create(@RequestBody Employee employee) {
        return employeeService.startProcess(employee);
    }

}
