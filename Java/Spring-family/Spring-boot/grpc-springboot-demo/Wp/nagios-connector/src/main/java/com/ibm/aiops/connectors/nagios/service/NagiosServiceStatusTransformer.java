package com.ibm.aiops.connectors.nagios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.aiops.connectors.nagios.config.ApplicationProps;
import com.ibm.aiops.connectors.nagios.constants.NagiosServiceConstants;
import com.ibm.aiops.connectors.nagios.dto.*;
import io.cloudevents.v1.proto.CloudEvent;
import io.grpc.stub.StreamObserver;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Class to Transform the Nagios Service Data to Cloud Events
 *
 * @author warun
 * @createdOn 11/11/2021
 */
@Component
public class NagiosServiceStatusTransformer {

  // To log Cloud Event
  Logger cloudEventLogger = LoggerFactory.getLogger("cloudevent-logger");

  // To log Service Status Info
  Logger serviceStatusLogger = LoggerFactory.getLogger("servicestatus-logger");

  @Autowired private ObjectMapper objectMapper;

  @Autowired private ApplicationProps applicationProps;

  @Autowired private ConnectorConfigDto connectorConfigDto;

  /**
   * Method to create Cloud Events from nagios service status
   *
   * @param metricName - Describes the name of the metric
   * @param serviceStatusList - Details of the Metrics
   * @param streamObserver - Stream Observer to send and receive data
   */
  @SneakyThrows
  public void convertServiceStatusInfoToCloudEvent(
      String metricName,
      List<ServiceStatusDto.Servicestatus> serviceStatusList,
      StreamObserver<CloudEvent> streamObserver) {

    for (ServiceStatusDto.Servicestatus serviceStatus : serviceStatusList) {
      serviceStatusLogger.debug(
          "Service Status Info: {}", objectMapper.writeValueAsString(serviceStatus));
      CloudEvent cloudEvent =
          CloudEvent.newBuilder()
              .setSource(
                  connectorConfigDto.getDataSourceBaseUrl()
                      + applicationProps.getResources().get(1))
              .setId(UUID.randomUUID().toString())
              .setSpecVersion(NagiosServiceConstants.SPECVERSION)
              .putAttributes(
                  NagiosServiceConstants.PACKAGE,
                  CloudEvent.CloudEventAttributeValue.newBuilder()
                      .setCeString(NagiosServiceConstants.NAGIOS)
                      .build())
              .putAttributes(
                  NagiosServiceConstants.DATA_CONTENT_TYPE,
                  CloudEvent.CloudEventAttributeValue.newBuilder()
                      .setCeString(NagiosServiceConstants.APPLICATION_JSON)
                      .build())
              .putAttributes(
                  NagiosServiceConstants.DATA,
                  CloudEvent.CloudEventAttributeValue.newBuilder()
                      .setCeString(prepareServiceEventDto(serviceStatus, metricName))
                      .build())
              .build();

      cloudEventLogger.debug(
          "UUID: {}, Cloud Event: {}",
          cloudEvent.getId(),
          cloudEvent.getAttributesOrThrow(NagiosServiceConstants.DATA).getCeString());

      streamObserver.onNext(cloudEvent);
    }
  }

  /** Method to prepare the Service Status Data */
  @SneakyThrows
  private String prepareServiceEventDto(
      ServiceStatusDto.Servicestatus serviceStatus, String metricName) {

    MemoryUsageEventDto memoryUsageEventDto = new MemoryUsageEventDto();
    MemoryUsageEventDto.Group memoryGroup = new MemoryUsageEventDto.Group();
    MemoryUsageEventDto.Metrics memoryMetrics = new MemoryUsageEventDto.Metrics();

    CpuUsageEventDto cpuUsageEventDto = new CpuUsageEventDto();
    CpuUsageEventDto.Group cpuGroup = new CpuUsageEventDto.Group();
    CpuUsageEventDto.Metrics cpuMetrics = new CpuUsageEventDto.Metrics();

    DiskUsageEventDto diskUsageEventDto = new DiskUsageEventDto();
    DiskUsageEventDto.Group diskGroup = new DiskUsageEventDto.Group();
    DiskUsageEventDto.Metrics diskMetrics = new DiskUsageEventDto.Metrics();

    SwapUsageEventDto swapUsageEventDto = new SwapUsageEventDto();
    SwapUsageEventDto.Group swapGroup = new SwapUsageEventDto.Group();
    SwapUsageEventDto.Metrics swapMetrics = new SwapUsageEventDto.Metrics();

    long statusUpdateTimeStamp =
        LocalDateTime.parse(
                serviceStatus
                    .getStatusUpdateTime()
                    .replace(NagiosServiceConstants.SPACE, NagiosServiceConstants.TIME_CHAR))
            .atZone(ZoneId.of(NagiosServiceConstants.UTC))
            .toInstant()
            .toEpochMilli();

    if (metricName.equals(NagiosServiceConstants.MEMORY_USAGE)) {

      String available =
          StringUtils.substringBetween(
              serviceStatus.getPerfdata(),
              NagiosServiceConstants.AVAILABLE + NagiosServiceConstants.EQUALS,
              NagiosServiceConstants.SEMICOLON);

      String used =
          StringUtils.substringBetween(
              serviceStatus.getPerfdata(),
              NagiosServiceConstants.USED + NagiosServiceConstants.EQUALS,
              NagiosServiceConstants.SEMICOLON);

      String free =
          StringUtils.substringBetween(
              serviceStatus.getPerfdata(),
              NagiosServiceConstants.FREE + NagiosServiceConstants.EQUALS,
              NagiosServiceConstants.SEMICOLON);

      String total =
          StringUtils.substringBetween(
              serviceStatus.getPerfdata(),
              NagiosServiceConstants.TOTAL + NagiosServiceConstants.EQUALS,
              NagiosServiceConstants.SEMICOLON);

      memoryMetrics.setAvailable(available);
      memoryMetrics.setUsed(used);
      memoryMetrics.setFree(free);
      memoryMetrics.setTotal(total);
      memoryGroup.setMetrics(memoryMetrics);

      memoryGroup.setTimestamp(String.valueOf(statusUpdateTimeStamp));
      memoryGroup.setResourceID(serviceStatus.getHostName());

      MemoryUsageEventDto.Attributes attributes = new MemoryUsageEventDto.Attributes();
      attributes.setGroup(NagiosServiceConstants.MEMORY_USAGE);
      attributes.setNode(serviceStatus.getHostObjectId());
      memoryGroup.setAttributes(attributes);

      memoryUsageEventDto.setGroups(Arrays.asList(memoryGroup));

      return objectMapper.writeValueAsString(memoryUsageEventDto);
    } else if (metricName.equals(NagiosServiceConstants.DISK_USAGE)) {

      String used =
          StringUtils.substringBetween(
              serviceStatus.getPerfdata(),
              NagiosServiceConstants.USED + NagiosServiceConstants.EQUALS,
              NagiosServiceConstants.SEMICOLON);

      String free =
          StringUtils.substringBetween(
              serviceStatus.getPerfdata(),
              NagiosServiceConstants.FREE + NagiosServiceConstants.EQUALS,
              NagiosServiceConstants.SEMICOLON);

      String total =
          StringUtils.substringBetween(
              serviceStatus.getPerfdata(),
              NagiosServiceConstants.TOTAL + NagiosServiceConstants.EQUALS,
              NagiosServiceConstants.SEMICOLON);

      diskMetrics.setUsed(used);
      diskMetrics.setFree(free);
      diskMetrics.setTotal(total);
      diskGroup.setMetrics(diskMetrics);

      diskGroup.setTimestamp(String.valueOf(statusUpdateTimeStamp));
      diskGroup.setResourceID(serviceStatus.getHostName());

      DiskUsageEventDto.Attributes attributes = new DiskUsageEventDto.Attributes();
      attributes.setGroup(NagiosServiceConstants.DISK_USAGE);
      attributes.setNode(serviceStatus.getHostObjectId());
      diskGroup.setAttributes(attributes);

      diskUsageEventDto.setGroups(Arrays.asList(diskGroup));

      return objectMapper.writeValueAsString(diskUsageEventDto);

    } else if (metricName.equals(NagiosServiceConstants.CPU_USAGE)) {

      String percent =
          StringUtils.substringBetween(
              serviceStatus.getPerfdata(),
              NagiosServiceConstants.PERCENT + NagiosServiceConstants.EQUALS,
              NagiosServiceConstants.SEMICOLON);

      cpuMetrics.setPercent(percent);
      cpuGroup.setMetrics(cpuMetrics);

      cpuGroup.setTimestamp(String.valueOf(statusUpdateTimeStamp));
      cpuGroup.setResourceID(serviceStatus.getHostName());

      CpuUsageEventDto.Attributes attributes = new CpuUsageEventDto.Attributes();
      attributes.setGroup(NagiosServiceConstants.CPU_USAGE);
      attributes.setNode(serviceStatus.getHostObjectId());
      cpuGroup.setAttributes(attributes);

      cpuUsageEventDto.setGroups(Arrays.asList(cpuGroup));

      return objectMapper.writeValueAsString(cpuUsageEventDto);

    } else if (metricName.equals(NagiosServiceConstants.SWAP_USAGE)) {

      String used =
          StringUtils.substringBetween(
              serviceStatus.getPerfdata(),
              NagiosServiceConstants.USED + NagiosServiceConstants.EQUALS,
              NagiosServiceConstants.SEMICOLON);

      String free =
          StringUtils.substringBetween(
              serviceStatus.getPerfdata(),
              NagiosServiceConstants.FREE + NagiosServiceConstants.EQUALS,
              NagiosServiceConstants.SEMICOLON);

      String total =
          StringUtils.substringBetween(
              serviceStatus.getPerfdata(),
              NagiosServiceConstants.TOTAL + NagiosServiceConstants.EQUALS,
              NagiosServiceConstants.SEMICOLON);

      swapMetrics.setUsed(used);
      swapMetrics.setFree(free);
      swapMetrics.setTotal(total);
      swapGroup.setMetrics(swapMetrics);
      swapGroup.setTimestamp(String.valueOf(statusUpdateTimeStamp));
      swapGroup.setResourceID(serviceStatus.getHostName());

      SwapUsageEventDto.Attributes attributes = new SwapUsageEventDto.Attributes();
      attributes.setGroup(NagiosServiceConstants.SWAP_USAGE);
      attributes.setNode(serviceStatus.getHostObjectId());
      swapGroup.setAttributes(attributes);

      swapUsageEventDto.setGroups(Arrays.asList(swapGroup));

      return objectMapper.writeValueAsString(swapUsageEventDto);

    } else {
      return null;
    }
  }
}
