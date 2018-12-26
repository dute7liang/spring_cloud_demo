package com.duteliang.client.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: zl
 * @Date: 2018-12-26 14:06
 */
@FeignClient(name = "user")
public interface UserClient {


	@GetMapping("message/getMessage")
	String 	getMessage();
}
