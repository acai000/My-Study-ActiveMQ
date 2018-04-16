package com.example.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * 消费者B
 * @author ZQC
 * 2018-03-22
 *
 */
@Component
public class ConsumerB {
	
	// 使用JmsListener配置消费者监听的队列，其中text是接收到的消息 
	@JmsListener(destination = "zhu.queue")
	@SendTo("sha.queue")
	public String receiveQueue(String text) {
		System.out.println("沙和尚收到的报文为:"+text);
		return "沙和尚，准时到达";
	}
}
