package com.perficient.flowable.FlowableProcessDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlowableProcessDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowableProcessDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(final ArticleWorkflowService myService) {

	    return new CommandLineRunner() {
	        public void run(String... strings) throws Exception {
	            myService.createDemoUsers();
	        }
	    };
	}
}
