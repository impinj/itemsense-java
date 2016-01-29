package com.impinj.itemsense.client.coordinator.job;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.impinj.itemsense.client.coordinator.facility.Facility;
import com.impinj.itemsense.client.helpers.ZonedDateTimeDeserializer;
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

    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime creationTime;
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private String lastActivityTime;
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private String lastHeartbeatTime;

    private String activeDuration;
    private boolean errorOccurred;
    private String[] errors;
    private Facility[] facilities;
    private Job job;
    //TODO:INSTANCE META DATA;
}
