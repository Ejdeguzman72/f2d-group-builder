package com.f2d.group_builder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class GroupBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupBuilderApplication.class, args);
	}

}
