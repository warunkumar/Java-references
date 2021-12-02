package com.ibm.aiops.connectors.nagios.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Java Objects for Application.Properties file
 *
 * @author Naveen Devarajaiah
 * @createdOn 11/2/21
 **/
@Configuration
@ConfigurationProperties(prefix = "datasource")
@Getter
@Setter
public class ApplicationProps {

private  List<String> resources;
}