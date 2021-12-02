package com.ibm.aiops.connectors.nagios.dto;

import lombok.*;
import org.springframework.context.annotation.Configuration;

/**
 * @author Naveen Devarajaiah
 * @createdOn 10-11-2021
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Configuration
public class ConnectorConfigDto {

    private String connectionId;
    private String componentName;
    private long interval; // in secs. Ex: 60 - 60 secs == 1 min
    private String dataSourceBaseUrl;
    private Authentication authentication;
    private long historyDataInterval;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class Authentication {

        private String authType;
        private String username;
        private String password;
        private String apiKey;
        private String token;

    }


}
