package com.ibm.aiops.connectors.nagios.scheduler;

import com.ibm.aiops.connectors.nagios.constants.NagiosServiceConstants;
import com.ibm.aiops.connectors.nagios.dto.ConnectorConfigDto;
import com.ibm.aiops.connectors.nagios.service.NagiosGrpcClient;
import com.ibm.aiops.connectors.nagios.service.NagiosWebClientService;
import io.cloudevents.v1.proto.CloudEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Dynamic Scheduler class which retrieves Metrics from Data Source at interval specified by gRPC
 * Server (interval can change dynamically)
 *
 * @author Naveen Devarajaiah
 * @createdOn 10-11-2021
 */
@Component
@Slf4j
public class NagiosScheduler implements SchedulingConfigurer {

  @Autowired private NagiosGrpcClient nagiosGrpcClient;

  @Autowired private ConnectorConfigDto connectorConfigDto;

  @Autowired private NagiosWebClientService nagiosWebClientService;

  /**
   * Method invoked after this Bean is fully initialized which retrieves Data Source Config from
   * gRPC Server
   */
  @PostConstruct
  public void initializeConfigFromGrpcServer() {
    CloudEvent requestEvent =
        CloudEvent.newBuilder()
            .putAttributes(
                NagiosServiceConstants.CONNECTION_ID,
                CloudEvent.CloudEventAttributeValue.newBuilder()
                    .setCeString(UUID.randomUUID().toString())
                    .build())
            .putAttributes(
                NagiosServiceConstants.COMPONENT_NAME,
                CloudEvent.CloudEventAttributeValue.newBuilder()
                    .setCeString(NagiosServiceConstants.SOURCE_NAME)
                    .build())
            .build();
    nagiosGrpcClient.retrieveDataSourceConfigFromServer(requestEvent);
  }

  /**
   * Scheduler Method which executes at specified interval. Interval change is considered from next
   * execution onwards
   *
   * @param taskRegistrar - Scheduled Task Registrar
   */
  @Override
  public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

    taskRegistrar.addTriggerTask(
        new Runnable() {
          @Override
          public void run() {
            if (Objects.nonNull(connectorConfigDto.getDataSourceBaseUrl())) {
              nagiosWebClientService.retrieveHostStatusInfo();
              nagiosWebClientService.retrieveServiceStatusInfo();
            }
          }
        },
        new Trigger() {

          @Override
          public Date nextExecutionTime(TriggerContext triggerContext) {
            Calendar nextExecutionTime = new GregorianCalendar();
            Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();
            nextExecutionTime.setTime(
                lastActualExecutionTime != null ? lastActualExecutionTime : new Date());
            if (Objects.nonNull(connectorConfigDto.getInterval())
                && connectorConfigDto.getInterval() > 0) {
              nextExecutionTime.add(Calendar.MILLISECOND, (int) connectorConfigDto.getInterval());
            } else {
              nextExecutionTime.add(
                  Calendar.MILLISECOND, 10000); // Setting to default 10 secs initially
            }
            log.info("Next Execution Time: {}", nextExecutionTime.getTime());
            return nextExecutionTime.getTime();
          }
        });
  }
}
