package com.f2d.group_builder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableDiscoveryClient
public class GroupBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupBuilderApplication.class, args);
	}

}
