package com.impinj.itemsense.client.coordinator.readerconfiguration;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class LocationReaderConfigDetails extends ReaderConfigurationDetails {

  private ReaderMode readerMode;
  private List<Integer> disabledAntennas;
  private Integer session;
  private Double transmitPowerInDbm;
  private Filter filter;

  @Builder
  public LocationReaderConfigDetails(
      ReaderMode readerMode,
      List<Integer> disabledAntennas,
      Integer session,
      Double transmitPowerInDbm,
      Filter filter) {

    this.readerMode = readerMode;
    this.disabledAntennas = disabledAntennas;
    this.session = session;
    this.transmitPowerInDbm = transmitPowerInDbm;
    this.filter = filter;
  }
}
