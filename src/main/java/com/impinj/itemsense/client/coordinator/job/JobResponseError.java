package com.impinj.itemsense.client.coordinator.job;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.impinj.itemsense.client.helpers.ZonedDateTimeSerialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobResponseError {

    @JsonDeserialize(using = ZonedDateTimeSerialization.class)
    private ZonedDateTime time;
    private String message;
}
