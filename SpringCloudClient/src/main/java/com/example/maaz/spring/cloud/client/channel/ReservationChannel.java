package com.example.maaz.spring.cloud.client.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ReservationChannel {
	
	 @Output
	 MessageChannel output();

}
