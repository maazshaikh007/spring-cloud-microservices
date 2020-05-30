package com.example.maaz.spring.cloud.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface ReservationChannel {
	
	 @Input
	 MessageChannel input();

}
