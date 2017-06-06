package com.impinj.itemsense.client.coordinator.readerconfiguration;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ThresholdReaderConfigDetails extends ReaderBasicConfigDetails {

  @Builder
  private ThresholdReaderConfigDetails(
      SearchMode searchMode,
      ReaderMode readerMode,
      Integer session,
      Double transmitPowerInDbm,
      Filter filter,
      Integer tagPopulationEstimate,
      Boolean polarization,
      ChannelConfig channelConfig) {

    super(searchMode, readerMode, session, transmitPowerInDbm,
          filter, tagPopulationEstimate, polarization, channelConfig);
  }
}
