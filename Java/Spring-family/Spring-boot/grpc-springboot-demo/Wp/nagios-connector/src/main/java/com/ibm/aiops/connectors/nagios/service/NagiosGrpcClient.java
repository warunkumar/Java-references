package com.ibm.aiops.connectors.nagios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.aiops.connectors.nagios.constants.NagiosServiceConstants;
import com.ibm.aiops.connectors.nagios.dto.ConnectorConfigDto;
import com.ibm.aiops.connectors.nagios.dto.HostStatusDto;
import com.ibm.aiops.connectors.nagios.dto.ServiceStatusDto;
import com.ibm.aiops.connectors.nagios.observers.CloudEventStreamObserver;
import com.ibm.aiops.connectors.nagios.util.NagiosServiceStatusUtil;
import io.cloudevents.v1.proto.CloudEvent;
import io.grpc.stub.StreamObserver;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

/**
 * Grpc Client class for Nagios which send metric information to gRPC Server
 *
 * @author Naveen Devarajaiah
 * @createdOn 11-08-2021
 */
@Service
@Slf4j
public class NagiosGrpcClient {

  @GrpcClient(value = "grpc-service")
  private com.ibm.aiops.connector.ConnectorBridgeGrpc.ConnectorBridgeStub connectorBridgeStub;

  @Autowired private ObjectMapper objectMapper;

  @Autowired private ApplicationContext applicationContext;

  @Autowired private NagiosHostStatusTransformer nagiosHostStatusTransformer;

  @Autowired private NagiosServiceStatusTransformer nagiosServiceStatusTransformer;

  /**
   * Method to retrieve Data Source Config from gRPC Server. gRPC Server is gonna Stream the config
   * on the Channel opened dynamically like sending different Interval and this App should update
   * ConnectorConfigDto accordingly refreshing the same in Application Context.
   *
   * @param requestEvent - Cloud event which contains Connection ID and Component Name
   */
  public void retrieveDataSourceConfigFromServer(CloudEvent requestEvent) {
    this.connectorBridgeStub.configuration(
        requestEvent,
        new StreamObserver<CloudEvent>() {

          @SneakyThrows
          @Override
          public void onNext(CloudEvent event) {
            log.info("Received Config from Server at: {}", ZonedDateTime.now());
            CloudEvent.CloudEventAttributeValue connectorConfigString =
                event.getAttributesOrThrow(NagiosServiceConstants.CONFIG);
            log.info("Received Config is: {}", connectorConfigString.getCeString());
            ConnectorConfigDto connectorConfigInterDto =
                new ObjectMapper()
                    .readValue(connectorConfigString.getCeString(), ConnectorConfigDto.class);

            // Reloading Application Context to reflect changes done everywhere in the App
            ConfigurableApplicationContext configContext =
                (ConfigurableApplicationContext) applicationContext;
            ConfigurableListableBeanFactory beanRegistry = configContext.getBeanFactory();
            ConnectorConfigDto autowiredConfigDto = beanRegistry.getBean(ConnectorConfigDto.class);
            autowiredConfigDto.setDataSourceBaseUrl(connectorConfigInterDto.getDataSourceBaseUrl());
            autowiredConfigDto.setInterval(connectorConfigInterDto.getInterval());
            autowiredConfigDto.setConnectionId(connectorConfigInterDto.getConnectionId());
            autowiredConfigDto.setComponentName(connectorConfigInterDto.getComponentName());
            autowiredConfigDto.setAuthentication(connectorConfigInterDto.getAuthentication());
            // Above will override ConnectorConfigDto in Application Context
          }

          @Override
          public void onError(Throwable t) {}

          @Override
          public void onCompleted() {
            log.info("Server Completed Streaming Config information");
          }
        });
  }

  /**
   * Method to transform Host Status to Cloud Event and stream to gRPC Server
   *
   * @param hostStatusDto - Host Status Dto
   */
  public void transformHostInfoToCloudEvent(HostStatusDto hostStatusDto) {
    log.debug("Sending Stream of Cloud Events from transformHostInfoToCloudEvent()");
    StreamObserver<CloudEvent> streamObserver =
        connectorBridgeStub.produce(new CloudEventStreamObserver());
    hostStatusDto.getHoststatus().stream()
        .filter(
            hostStatus ->
                !hostStatus.getAddress().equalsIgnoreCase(NagiosServiceConstants.LOCALHOST_ADDRESS))
        .forEach(
            hostStatus -> {
              streamObserver.onNext(
                  nagiosHostStatusTransformer.convertHostStatusInfoToCloudEvent(hostStatus));
            });
    streamObserver.onCompleted();
    log.debug("transformHostInfoToCloudEvent() executed successfully");
  }

  /**
   * Method to transform the Service Status Data into Cloud Events
   *
   * @param serviceStatusDto - Input Service Status Data
   */
  public void transformServiceDataToCloudEvent(ServiceStatusDto serviceStatusDto) {

    log.debug("Sending Stream of Cloud Events from transformServiceDataToCloudEvent()");
    StreamObserver<CloudEvent> streamObserver =
        connectorBridgeStub.produce(new CloudEventStreamObserver());

    Map<String, List<ServiceStatusDto.Servicestatus>> serviceStatusMap =
        NagiosServiceStatusUtil.processFilterServiceStatusMetrics(serviceStatusDto);

    serviceStatusMap
        .entrySet()
        .forEach(
            service ->
                nagiosServiceStatusTransformer.convertServiceStatusInfoToCloudEvent(
                    service.getKey(), service.getValue(), streamObserver));

    streamObserver.onCompleted();
    log.debug("transformServiceDataToCloudEvent() executed successfully");
  }
}
