package com.impinj.itemsense.client.coordinator.readerconfiguration;

import lombok.Builder;

public class DockDoorReaderConfigDetails extends ReaderBasicConfigDetails {
  @Builder
  private DockDoorReaderConfigDetails(
      SearchMode searchMode,
      ReaderMode readerMode,
      Integer session,
      Double transmitPowerInDbm,
      Filter filter,
      Integer tagPopulationEstimate) {

    super(searchMode, readerMode, session, transmitPowerInDbm,
          filter, tagPopulationEstimate);
  }
}
