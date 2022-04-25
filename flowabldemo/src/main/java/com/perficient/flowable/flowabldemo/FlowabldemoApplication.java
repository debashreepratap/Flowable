package com.perficient.flowable.flowabldemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(proxyBeanMethods=false)
@ComponentScan(basePackages = "com.perficient.flowable.flowabldemo")
public class FlowabldemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowabldemoApplication.class, args);
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
