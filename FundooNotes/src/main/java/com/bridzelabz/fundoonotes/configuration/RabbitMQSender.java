//package com.bridzelabz.fundoonotes.configuration;
//
//import com.bridzelabz.fundoonotes.reponse.EmailData;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RabbitMQSender {
//	@Autowired
//	private RabbitTemplate rabbitTemplate;
//
//	@Value("rmq.rube.exchange")
//	private String exchange;
//
//	@Value("rube.key")
//	private String routingkey;
//
//	public void send(EmailData message) {
//		rabbitTemplate.convertAndSend(exchange, routingkey, message);
//
//	}
//
//}
