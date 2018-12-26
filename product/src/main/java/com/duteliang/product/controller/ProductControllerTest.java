package com.duteliang.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author: zl
 * @Date: 2018-12-26 18:20
 */
@RequestMapping(value = "message")
@RestController
public class ProductControllerTest {

	@GetMapping("getMessage")
	public String getMessage(HttpServletRequest request){

		return "product message getMessage "+ new Date();
	}

}
