package com.impinj.itemsense.client.coordinator.readerhealth;

import java.time.ZonedDateTime;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthEvent {

    private ZonedDateTime eventTime;

    private String readerId;

    private HealthEventType type;

    private String code;

    private Map<String, String> args;
}
