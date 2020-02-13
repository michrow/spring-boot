package com.example.initializr;

import io.spring.initializr.web.support.InitializrMetadataUpdateStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	@Bean
	public InitializrMetadataUpdateStrategy initializrMetadataUpdateStrategy() {
		return (metadata) -> metadata;
	}
}
