package com.impinj.itemsense.client.coordinator.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.impinj.itemsense.client.coordinator.facility.Facility;
import com.impinj.itemsense.client.helpers.ZonedDateTimeSerialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

/**
 * Created by jcombopi on 1/29/16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobResponse {
    private String id;
    private String status;
    private String [] readerNames;
    private String connectionType;

    @JsonDeserialize(using = ZonedDateTimeSerialization.class)
    private ZonedDateTime creationTime;
    @JsonDeserialize(using = ZonedDateTimeSerialization.class)
    private ZonedDateTime lastActivityTime;
    @JsonDeserialize(using = ZonedDateTimeSerialization.class)
    private ZonedDateTime lastHeartbeatTime;

    private String activeDuration;
    private boolean errorOccurred;
    private JobResponseError[] errors;
    private int maxErrors;
    private String stopReason;
    private Facility[] facilities;
    private Job job;
    private int startAttempts;
    //TODO:INSTANCE META DATA;

    @JsonIgnore
    public JobStatus getJobStatusAsEnum() {
        try {
            return JobStatus.valueOf(status);
        } catch (java.lang.IllegalArgumentException e) {
            return JobStatus.UNKNOWN;
        }
    }

    @JsonIgnore
    public JobStopReason getJobStopReasonAsEnum() {
        try {
            return JobStopReason.valueOf(status);
        } catch (java.lang.IllegalArgumentException e) {
            return JobStopReason.UNKNOWN;
        }
    }

}
