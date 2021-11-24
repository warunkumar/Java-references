package com.wscode.test.unit;

import aggregator.service.UserMovieService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * @author Warun
 * @createdOn 14-10-2021
 **/

@Profile("test")
@Configuration
public class UserMovieServiceTestConfig {

    @Bean
    @Primary
    public UserMovieService productService() {
        return Mockito.mock(UserMovieService.class);
    }
}
