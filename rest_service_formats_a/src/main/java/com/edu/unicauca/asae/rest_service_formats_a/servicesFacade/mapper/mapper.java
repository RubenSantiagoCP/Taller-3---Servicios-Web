package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mapper {
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
