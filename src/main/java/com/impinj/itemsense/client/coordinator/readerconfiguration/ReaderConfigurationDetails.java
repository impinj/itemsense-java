package com.impinj.itemsense.client.coordinator.readerconfiguration;

import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonSubTypes({
    @JsonSubTypes.Type(value = ThresholdReaderConfigDetails.class, name = "THRESHOLD"),
    @JsonSubTypes.Type(value = LocationReaderConfigDetails.class, name = "LOCATION"),
    @JsonSubTypes.Type(value = InventoryReaderConfigDetails.class, name = "INVENTORY"),
    @JsonSubTypes.Type(value = DoNothingReaderConfigDetails.class, name = "DO_NOTHING")
})
public abstract class ReaderConfigurationDetails {

  public ReaderConfigurationDetails() {}

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ReaderConfigurationDetails)) {
      return false;
    }
    final ReaderConfigurationDetails other = (ReaderConfigurationDetails) o;
    return true;
  }

  public int hashCode() {
    return 1;
  }

  public String toString() {return "com.impinj.itemsense.client.coordinator.readerconfiguration.ReaderConfigurationDetails()";}
}
