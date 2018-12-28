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
		String message = "我发送的消息"+new Date();
		RabbitModel rabbitModel = new RabbitModel();
		rabbitModel.setAge(25);
		rabbitModel.setDate(new Date());
		rabbitModel.setName("zl");
		rabbitModel.setDou(200000.00);

		// 发送消息到队列 myQueue，exchange 为默认的 exchange
//		amqpTemplate.convertAndSend("myQueue", "我发送的消息"+new Date());
//		amqpTemplate.convertAndSend("myQueue", rabbitModel);

		/**
		 * 发送消息到exchange  docker, routingKey为指定的数据
		 *  比如 rabbit.*  rabbit.#
 		 */
		amqpTemplate.convertAndSend("myExchange", "rabbit.name", message);



	}


	public void sendExchange(){
		amqpTemplate.convertAndSend("myExchange", "myKey", "我发送的消息"+new Date());
	}






}
