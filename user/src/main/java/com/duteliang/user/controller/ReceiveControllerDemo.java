package com.duteliang.user.controller;

import com.duteliang.client.product.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: zl 调用product服务的demo
 * @Date: 2018-12-26 11:00
 */
@RestController
@Slf4j
public class ReceiveControllerDemo {

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * RestTemplate 方式
	 * 其中涉及到负载均衡，SpringCloud 采用Ribbon实现
	 * 关键：ServerList 服务列表， IRule 过滤规则， ServerListFiler
	 *
	 * 默认采用 轮训的策略
	 *
	 */
	@GetMapping("getProductService")
	public String getProductService(){
		String response;

		// 第一种直接通过url获取
//		log.info("第一种方式！" );
//		RestTemplate restTemplate = new RestTemplate();
//		String response = restTemplate.getForObject("http://localhost:8081/getProductMessage", String.class);

		// 第二种通过loadBalancer直接获取
//		log.info("第二种方式！" );
//		ServiceInstance product = loadBalancerClient.choose("product");
//		product.getHost();
//		String format = String.format("http://%s:%s/getProductMessage", product.getHost(), product.getPort());
//		RestTemplate restTemplate = new RestTemplate();
//		response = restTemplate.getForObject(format, String.class);

		// 第三种方式(通过LoadBalancer 注解获取)
		log.info("第三种方式!" );
		response = restTemplate.getForObject("http://product/getProductMessage", String.class);

		log.info("response={}", response);
		return response;



	}


	@Autowired
	private ProductClient productClient;

	/**
	 * 采用feign调用信息
	 * feign 实际为伪RPC
	 *
	 * @return
	 */
	@GetMapping("getProductServiceFeign")
	public String getProductServiceFeign(){
		return productClient.productMsg();
	}





}
