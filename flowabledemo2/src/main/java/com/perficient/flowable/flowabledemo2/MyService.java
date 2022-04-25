package com.perficient.flowable.flowabledemo2;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	 @Autowired
	    private RuntimeService runtimeService;

	    @Autowired
	    private TaskService taskService;

	    @Autowired
	    private UserRepository userRepository;

	    public void startProcess(String assignee) {

	        User user = userRepository.findByUsername(assignee);

	        Map<String, Object> variables = new HashMap<String, Object>();
	        variables.put("user", user);
	        runtimeService.startProcessInstanceByKey("oneTaskProcess", variables);
	    }

	    public List<Task> getTasks(String assignee) {
	        return taskService.createTaskQuery().taskAssignee(assignee).list();
	    }

	    public void createDemoUsers() {
	        if (userRepository.findAll().size() == 0) {
	        	userRepository.save(new User("jbarrez", "Joram", "Barrez", new Date()));
	        	userRepository.save(new User("trademakers", "Tijs", "Rademakers", new Date()));
	        }
	    }

	}