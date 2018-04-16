package com.example.activemq.producer;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * 生产者1
 * @author ZQC
 * 2018-03-22
 *
 */
@Service
public class Producer1 {
	
	@Autowired
	private JmsMessagingTemplate jmsTemplate;
	
	// 发送消息，destination是发送到的队列，message是待发送的消息  
    public void sendMessage(Destination destination, final String message){  
        jmsTemplate.convertAndSend(destination, message);  
    }
    
    // 消息回执，message是消息回执  
    @JmsListener(destination="tang.queue")
    public void SendCallback(String message){  
        System.out.println("孙悟空收到的回复报文为:"+message);  
    }
    
}
