package com.wipro.nagios.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Nagios XI Data Source
 *
 * @author NA20219458
 * @createdOn 14-10-2021
 **/
@Configuration
public class NagiosConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
