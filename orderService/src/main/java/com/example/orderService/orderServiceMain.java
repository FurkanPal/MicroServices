package com.example.orderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class orderServiceMain {

	public static void main(String[] args) {
		SpringApplication.run(orderServiceMain.class, args);
	}

}
