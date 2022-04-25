package com.perficient.flowable.work.delegate;

import java.util.Map;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component(value = "demoJavaDelegate")
public class DemoJavaDelegate implements JavaDelegate {
	
	private static final Logger log = LoggerFactory.getLogger(DemoJavaDelegate.class);
	
	@Override
	public void execute(DelegateExecution execution) {
		log.info("Inside Demo Java Delegate");
		
		Map<String, Object> variables = execution.getVariables();
		
		//Get Process Instance Id
		String processInstanceId = execution.getProcessInstanceId();
		log.info("Process Instance Id {}",processInstanceId);
		
		
		//Dump variables
		variables.forEach(
				(k,v) -> 
					log.info("Variable Name {} => Varaibale Value {}",k, v.toString())
		);
		
		//Set a new variable
		execution.setVariable("stringValue", "TestValue");
		execution.setVariable("intValue", 10);
		execution.setVariable("doubleValue", 10.5);
		execution.setVariable("booleanValue", true);
		//Object value can also be set.. JsonNode is preferred.
		
		
	}

}
