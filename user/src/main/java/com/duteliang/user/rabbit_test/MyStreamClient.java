package com.duteliang.user.rabbit_test;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * stream 操作 rabbit
 * @author: zl
 * @Date: 2018-12-26 15:30
 */
public interface MyStreamClient {

	String INPUT = "myStreamQueue";

	String OUTPUT = "myStreamQueue";

//	@Input(MyStreamClient.INPUT)
//	SubscribableChannel input();


//	@Output(MyStreamClient.OUTPUT)
//	MessageChannel output();


	String OUTPUT2 = "myQueue";

//	@Output(MyStreamClient.OUTPUT2)
//	MessageChannel output2();

}
