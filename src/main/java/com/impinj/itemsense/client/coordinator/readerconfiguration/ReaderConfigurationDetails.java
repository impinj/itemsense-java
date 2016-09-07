package com.impinj.itemsense.client.coordinator.readerconfiguration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReaderConfigurationDetails {
  private ReaderMode readerMode;
  private SearchMode searchMode;
  private int session;
  private int tagPopulationEstimate;
  private boolean polarization;
  private int[] antennas;
  private Filter filter;
  private ChannelConfig channelConfig;
  private ReportConfig reportConfig;
}
