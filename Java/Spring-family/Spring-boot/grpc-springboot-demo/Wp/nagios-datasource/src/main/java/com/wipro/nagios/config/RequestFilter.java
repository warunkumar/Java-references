package com.wipro.nagios.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

/**
 *Class to check for Authorization
 *
 * @author NA20219458
 * @createdOn 14-10-2021
 */
@Component
public class RequestFilter extends GenericFilterBean {

  private static final Logger LOGGER = LoggerFactory.getLogger(RequestFilter.class);

  @Override
  /**
   * Method to check for the Authorization Presence
   */
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;

    String path = request.getRequestURI();

    Map<String, String[]> paramsMap = request.getParameterMap();
    Optional<String> apiKeyOptional = Arrays.stream(paramsMap.get("apikey")).findFirst();

    if (apiKeyOptional.isPresent() && StringUtils.hasText(apiKeyOptional.get())) {
      LOGGER.info("Received API Key: {}", apiKeyOptional.get());
      filterChain.doFilter(servletRequest, servletResponse);
    } else {
      HttpServletResponse response = (HttpServletResponse) servletResponse;
      response.reset();
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.getWriter().write("API Key Required");
    }
  }
}
