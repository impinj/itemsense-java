package com.impinj.itemsense.client.coordinator.readerconfiguration;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@JsonSubTypes({
        @JsonSubTypes.Type(value=LocationReaderConfigDetails.class, name="LOCATION"),
        @JsonSubTypes.Type(value=InventoryReaderConfigDetails.class, name="INVENTORY"),
        @JsonSubTypes.Type(value=DoNothingReaderConfigDetails.class, name="DO_NOTHING")
})
public abstract class ReaderConfigurationDetails {
}
