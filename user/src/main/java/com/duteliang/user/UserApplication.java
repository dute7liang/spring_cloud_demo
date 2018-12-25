package com.duteliang.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: zl
 * @Date: 2018-12-25 12:03
 */
@SpringBootApplication(scanBasePackages = {"com.duteliang"})
@EnableEurekaClient
public class UserApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserApplication.class, args);


	}

}
