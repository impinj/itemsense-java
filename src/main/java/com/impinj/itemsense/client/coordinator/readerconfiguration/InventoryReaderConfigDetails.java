package com.impinj.itemsense.client.coordinator.readerconfiguration;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InventoryReaderConfigDetails extends ReaderConfigurationDetails {

  private ReaderMode readerMode;
  private Integer session;
  private SearchMode searchMode;
  private Integer tagPopulationEstimate;
  private Double transmitPowerInDbm;
  private Boolean polarization;
  private List<Integer> antennas;
  private Filter filter;
  private ChannelConfig channelConfig;
}
