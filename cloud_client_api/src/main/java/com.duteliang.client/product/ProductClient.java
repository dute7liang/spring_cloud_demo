package com.duteliang.client.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: zl
 * @Date: 2018-12-26 14:06
 */
@FeignClient(name = "product")
public interface ProductClient {

	@GetMapping("/getProductMessage")
	String 	productMsg();
}
