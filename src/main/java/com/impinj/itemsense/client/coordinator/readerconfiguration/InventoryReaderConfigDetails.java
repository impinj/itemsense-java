package com.impinj.itemsense.client.coordinator.readerconfiguration;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InventoryReaderConfigDetails extends ReaderBasicConfigDetails {

  private List<Integer> antennas;

  @Builder
  public InventoryReaderConfigDetails(
      SearchMode searchMode,
      ReaderMode readerMode,
      Integer session,
      Double transmitPowerInDbm,
      Filter filter,
      Integer tagPopulationEstimate,
      Boolean polarization,
      List<Integer> antennas,
      ChannelConfig channelConfig) {

    super(searchMode, readerMode, session, transmitPowerInDbm,
          filter, tagPopulationEstimate, polarization, channelConfig);

    this.antennas = antennas;
  }
}
