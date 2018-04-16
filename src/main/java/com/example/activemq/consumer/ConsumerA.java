package com.example.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * 消费者A
 * @author ZQC
 * 2018-03-22
 *
 */
@Component
public class ConsumerA {
	
	// 使用JmsListener配置消费者监听的队列，其中text是接收到的消息 
	@JmsListener(destination = "sun.queue")
	@SendTo("tang.queue")
	public String receiveQueue(String text) {
		System.out.println("唐僧收到的报文为:"+text);
		return "唐僧，同意参加";
	} 
}
