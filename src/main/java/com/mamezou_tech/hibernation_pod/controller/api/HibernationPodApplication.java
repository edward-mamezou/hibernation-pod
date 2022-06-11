package com.mamezou_tech.hibernation_pod.controller.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mamezou_tech.hibernation_pod.controller.api", "com.mamezou_tech.hibernation_pod.controller.configuration"})
public class HibernationPodApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernationPodApplication.class, args);
	}
}
