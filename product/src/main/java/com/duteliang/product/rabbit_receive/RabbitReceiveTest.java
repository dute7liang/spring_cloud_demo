package com.duteliang.product.rabbit_receive;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.impl.AMQImpl;
import com.rabbitmq.http.client.domain.ExchangeType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

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
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue("myQueue"),
			exchange = @Exchange(value = "myExchange",type = ExchangeTypes.TOPIC),
			key = "rabbit.name",
			arguments = {
				@Argument(name = "key",value = "value"),
				@Argument(name = "key1",value = "value1")
			}
	))
	public void receiveString(@Payload String string, Channel cannel,
			  @Headers Map<String,Object> map) throws IOException {
		Long deliveryTag = (Long)map.get(AmqpHeaders.DELIVERY_TAG);
		cannel.basicAck(deliveryTag, false);
		log.info("收到的消息：{}", string);
	}


	@RabbitListener(bindings = @QueueBinding(
			value = @Queue("myQueue"),
			exchange = @Exchange(value = "myExchange",type = ExchangeTypes.TOPIC),
			key = "rabbit.name",
			arguments = {
				@Argument(name = "key",value = "value"),
				@Argument(name = "key3",value = "value3")
			}
	))
	public void receiveString2(@Payload String string, Channel cannel,
			   @Headers Map<String,Object> map) throws IOException {
		Long deliveryTag = (Long)map.get(AmqpHeaders.DELIVERY_TAG);
		cannel.basicAck(deliveryTag, false);
		log.info("收到的消息：{}", string);
	}

}
