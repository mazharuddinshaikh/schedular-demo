package com.mazze.schedular;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SchedularDemoApplication {

	public static void main(String[] args) {
		System.out.println("Hello World")
		new SpringApplicationBuilder(SchedularDemoApplication.class).headless(false).run(args);
	}

}
