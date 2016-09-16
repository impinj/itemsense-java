package com.impinj.itemsense.client.coordinator.readerhealth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HealthEventQueueFilter {
    @JsonProperty("readerId")
    private String readerName;

    private HealthEventType type;

    private String code;
}
