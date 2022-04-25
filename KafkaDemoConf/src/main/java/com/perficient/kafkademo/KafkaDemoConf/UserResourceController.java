package com.perficient.kafkademo.KafkaDemoConf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafkaapp")
public class UserResourceController {
	
	@Autowired
	KafkaTemplate<String,User> kafkaTemplate;
	private String topic="mytopic1";

	@GetMapping("/publish/{name}")
	public String post(@PathVariable("name") String name) {
		kafkaTemplate.send(topic,new User(name,"technology",10000L));
		return "Published Succefully";
		
	}
}
