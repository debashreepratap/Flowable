package com.perficient.flowable.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;

@SpringBootApplication(exclude = {
	    FreeMarkerAutoConfiguration.class
	})
public class ReturnToWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReturnToWorkApplication.class, args);
	}

}
