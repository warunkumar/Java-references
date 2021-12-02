package com.ibm.aiops.connectors.nagios.dto;

import lombok.*;

import java.util.List;

/**
 * @author Naveen Devarajaiah
 * @createdOn 11/2/21
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HostStatusEventDto {

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
        private String group;
        private String node;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Metrics {
        private String rta;
        private String pl;
    }
}