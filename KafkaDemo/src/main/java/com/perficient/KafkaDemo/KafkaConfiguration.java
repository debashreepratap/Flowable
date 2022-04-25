package com.perficient.KafkaDemo;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;


@EnableKafka
@Configuration
public class KafkaConfiguration {

	

	@Bean
	public ConsumerFactory<String,User> userConsumerfactory() {
		
		
		Map<String,Object> config= new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG,"group_json122");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<String,User>(config,new StringDeserializer(),new JsonDeserializer<>(User.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, User> userKafkaListenerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, User> factory= new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(userConsumerfactory());
		return factory;
		
		
	}
	
	@Bean
	public ProducerFactory<String,User> producerfactory() {
			Map<String,Object> config =new HashMap<>();
			config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
			config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
			config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
			return new DefaultKafkaProducerFactory<>(config);
		}
		
	@Bean
	public KafkaTemplate<String,User> kafkaTemplate() {
			return new KafkaTemplate<String,User>(producerfactory());
			
		}
}
