package com.joacomele.tripplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:local-sensitive.conf")
public class TripPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripPlannerApplication.class, args);
	}

}
