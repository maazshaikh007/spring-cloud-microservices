package com.example.maaz.spring.cloud.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.maaz.spring.cloud.client.entity.Reservation;
import com.example.maaz.spring.cloud.client.gateway.IntegrationGateway;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ReservationClientController {
	
    @Autowired
	private IntegrationGateway integrationGateway;

    public void fallback(Reservation r) {
    	System.out.println("Inside fallback method");
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @PostMapping("/publish1")
    public void write(@RequestBody Reservation reservation) throws Exception {
		integrationGateway.process(reservation);
		System.out.println("Sending Reservation to Reservation Service"+reservation.toString());
		 
    }

}
