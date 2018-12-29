package com.duteliang.user.rabbit_test;

import com.esotericsoftware.minlog.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: zl
 * @Date: 2018-12-26 14:48
 */
@Component
@Slf4j
public class RabbitSendTest {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	final RabbitTemplate.ConfirmCallback confirmCallback = (correlationData, ack, cause) -> {
		if (ack) {
			log.info("对方已消费成功！");
		} else {
			log.info("对方消费失败！");
		}
	};

	public void sendQueue(Integer i){
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
//		amqpTemplate.convertAndSend("myExchange", "rabbit.name", message);


//		amqpTemplate.convertAndSend("myExchange", "rabbit.name", message);
		if(i == null){
			rabbitTemplate.setConfirmCallback(confirmCallback);
		}


		rabbitTemplate.convertAndSend("myExchange", "rabbit.name", message);




	}


	public void sendExchange(){
		amqpTemplate.convertAndSend("myExchange", "myKey", "我发送的消息"+new Date());
	}






}
