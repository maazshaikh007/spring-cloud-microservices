package com.example.maaz.spring.cloud.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.router.PayloadTypeRouter;
import org.springframework.messaging.MessageChannel;

import com.example.maaz.spring.cloud.client.entity.Reservation;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration

public class ClientConfiguration {
	
	@Bean
	public MessageChannel recieverChannel() {
		return new DirectChannel();
	}
	
    @Bean
	public Docket api() { 
	    return new Docket(DocumentationType.SWAGGER_2)  
	      .select()                                  
	      .apis(RequestHandlerSelectors.any())              
	      .paths(PathSelectors.any())                          
	      .build();                                           
	    }
	
	 @ServiceActivator(inputChannel = "router.channel")
	 @Bean
	 public PayloadTypeRouter payloadRouter() {
		PayloadTypeRouter router = new PayloadTypeRouter();
		router.setChannelMapping(Reservation.class.getName(), "output");
		return router;
	}

}
