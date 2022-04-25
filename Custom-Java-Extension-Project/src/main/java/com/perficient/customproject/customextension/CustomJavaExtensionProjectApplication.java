package com.perficient.customproject.customextension;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;

@SpringBootApplication(exclude = {
	    FreeMarkerAutoConfiguration.class
	})
public class CustomJavaExtensionProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomJavaExtensionProjectApplication.class, args);
	}

}
