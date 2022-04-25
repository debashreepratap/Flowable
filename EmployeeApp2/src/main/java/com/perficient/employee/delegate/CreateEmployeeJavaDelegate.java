package com.perficient.employee.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component(value = "createEmployeeJavaDelegate")
public class CreateEmployeeJavaDelegate implements JavaDelegate{

	private static final Logger log = LoggerFactory.getLogger(CreateEmployeeJavaDelegate.class);

	@Override
	public void execute(DelegateExecution execution) {
		log.info("Inside CreateEmployeeJavaDelegate ::execute");
		// TODO Auto-generated method stub
		
	}
}
