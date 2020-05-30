package com.example.maaz.spring.cloud.integration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;

import com.example.maaz.spring.cloud.entity.Reservation;
import com.example.maaz.spring.cloud.repo.ReservationRepository;

@MessageEndpoint
public class ReservationService {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@ServiceActivator(inputChannel = "input")
	public void recieveMessage(Message<String> message) throws MessagingException {
		System.out.println("###student.channel###");
		System.out.println(message);
		System.out.println(message.getPayload());
		reservationRepository.save(new Reservation(message.getPayload()));
	}

}
