package com.example.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * @author ZQC
 * 2018-03-22
 *
 */
@Component
public class zqcConsumer {
	@JmsListener(destination = "mongoSend.queue")
	@SendTo("zqcReply.queue")
	public String receiveQueue(String text) {
		System.out.println("ZQC收到的报文为:"+text);
		return "zqc已收到！";
	}
}
