package com.duteliang.geteway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * @author: zl
 * @Date: 2018-12-26 17:32
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class GatewayApplication {

	public static void main(String[] args) {

		SpringApplication.run(GatewayApplication.class, args);

	}


	/**
	 * 1. controller上加上 @CrossOrigin 跨域注解
	 * 2. 使用拦截器直接对指定path进行处理
	 */
	@Bean
	public CorsFilter corsFilter(){
		final UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		// 是否支持 cookie 跨域
		config.setAllowCredentials(true);
		// 原始域
		config.setAllowedOrigins(Arrays.asList("*"));
		// 允许跨域的头部信息
		config.setAllowedHeaders(Arrays.asList("*"));
		// 允许跨域的类型，get post put
		config.setAllowedMethods(Arrays.asList("*"));
		// 跨域的缓存时间 (秒)
		config.setMaxAge(300L);

		configurationSource.registerCorsConfiguration("/**", config);
		return new CorsFilter(configurationSource);
	}


}
