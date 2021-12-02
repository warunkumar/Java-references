package com.ibm.aiops.connectors.nagios.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Scheduler config which is enabled based on a property which is useful during Testing
 *
 * @author Naveen Devarajaiah
 * @createdOn 11/2/21
 **/
@Configuration
@EnableScheduling
@ConditionalOnProperty(value = "scheduling.enabled", havingValue = "true", matchIfMissing = false)
public class NagiosSchedulerConfig {
}