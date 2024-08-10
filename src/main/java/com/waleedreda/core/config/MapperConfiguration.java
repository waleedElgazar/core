package com.waleedreda.core.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

    @Bean(name = "modeMapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
