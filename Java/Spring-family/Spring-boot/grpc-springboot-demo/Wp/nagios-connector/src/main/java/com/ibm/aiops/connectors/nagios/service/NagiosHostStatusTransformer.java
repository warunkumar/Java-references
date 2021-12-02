package com.ibm.aiops.connectors.nagios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.aiops.connectors.nagios.config.ApplicationProps;
import com.ibm.aiops.connectors.nagios.constants.NagiosServiceConstants;
import com.ibm.aiops.connectors.nagios.dto.ConnectorConfigDto;
import com.ibm.aiops.connectors.nagios.dto.HostStatusDto;
import com.ibm.aiops.connectors.nagios.dto.HostStatusEventDto;
import io.cloudevents.v1.proto.CloudEvent;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.UUID;

/**
 * Class to transform Nagios Host Status info to Cloud Event
 *
 * @author Naveen Devarajaah
 * @createdOn 10-11-2021
 */
@Component
public class NagiosHostStatusTransformer {

  // To log Cloud Event
  Logger cloudEventLogger = LoggerFactory.getLogger("cloudevent-logger");

  // To log Host Status Info
  Logger hostStatusLogger = LoggerFactory.getLogger("hoststatus-logger");

  @Autowired private ObjectMapper objectMapper;

  @Autowired private ApplicationProps applicationProps;

  @Autowired private ConnectorConfigDto connectorConfigDto;

  /**
   * Method to convert Host Status Info to Cloud Event
   *
   * @param hostStatus - Host Status Info
   * @return CloudEvent - returns Transformed Cloud Event
   */
  @SneakyThrows
  protected CloudEvent convertHostStatusInfoToCloudEvent(HostStatusDto.Hoststatus hostStatus) {

    hostStatusLogger.debug("Host Status Info: {}", objectMapper.writeValueAsString(hostStatus));
    CloudEvent cloudEvent =
        CloudEvent.newBuilder()
            .setSource(
                connectorConfigDto.getDataSourceBaseUrl() + applicationProps.getResources().get(0))
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
                    .setCeString(prepareEventDto(hostStatus))
                    .build())
            .build();

    cloudEventLogger.debug(
        "UUID: {}, Cloud Event: {}",
        cloudEvent.getId(),
        cloudEvent.getAttributesOrThrow(NagiosServiceConstants.DATA).getCeString());
    return cloudEvent;
  }

  /**
   * @param hostStatus - Host Status Data
   * @return A String of Event Dto
   */
  @SneakyThrows
  private String prepareEventDto(HostStatusDto.Hoststatus hostStatus) {

    HostStatusEventDto eventDto = new HostStatusEventDto();

    HostStatusEventDto.Group group = new HostStatusEventDto.Group();

    // Convert Time to UTC Time Zone and to Milli seconds
    long statusUpdateTimeStamp =
        LocalDateTime.parse(
                hostStatus
                    .getStatusUpdateTime()
                    .replace(NagiosServiceConstants.SPACE, NagiosServiceConstants.TIME_CHAR))
            .atZone(ZoneId.of(NagiosServiceConstants.UTC))
            .toInstant()
            .toEpochMilli();
    group.setTimestamp(String.valueOf(statusUpdateTimeStamp));

    group.setResourceID(hostStatus.getHostName());

    HostStatusEventDto.Metrics metrics = new HostStatusEventDto.Metrics();
    String rta =
        StringUtils.substringBetween(
            hostStatus.getPerfdata(),
            NagiosServiceConstants.RTA + NagiosServiceConstants.EQUALS,
            NagiosServiceConstants.MS);
    metrics.setRta(rta + NagiosServiceConstants.MS);
    String pl =
        StringUtils.substringBetween(
            hostStatus.getPerfdata(),
            NagiosServiceConstants.PL + NagiosServiceConstants.EQUALS,
            NagiosServiceConstants.PERCENTAGE);
    metrics.setPl(pl + NagiosServiceConstants.PERCENTAGE);
    group.setMetrics(metrics);

    HostStatusEventDto.Attributes attributes = new HostStatusEventDto.Attributes();
    attributes.setGroup(NagiosServiceConstants.HOST_STATUS_INFO);
    attributes.setNode(hostStatus.getHostObjectId());
    group.setAttributes(attributes);

    eventDto.setGroups(Arrays.asList(group));

    return objectMapper.writeValueAsString(eventDto);
  }
}
