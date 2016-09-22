package com.impinj.itemsense.client.coordinator.readerhealth;

import java.time.ZonedDateTime;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HealthEventQuery {
    private Set<String> readerIds;

    private Set<String> types;

    private Set<String> codes;

    private ZonedDateTime fromTime;

    private ZonedDateTime toTime;

    private Integer pageSize = 100;

    private String nextPageMarker;
}
