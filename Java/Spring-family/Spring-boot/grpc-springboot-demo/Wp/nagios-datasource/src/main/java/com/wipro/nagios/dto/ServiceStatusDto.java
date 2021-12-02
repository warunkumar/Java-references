package com.wipro.nagios.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

/**
 * @author Pola Vamsi Rahul
 * @createdOn 09/11/2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServiceStatusDto {

  @JsonProperty("recordcount")
  private Integer recordcount;

  @JsonProperty("servicestatus")
  public List<Servicestatus> servicestatus;

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @ToString
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Servicestatus {

    @JsonProperty("host_name")
    public String hostName;

    @JsonProperty("service_description")
    public String serviceDescription;

    @JsonProperty("display_name")
    public String displayName;

    @JsonProperty("host_object_id")
    public String hostObjectId;

    @JsonProperty("host_address")
    public String hostAddress;

    @JsonProperty("host_alias")
    public String hostAlias;

    @JsonProperty("icon_image")
    public String iconImage;

    @JsonProperty("icon_image_alt")
    public String iconImageAlt;

    @JsonProperty("notes")
    public String notes;

    @JsonProperty("notes_url")
    public String notesUrl;

    @JsonProperty("action_url")
    public String actionUrl;

    @JsonProperty("servicestatus_id")
    public String servicestatusId;

    @JsonProperty("instance_id")
    public String instanceId;

    @JsonProperty("service_object_id")
    public String serviceObjectId;

    @JsonProperty("status_update_time")
    public String statusUpdateTime;

    @JsonProperty("output")
    public String output;

    @JsonProperty("long_output")
    public String longOutput;

    @JsonProperty("perfdata")
    public String perfdata;

    @JsonProperty("current_state")
    public String currentState;

    @JsonProperty("has_been_checked")
    public String hasBeenChecked;

    @JsonProperty("should_be_scheduled")
    public String shouldBeScheduled;

    @JsonProperty("current_check_attempt")
    public String currentCheckAttempt;

    @JsonProperty("max_check_attempts")
    public String maxCheckAttempts;

    @JsonProperty("last_check")
    public String lastCheck;

    @JsonProperty("next_check")
    public String nextCheck;

    @JsonProperty("check_type")
    public String checkType;

    @JsonProperty("check_options")
    public String checkOptions;

    @JsonProperty("last_state_change")
    public String lastStateChange;

    @JsonProperty("last_hard_state_change")
    public String lastHardStateChange;

    @JsonProperty("last_hard_state")
    public String lastHardState;

    @JsonProperty("last_time_ok")
    public String lastTimeOk;

    @JsonProperty("last_time_warning")
    public String lastTimeWarning;

    @JsonProperty("last_time_unknown")
    public String lastTimeUnknown;

    @JsonProperty("last_time_critical")
    public String lastTimeCritical;

    @JsonProperty("state_type")
    public String stateType;

    @JsonProperty("last_notification")
    public String lastNotification;

    @JsonProperty("next_notification")
    public String nextNotification;

    @JsonProperty("no_more_notifications")
    public String noMoreNotifications;

    @JsonProperty("notifications_enabled")
    public String notificationsEnabled;

    @JsonProperty("problem_has_been_acknowledged")
    public String problemHasBeenAcknowledged;

    @JsonProperty("acknowledgement_type")
    public String acknowledgementType;

    @JsonProperty("current_notification_number")
    public String currentNotificationNumber;

    @JsonProperty("passive_checks_enabled")
    public String passiveChecksEnabled;

    @JsonProperty("active_checks_enabled")
    public String activeChecksEnabled;

    @JsonProperty("event_handler_enabled")
    public String eventHandlerEnabled;

    @JsonProperty("flap_detection_enabled")
    public String flapDetectionEnabled;

    @JsonProperty("is_flapping")
    public String isFlapping;

    @JsonProperty("percent_state_change")
    public String percentStateChange;

    @JsonProperty("latency")
    public String latency;

    @JsonProperty("execution_time")
    public String executionTime;

    @JsonProperty("scheduled_downtime_depth")
    public String scheduledDowntimeDepth;

    @JsonProperty("failure_prediction_enabled")
    public String failurePredictionEnabled;

    @JsonProperty("process_performance_data")
    public String processPerformanceData;

    @JsonProperty("obsess_over_service")
    public String obsessOverService;

    @JsonProperty("modified_service_attributes")
    public String modifiedServiceAttributes;

    @JsonProperty("event_handler")
    public String eventHandler;

    @JsonProperty("check_command")
    public String checkCommand;

    @JsonProperty("normal_check_interval")
    public String normalCheckInterval;

    @JsonProperty("retry_check_interval")
    public String retryCheckInterval;

    @JsonProperty("check_timeperiod_object_id")
    public String checkTimeperiodObjectId;
  }
}
