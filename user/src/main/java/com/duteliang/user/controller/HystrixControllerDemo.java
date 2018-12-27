package com.duteliang.user.controller;

import com.duteliang.client.product.ProductClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * hystrix demo
 *
 * @author: zl
 * @Date: 2018-12-27 16:47
 */
@RestController
@RequestMapping("hystrix")
@Slf4j
// 默认的服务降级，貌似不能指定传递参数，比如name 不能传递进入，必须是无参？
@DefaultProperties(defaultFallback = "defaultProductFallBack")
public class HystrixControllerDemo {

	@Autowired
	private ProductClient productClient;

	// 服务降级的方法
//	@HystrixCommand(fallbackMethod = "getProductFallBack")

	@HystrixCommand(fallbackMethod = "getProductFallBack",commandProperties = {
		// 超时时间
		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "8000"),
		// 熔断参数
		@HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启熔断器
		@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求阈值
		@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 休眠时间窗口
		@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 错误的百分比
	})
	@GetMapping(value = "getProduct")
	public String getProduct(@RequestParam("name") String name){
		log.info("start name = {}", name);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		return "你收到了正确的请求！";
		String s = productClient.productMsg();
		log.info("end name = {}", name);
		return s;
	}

	private String defaultProductFallBack(){
		log.info("默认的 服务降级 name = {}");
		return "默认的 服务降级了！！！";
	}


	private String getProductFallBack(String name){
		log.info("服务降级 name = {}", name);
		return "服务降级了！！！" + name;
	}

}
