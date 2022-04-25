package com.perficient.employee.service;

import java.util.HashMap;
import java.util.Map;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perficient.employee.delegate.CreateEmployeeJavaDelegate;
import com.perficient.employee.dto.ProcessInstanceResponse;
import com.perficient.employee.model.Employee;
import com.perficient.employee.repository.EmployeeRepository;
@Service
public class EmployeeService {
	
	public static final String PROCESS_DEFINITION_KEY = "oneTaskProcess";
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private RepositoryService repositoryService;
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
	
	public void deployProcessDefinition() {
		Deployment deployment =
		repositoryService
		.createDeployment()
		.addClasspathResource("one-task-process.bpmn20.xml")
		.deploy();

		}

	public ProcessInstanceResponse startProcess(Employee emp) {
		 Map<String, Object> variables = new HashMap<String, Object>();
	        variables.put("name", emp.getName());
	        variables.put("age", emp.getAge());
	        variables.put("dateOfBirth", emp.getDateOfBirth());
	        variables.put("email", emp.getEmail());

	        ProcessInstance processInstance =
	                runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY, variables);
	        Employee employee= new Employee(emp.getName(),emp.getAge(),emp.getDateOfBirth(),emp.getEmail());
	        employeeRepository.save(employee);
	        
	        log.info("Inside EmployeeService ::startProcess");

	        return new ProcessInstanceResponse(processInstance.getId(), processInstance.isEnded());
		
	}

}
