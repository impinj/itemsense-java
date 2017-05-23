package com.impinj.itemsense.client.coordinator.readerconfiguration;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.Data;

@Data
@JsonSubTypes({
    @JsonSubTypes.Type(value = ThresholdReaderConfigDetails.class, name = "THRESHOLD"),
    @JsonSubTypes.Type(value = LocationReaderConfigDetails.class, name = "LOCATION"),
    @JsonSubTypes.Type(value = InventoryReaderConfigDetails.class, name = "INVENTORY"),
    @JsonSubTypes.Type(value = DoNothingReaderConfigDetails.class, name = "DO_NOTHING")
})
public abstract class ReaderConfigurationDetails {
}
