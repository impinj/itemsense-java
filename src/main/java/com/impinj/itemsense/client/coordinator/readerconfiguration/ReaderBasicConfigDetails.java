package com.impinj.itemsense.client.coordinator.readerconfiguration;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReaderBasicConfigDetails extends ReaderConfigurationDetails {

  private SearchMode searchMode;
  private ReaderMode readerMode;
  private Integer session;
  private Double transmitPowerInDbm;
  private Filter filter;
  private Integer tagPopulationEstimate;
}
