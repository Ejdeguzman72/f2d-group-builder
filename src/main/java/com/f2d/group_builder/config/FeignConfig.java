package com.f2d.group_builder.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

@Component
@EnableFeignClients(basePackages = "com.f2d.group_builder.feign")
public class FeignConfig {
}
