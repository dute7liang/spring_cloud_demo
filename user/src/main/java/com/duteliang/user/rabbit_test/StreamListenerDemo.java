package com.duteliang.user.rabbit_test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * @author: zl
 * @Date: 2018-12-26 15:33
 */
@EnableBinding(MyStreamClient.class)
@Slf4j
public class StreamListenerDemo {

	@StreamListener(MyStreamClient.INPUT)
	@SendTo("myQueue")
	public String receive(String message){
		log.info("收到的消息={}", message);
		return "我收到了！";
	}


}
