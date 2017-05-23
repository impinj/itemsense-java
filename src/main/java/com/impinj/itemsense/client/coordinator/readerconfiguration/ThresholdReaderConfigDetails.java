package com.impinj.itemsense.client.coordinator.readerconfiguration;

import lombok.Builder;

public class ThresholdReaderConfigDetails extends ReaderBasicConfigDetails {
  @Builder
  private ThresholdReaderConfigDetails(
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
