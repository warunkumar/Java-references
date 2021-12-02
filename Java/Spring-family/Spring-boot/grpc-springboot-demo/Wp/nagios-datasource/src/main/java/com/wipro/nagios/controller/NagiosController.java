package com.wipro.nagios.controller;

import com.wipro.nagios.dto.HostStatusDto;
import com.wipro.nagios.dto.ServiceStatusDto;
import com.wipro.nagios.service.NagiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

/**
 * Controller Class that returns mocked Nagios Json responses
 *
 * @author NA20219458
 * @createdOn 14-10-2021
 */
@RestController
@RequestMapping(path = "/nagiosxi/api/v1/objects")
public class NagiosController {

  @Autowired private NagiosService nagiosService;

  @GetMapping(path = "/hoststatus", produces = MediaType.APPLICATION_JSON_VALUE)
  public HostStatusDto hostStatus() throws IOException {


    return nagiosService.hostStatus();
  }

  @GetMapping(path = "/servicestatus", produces = MediaType.APPLICATION_JSON_VALUE)
  public ServiceStatusDto serviceStatus() throws IOException {


    return nagiosService.serviceStatus();
  }
}
