package com.waleedreda.core.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableJpaAuditing
public class AppConfiguration {

    public AppConfiguration() {
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}