package com.duteliang.user.controller;

import com.duteliang.user.rabbit_test.RabbitSendTest;
import com.duteliang.user.rabbit_test.MyStreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: zl
 * @Date: 2018-12-26 14:53
 */
@RestController
public class RabbitControllerTest {

	@Autowired
	private RabbitSendTest rabbitSendTest;

	@GetMapping(value = "sendRabbitString")
	public void sendRabbitString(Integer i){
		rabbitSendTest.sendQueue(i);
	}

	@GetMapping(value = "sendRabbitExchangeString")
	public void sendRabbitExchangeString(){
		rabbitSendTest.sendExchange();
	}


	@Autowired(required = false)
	private MyStreamClient streamClient;

	@GetMapping(value = "streamSend")
	public void streamSend(){
		String message = "当前时间="+new Date();
		Message<String> build = MessageBuilder.withPayload(message).build();
//		streamClient.output().send(build);
	}

}
