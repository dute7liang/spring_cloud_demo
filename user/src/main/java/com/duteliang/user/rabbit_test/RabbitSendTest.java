package com.duteliang.user.rabbit_test;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: zl
 * @Date: 2018-12-26 14:48
 */
@Component
public class RabbitSendTest {

	@Autowired
	private AmqpTemplate amqpTemplate;


	public void sendQueue(){
		amqpTemplate.convertAndSend("myQueue", "我发送的消息"+new Date());
	}


	public void sendExchange(){
		amqpTemplate.convertAndSend("myExchange", "myKey", "我发送的消息"+new Date());
	}






}
