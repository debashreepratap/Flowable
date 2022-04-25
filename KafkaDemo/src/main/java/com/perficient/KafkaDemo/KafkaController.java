package com.perficient.KafkaDemo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kafkaapp")
public class KafkaController {

	@Autowired
	KafkaProducerConfig kafkaProducerConfig;
	
	@Autowired
	UserService userService;
	
	@Autowired
	KafkaTemplate<String,User> kafkaTemplate;
	private String topic="myjsontopic12";

	/*
	 * @GetMapping("/publish/{name}") public String post(@PathVariable("name")
	 * String name) {
	 * 
	 * kafkaTemplate.send(topic,new User(name,"technology",10000L)); return
	 * "Published Succefully";
	 * 
	 * }
	 */
	
	 @PostMapping("/user")
	    public String createCustomer(@RequestBody User user) {
		 User newUser = new User();
		    newUser.setId(UUID.randomUUID().toString());
		    newUser.setName(user.getName());
		    newUser.setDepartment(user.getDepartment());
		    newUser.setSalary(user.getSalary());
	        userService.createUser(newUser);
	        kafkaTemplate.send(topic,newUser);
	        System.out.println("Created customer " + newUser);
	        return "Published Succefully";
	    }
	
}
