package com.duteliang.product.service.impl;

import com.duteliang.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: zl
 * @Date: 2018-12-26 10:35
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Override
	public String getMessage() {
		String message = String.format("data= %s", new Date());
		log.info("消息={}",message);
		return message;
	}
}
