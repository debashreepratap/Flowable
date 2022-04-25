package com.perficient.flowable.flowabledemo2;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(proxyBeanMethods = false)
public class Flowabledemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Flowabledemo2Application.class, args);
	}

	@Bean
	public CommandLineRunner init(final MyService myService) {

	    return new CommandLineRunner() {
	        public void run(String... strings) throws Exception {
	            myService.createDemoUsers();
	        }
	    };
	}
}
