package com.impinj.itemsense.client.coordinator.readerconfiguration;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InventoryReaderConfigDetails extends ReaderBasicConfigDetails {

  private Boolean polarization;
  private List<Integer> antennas;
  private ChannelConfig channelConfig;

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
          filter, tagPopulationEstimate);

    this.polarization = polarization;
    this.antennas = antennas;
    this.channelConfig = channelConfig;
  }
}
