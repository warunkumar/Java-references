package com.ibm.aiops.connectors.nagios.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Naveen Devarajaiah
 * @createdOn 11/2/21
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HostStatusDto {

    @JsonProperty("recordcount")
    private Integer recordcount;
    @JsonProperty("hoststatus")
    private List<Hoststatus> hoststatus = null;

    @Getter
    @Setter
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Hoststatus {

        @JsonProperty("host_object_id")
        private String hostObjectId;
        @JsonProperty("host_name")
        private String hostName;
        @JsonProperty("host_alias")
        private String hostAlias;
        @JsonProperty("display_name")
        private String displayName;
        @JsonProperty("address")
        private String address;
        @JsonProperty("icon_image")
        private String iconImage;
        @JsonProperty("icon_image_alt")
        private String iconImageAlt;
        @JsonProperty("notes")
        private String notes;
        @JsonProperty("notes_url")
        private String notesUrl;
        @JsonProperty("action_url")
        private String actionUrl;
        @JsonProperty("hoststatus_id")
        private String hoststatusId;
        @JsonProperty("instance_id")
        private String instanceId;
        @JsonProperty("status_update_time")
        private String statusUpdateTime;
        @JsonProperty("output")
        private String output;
        @JsonProperty("long_output")
        private String longOutput;
        @JsonProperty("perfdata")
        private String perfdata;
        @JsonProperty("current_state")
        private String currentState;
        @JsonProperty("has_been_checked")
        private String hasBeenChecked;
        @JsonProperty("should_be_scheduled")
        private String shouldBeScheduled;
        @JsonProperty("current_check_attempt")
        private String currentCheckAttempt;
        @JsonProperty("max_check_attempts")
        private String maxCheckAttempts;
        @JsonProperty("last_check")
        private String lastCheck;
        @JsonProperty("next_check")
        private String nextCheck;
        @JsonProperty("check_type")
        private String checkType;
        @JsonProperty("check_options")
        private String checkOptions;
        @JsonProperty("last_state_change")
        private String lastStateChange;
        @JsonProperty("last_hard_state_change")
        private String lastHardStateChange;
        @JsonProperty("last_hard_state")
        private String lastHardState;
        @JsonProperty("last_time_up")
        private String lastTimeUp;
        @JsonProperty("last_time_down")
        private String lastTimeDown;
        @JsonProperty("last_time_unreachable")
        private String lastTimeUnreachable;
        @JsonProperty("state_type")
        private String stateType;
        @JsonProperty("last_notification")
        private String lastNotification;
        @JsonProperty("next_notification")
        private String nextNotification;
        @JsonProperty("no_more_notifications")
        private String noMoreNotifications;
        @JsonProperty("notifications_enabled")
        private String notificationsEnabled;
        @JsonProperty("problem_has_been_acknowledged")
        private String problemHasBeenAcknowledged;
        @JsonProperty("acknowledgement_type")
        private String acknowledgementType;
        @JsonProperty("current_notification_number")
        private String currentNotificationNumber;
        @JsonProperty("passive_checks_enabled")
        private String passiveChecksEnabled;
        @JsonProperty("active_checks_enabled")
        private String activeChecksEnabled;
        @JsonProperty("event_handler_enabled")
        private String eventHandlerEnabled;
        @JsonProperty("flap_detection_enabled")
        private String flapDetectionEnabled;
        @JsonProperty("is_flapping")
        private String isFlapping;
        @JsonProperty("percent_state_change")
        private String percentStateChange;
        @JsonProperty("latency")
        private String latency;
        @JsonProperty("execution_time")
        private String executionTime;
        @JsonProperty("scheduled_downtime_depth")
        private String scheduledDowntimeDepth;
        @JsonProperty("failure_prediction_enabled")
        private String failurePredictionEnabled;
        @JsonProperty("process_performance_data")
        private String processPerformanceData;
        @JsonProperty("obsess_over_host")
        private String obsessOverHost;
        @JsonProperty("modified_host_attributes")
        private String modifiedHostAttributes;
        @JsonProperty("event_handler")
        private String eventHandler;
        @JsonProperty("check_command")
        private String checkCommand;
        @JsonProperty("normal_check_interval")
        private String normalCheckInterval;
        @JsonProperty("retry_check_interval")
        private String retryCheckInterval;
        @JsonProperty("check_timeperiod_object_id")
        private String checkTimeperiodObjectId;
    }
}
