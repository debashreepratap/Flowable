package com.perficient.KafkaConsumerExample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	
	@KafkaListener(topics="mytopic1", groupId ="group_id")
	public void consume(String message) {
		System.out.println("message ::"+message);
	}
	
	@KafkaListener(topics="myjsontopic12", groupId ="group_json122", containerFactory = "userKafkaListenerFactory")
	public void consumeJson(User user) {
		System.out.println("Consumed Json Message ::"+user);
		
	}
}
