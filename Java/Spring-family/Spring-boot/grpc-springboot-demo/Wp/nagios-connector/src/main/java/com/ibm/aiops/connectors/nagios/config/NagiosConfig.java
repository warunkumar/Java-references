package com.ibm.aiops.connectors.nagios.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Configuration class to define Beans which will be used across application
 *
 * @author Naveen Devarajaiah
 * @createdOn 11/2/21
 */
@Configuration
public class NagiosConfig {

  @Value("${webclient.response-size}")
  private Integer size;

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  @Bean
  public WebClient webClient() {
    return WebClient.builder()
        .exchangeStrategies(
            ExchangeStrategies.builder()
                .codecs(
                    configurer -> configurer.defaultCodecs().maxInMemorySize(size * 1024 * 1024))
                .build())
        .build();
  }
}
