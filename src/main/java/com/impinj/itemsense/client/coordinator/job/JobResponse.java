package com.impinj.itemsense.client.coordinator.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.impinj.itemsense.client.coordinator.facility.Facility;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobResponse {
    private String id;
    private String status;
    private String [] readerNames;

    private ZonedDateTime creationTime;
    private ZonedDateTime lastActivityTime;
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
