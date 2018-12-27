package com.duteliang.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: zl
 * @Date: 2018-12-25 12:03
 */
@SpringBootApplication(scanBasePackages = {"com.duteliang"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.duteliang.client"})
@EnableCircuitBreaker
@EnableHystrixDashboard
public class UserApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserApplication.class, args);

	}

}
