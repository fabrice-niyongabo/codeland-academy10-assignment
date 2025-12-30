package com.example.car_mgnt_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class CarMgntBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarMgntBackendApplication.class, args);
	}

}
