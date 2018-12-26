package com.duteliang.user.rabbit_test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: zl
 * @Date: 2018-12-26 14:51
 */
@Component
@Slf4j
public class RabbitReceiveTest {


//	@RabbitListener(queuesToDeclare = @Queue(value = "myQueue"))
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue("myQueue"),
			exchange = @Exchange("myExchange")
	))
	public void receiveString(String string){
		log.info("收到的消息：{}", string);
	}


	@RabbitListener(bindings = @QueueBinding(
			value = @Queue("myQueue"),
			key = "myKey",
			exchange = @Exchange("myExchange")
	))
	public void receiveExchange(String string){
		log.info("收到的消息：{}", string);
	}

}
