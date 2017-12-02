package com.evvemi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackageClasses=com.evvemi.entity.Student.class)
@SpringBootApplication
public class DetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DetailsApplication.class, args);
	}
}
