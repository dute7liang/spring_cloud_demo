package com.duteliang.product.controller;

import com.duteliang.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zl
 * @Date: 2018-12-26 10:55
 */
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("getProductMessage")
	public String getMessage(){
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return productService.getMessage();
	}

}
