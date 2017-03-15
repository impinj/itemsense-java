package com.impinj.itemsense.client.coordinator.readerconfiguration;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LocationReaderConfigDetails extends ReaderConfigurationDetails {

  private ReaderMode readerMode;
  private Integer session;
  private List<Integer> disabledAntennas;
  private Double transmitPowerInDbm;
  private Filter filter;
}
