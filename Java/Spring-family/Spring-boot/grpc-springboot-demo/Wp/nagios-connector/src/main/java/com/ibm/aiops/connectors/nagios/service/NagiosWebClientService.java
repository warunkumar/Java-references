package com.ibm.aiops.connectors.nagios.service;

import com.ibm.aiops.connectors.nagios.config.ApplicationProps;
import com.ibm.aiops.connectors.nagios.constants.NagiosServiceConstants;
import com.ibm.aiops.connectors.nagios.dto.ConnectorConfigDto;
import com.ibm.aiops.connectors.nagios.dto.HostStatusDto;
import com.ibm.aiops.connectors.nagios.dto.ServiceStatusDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * Nagios Web Client Service class for Nagios which send metric information to gRPC Server
 *
 * @author Naveen Devarajaiah
 * @createdOn 11-08-2021
 */
@Component
@Slf4j
public class NagiosWebClientService {

  @Autowired private WebClient webClient;

  @Autowired private NagiosGrpcClient nagiosGrpcClient;

  @Autowired private ApplicationProps applicationProps;

  @Autowired private ConnectorConfigDto connectorConfigDto;
  /** Method to retrieve service status info */
  @Value("${pagination.limit}")
  private Integer limit;

  /** Method to retrieve host status info */
  public void retrieveHostStatusInfo() {

    log.info(
        "Retrieving Host Status info from Nagios: {}",
        connectorConfigDto.getDataSourceBaseUrl() + applicationProps.getResources().get(0));
    HostStatusDto hostStatusDto =
        webClient
            .mutate()
            .baseUrl(connectorConfigDto.getDataSourceBaseUrl())
            .build()
            .get()
            .uri(
                uriBuilder ->
                    uriBuilder
                        .path(applicationProps.getResources().get(0))
                        .queryParam(
                            NagiosServiceConstants.API_KEY,
                            connectorConfigDto.getAuthentication().getApiKey())
                        .build())
            .retrieve()
            .bodyToMono(HostStatusDto.class)
            .block();
    nagiosGrpcClient.transformHostInfoToCloudEvent(hostStatusDto);
  }

  public void retrieveServiceStatusInfo() {

    log.info(
        "Retrieving Service Status info from Nagios: {}",
        connectorConfigDto.getDataSourceBaseUrl() + applicationProps.getResources().get(1));

    ServiceStatusDto serviceStatusDto = null;
    Integer recordsToStartFrom = 0;
    do {
      log.info("Records Started From : {}", recordsToStartFrom);
      String recordQueryParam = limit + NagiosServiceConstants.COLON + recordsToStartFrom;
      serviceStatusDto =
          webClient
              .mutate()
              .baseUrl(connectorConfigDto.getDataSourceBaseUrl())
              .build()
              .get()
              .uri(
                  uriBuilder ->
                      uriBuilder
                          .path(applicationProps.getResources().get(1))
                          .queryParam(
                              NagiosServiceConstants.API_KEY,
                              connectorConfigDto.getAuthentication().getApiKey())
                          .queryParam(NagiosServiceConstants.RECORDS, recordQueryParam)
                          .build())
              .retrieve()
              .onStatus(
                  HttpStatus::is4xxClientError,
                  clientResponse -> Mono.error(new Exception("Client Error")))
              .onStatus(
                  HttpStatus::is5xxServerError,
                  clientResponse -> Mono.error(new Exception("Error from Server")))
              .bodyToMono(ServiceStatusDto.class)
              .block();
      if (Objects.nonNull(serviceStatusDto)) {
        nagiosGrpcClient.transformServiceDataToCloudEvent(serviceStatusDto);
      }
      recordsToStartFrom += limit;
    } while (Objects.nonNull(serviceStatusDto) && serviceStatusDto.getRecordcount() == limit);
  }
}
