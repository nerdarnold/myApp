package com.ata.courierApp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourierAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourierAppApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapperBean()
	{
		return new ModelMapper();
	}

}
