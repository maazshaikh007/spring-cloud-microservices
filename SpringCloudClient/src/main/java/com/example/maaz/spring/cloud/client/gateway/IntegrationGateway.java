package com.example.maaz.spring.cloud.client.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface IntegrationGateway {

	@Gateway(requestChannel = "router.channel")
	public <T> void process(T object);
}