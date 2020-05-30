package com.example.maaz.spring.cloud.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.maaz.spring.cloud.entity.Reservation;
import com.example.maaz.spring.cloud.repo.ReservationRepository;

@RefreshScope
@RestController
@EnableIntegration
public class ReservationController {


	@Value("${message}")
	private String message;
	
	@GetMapping("/message")
	public String message()
	{
		return this.message;
	}
	
}
