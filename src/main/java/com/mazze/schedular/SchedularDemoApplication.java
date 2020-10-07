package com.mazze.schedular;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SchedularDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SchedularDemoApplication.class).headless(false).run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Jenkin test commit");
	}

}
