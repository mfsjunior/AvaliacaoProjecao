package com.exercicio.atividade;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ch.qos.logback.core.model.Model;

@SpringBootApplication
public class AtitivadeApplication {

	@Bean
	public ModelMapper modelMapper() {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setSkipNullEnabled(true);
		return modelMapper;
		
		
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AtitivadeApplication.class, args);
	}

}
