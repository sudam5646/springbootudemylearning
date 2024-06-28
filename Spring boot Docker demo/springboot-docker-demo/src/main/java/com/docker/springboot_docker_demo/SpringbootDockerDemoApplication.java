package com.docker.springboot_docker_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SpringbootDockerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDockerDemoApplication.class, args);
	}

}
