package com.perficient.KafkaDemo;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;




@Service
public class KafkaConsumerConfig {
 
	
	/*
	 * @KafkaListener(topics="mytopic",groupId="mygroup") public void
	 * consumerFromTopic(String message) {
	 * 
	 * System.out.println("Consumed Message : "+message); }
	 */
	
	@KafkaListener(topics="myjsontopic12", groupId ="group_json122", containerFactory = "userKafkaListenerFactory")
	public void consumeJson(User user) {
		System.out.println("Consumed Json Message ::"+user);
		
	}
}     
