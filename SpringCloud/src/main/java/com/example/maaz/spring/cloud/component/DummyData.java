package com.example.maaz.spring.cloud.component;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.maaz.spring.cloud.entity.Reservation;
import com.example.maaz.spring.cloud.repo.ReservationRepository;

@Component
public class DummyData implements CommandLineRunner {
	
	@Autowired
	private final ReservationRepository reservationRepository;
	
	@Autowired
	public DummyData ( ReservationRepository reservationRepository )
	{
		this.reservationRepository=reservationRepository;
	}

	@Override
	public void run(String... args) throws Exception 
	{
		 Stream.of("CaptainAmeruca", "SpiderMan", "IronMan", "Hulk")
         .forEach(n -> reservationRepository.save(new Reservation(n)));
         reservationRepository.findAll().forEach(System.out::println);	
	}

}
