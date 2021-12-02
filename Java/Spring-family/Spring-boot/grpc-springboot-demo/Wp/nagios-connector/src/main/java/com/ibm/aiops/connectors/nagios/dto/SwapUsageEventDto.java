package com.ibm.aiops.connectors.nagios.dto;

import lombok.*;

import java.util.List;

/**
 * @author Pola Vamsi Rahul
 * @createdOn 10-11-2021
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SwapUsageEventDto {
  private List<Group> groups;

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  @ToString
  public static class Group {
    private String timestamp;
    private String resourceID;
    private Metrics metrics;
    private Attributes attributes;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  @ToString
  public static class Attributes {
    private String group; //swap-usage
    private String node;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  @ToString
  public static class Metrics {
    private String used;
    private String free;
    private String total;
   }

}
