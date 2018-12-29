package com.duteliang.user.rabbit_test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
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


	/**
	 * 监听 队列名为：myQueue， exchange:default
	 */
//	@RabbitListener(queuesToDeclare = @Queue(value = "myQueue"))

	/**
	 * 监听 exchange为 myExchange（默认type=direct）， 队列为：myQueue，
	 * RoutingKey 可以使用占位符 比如 rabbit.*  rabbit.#  只有topic类型才支持占位符
	 *
	 */
//	@RabbitListener(bindings = @QueueBinding(
//			value = @Queue("myQueue"),
//			exchange = @Exchange(value = "myExchange",type = ExchangeTypes.TOPIC),
//			key = "rabbit.name"
//	))
//	public void receiveString(String string){
//		log.info("收到的消息：{}", string);
//	}


//	@RabbitListener(bindings = @QueueBinding(
//			value = @Queue("myQueue"),
//			key = "myKey",
//			exchange = @Exchange("myExchange")
//	))
//	public void receiveExchange(String string){
//		log.info("收到的消息：{}", string);
//	}

}
