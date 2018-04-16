package com.example.activemq;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.activemq.producer.Producer1;
import com.example.activemq.producer.Producer2;
import com.example.activemq.producer.zqcProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestActiveMQ {
	
	@Autowired
	private Producer1 producer1;
	
	@Autowired
	private Producer2 producer2;		
	
	@Autowired
	private zqcProducer zqcproducer;

	@Test
	public void test() {
		Destination sunDes = new ActiveMQQueue("sun.queue");
		Destination zhuDes = new ActiveMQQueue("zhu.queue");				
		
		for(int i=0; i<2; i++) {
			producer1.sendMessage(sunDes, "孙悟空，发送消息,来花果山吃桃 ");
		}
		for(int i=0; i<2; i++) {
			producer2.sendMessage(zhuDes, "猪八戒，发送消息,来高老庄吃席");
		}
	}
	
	@Test
	public void testMongo() {
		Destination zqcDes = new ActiveMQQueue("zqcSend.queue");
		zqcproducer.sendMessage(zqcDes, "Hello,Mongo");
	}

}
