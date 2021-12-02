package com.wipro.nagios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.nagios.dto.HostStatusDto;
import com.wipro.nagios.dto.ServiceStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Service class that returns mocked Nagios Json responses
 *
 * @author NA20219458
 * @createdOn 14-10-2021
 */
@Service
public class NagiosService {

  @Autowired private ObjectMapper objectMapper;

  /**
   * Method to get Host information from Nagios XI
   *
   * @return - returns Host Status information
   */
  public HostStatusDto hostStatus() throws IOException {

    Resource resource = new ClassPathResource("nagios/host_status.json");

    InputStream input = resource.getInputStream();

    HostStatusDto filteredHostStatusDto;

    File hostStatusFile = resource.getFile();

    String formattedString =
        new String(Files.readAllBytes(hostStatusFile.toPath()))
            .replaceAll("DATE", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

    HostStatusDto hostStatusDto = objectMapper.readValue(formattedString, HostStatusDto.class);
    //hostStatusDto.getHoststatus().

    return hostStatusDto;
  }

  /**
   * Method to convert Service Status JSON Data into Java Objects
   *
   * @return ServiceStatusDto - Service Status Info
   * @throws IOException
   */
  public ServiceStatusDto serviceStatus() throws IOException {

    Resource resource = new ClassPathResource("nagios/service_status_5_56_MB.json");

    InputStream input = resource.getInputStream();

    ServiceStatusDto filteredServiceStatusDto;

    File hostStatusFile = resource.getFile();

    String formattedString =
            new String(Files.readAllBytes(hostStatusFile.toPath()))
                    .replaceAll("DATE", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

    ServiceStatusDto serviceStatusDto = objectMapper.readValue(formattedString, ServiceStatusDto.class);

    return serviceStatusDto;
  }
}
