package com.impinj.itemsense.client.coordinator.readerconfiguration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class ReaderBasicConfigDetails extends ReaderConfigurationDetails {
  private SearchMode searchMode;
  private ReaderMode readerMode;
  private Integer session;
  private Double transmitPowerInDbm;
  private Filter filter;
  private Integer tagPopulationEstimate;
}
