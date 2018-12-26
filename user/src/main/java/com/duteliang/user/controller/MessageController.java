package com.duteliang.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author: zl
 * @Date: 2018-12-26 17:45
 */
@RestController
@RequestMapping(value = "message")
public class MessageController {

	@GetMapping(value = "getMessage")
	public String getMessage(HttpServletRequest request){
		return "user message = " + new Date();

	}
}
